package lk.icbt.billing_system.api;
//
//import java.io.*;
//import jakarta.servlet.http.*;
//import jakarta.servlet.annotation.*;
//
//@WebServlet(name = "helloServlet", value = "/hello-servlet")
//public class HelloServlet extends HttpServlet {
//    private String message;
//
//    public void init() {
//        message = "Hello World!";
//    }
//
//    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
//        response.setContentType("text/html");
//
//        // Hello
//        PrintWriter out = response.getWriter();
//        out.println("<html><body>");
//        out.println("<h1>" + message + "</h1>");
//        out.println("</body></html>");
//    }
//
//    public void destroy() {
//    }
//}


import jakarta.json.bind.Jsonb;
import jakarta.json.bind.JsonbBuilder;
import lk.icbt.billing_system.dto.CustomerDTO;
import lk.icbt.billing_system.dto.RespondsDTO;
import lk.icbt.billing_system.service.ServiceFactory;
import lk.icbt.billing_system.service.ServiceTypes;
import lk.icbt.billing_system.service.custome.CustomerService;
import org.apache.commons.dbcp2.BasicDataSource;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CustomerHandler extends HttpServlet{

    private CustomerService customerService;
    private BasicDataSource bds;

    public void init() {
        bds = (BasicDataSource) this.getServletContext().getAttribute("bds");

        customerService = (CustomerService) ServiceFactory.getServiceFactory().getService(ServiceTypes.CUSTOMER,bds);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter writer = resp.getWriter();


        try {
            BasicDataSource bds = (BasicDataSource) req.getServletContext().getAttribute("bds");
            Connection connection = bds.getConnection();//get connection from the connection pool
            ResultSet resultSet = connection.prepareStatement("SELECT * FROM customer").executeQuery();
            while (resultSet.next()) {
                System.out.println(resultSet.getString(1));
            }
            connection.close();//return the connection to the connection pool from the consumer pool
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        writer.print("do method invoked");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        // ensure req type is json
        if (req.getContentType() == null || !req.getContentType().toLowerCase().startsWith("application/json")) {
            resp.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED);
        }

        // set resp type to json
        resp.setContentType("application/json");

        Jsonb jsonb = JsonbBuilder.create();
        CustomerDTO customerDTO = jsonb.fromJson(req.getReader(), CustomerDTO.class);

        System.out.println(customerDTO.toString());

       try {
           // call service class
           if (customerService.addNewCustomer(customerDTO)){
               jsonb.toJson(
                       new RespondsDTO(
                               200,
                               "Customer successfully added!",
                               ""), resp.getWriter());
           }
       }catch (SQLException e){
           e.printStackTrace();
           jsonb.toJson(new RespondsDTO(400, "Error !", e.getLocalizedMessage()), resp.getWriter());
       }

    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        // ensure req type is json
        if (req.getContentType() == null || !req.getContentType().toLowerCase().startsWith("application/json")) {
            resp.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED);
        }

        // set resp type to json
        resp.setContentType("application/json");

        Jsonb jsonb = JsonbBuilder.create();
        CustomerDTO customerDTO = jsonb.fromJson(req.getReader(), CustomerDTO.class);

        System.out.println(customerDTO.toString());

        try {
            // call service class
            CustomerDTO updateCustomer = customerService.updateCustomer(customerDTO);
            if (updateCustomer!=null){
                jsonb.toJson(
                        new RespondsDTO(
                                200,
                                "Customer successfully updated!",
                                updateCustomer), resp.getWriter());
            }else {
                jsonb.toJson(new RespondsDTO(400, "Customer not updated !",""), resp.getWriter());
            }
        }catch (SQLException e){
            e.printStackTrace();
            jsonb.toJson(new RespondsDTO(400, "Error !", e.getLocalizedMessage()), resp.getWriter());
        }

    }
}