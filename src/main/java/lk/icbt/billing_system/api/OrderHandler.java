package lk.icbt.billing_system.api;

import jakarta.json.bind.Jsonb;
import jakarta.json.bind.JsonbBuilder;
import lk.icbt.billing_system.dao.exception.ConstrainViolationException;
import lk.icbt.billing_system.dto.ItemDTO;
import lk.icbt.billing_system.dto.OrderDTO;
import lk.icbt.billing_system.dto.RespondsDTO;
import lk.icbt.billing_system.service.ServiceFactory;
import lk.icbt.billing_system.service.ServiceTypes;
import lk.icbt.billing_system.service.custome.ItemService;
import lk.icbt.billing_system.service.custome.OrderService;
import lk.icbt.billing_system.service.exception.NotFoundException;
import org.apache.commons.dbcp2.BasicDataSource;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

public class OrderHandler extends HttpServlet {

    private OrderService orderService;
    private BasicDataSource bds;

    public void init() {
        bds = (BasicDataSource) this.getServletContext().getAttribute("bds");

        orderService = (OrderService) ServiceFactory.getServiceFactory().getService(ServiceTypes.ORDER,bds);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Jsonb jsonb = JsonbBuilder.create();
        OrderDTO orderDTO = jsonb.fromJson(req.getReader(), OrderDTO.class);

        System.out.println(orderDTO.toString());
        System.out.println(orderDTO.getOrderDetails().toString());

        // call order service add method
        try {

            orderService.addNewOrder(orderDTO);
            jsonb.toJson(new RespondsDTO(200, "Order successfully recoded!",""), resp.getWriter());

        }catch (SQLException | NotFoundException | ConstrainViolationException e){

            resp.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            jsonb.toJson(new RespondsDTO(400, "Order not record!", e.getLocalizedMessage()), resp.getWriter());
        }



    }
}
