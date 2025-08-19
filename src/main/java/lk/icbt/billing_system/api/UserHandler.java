package lk.icbt.billing_system.api;

import jakarta.json.bind.Jsonb;
import jakarta.json.bind.JsonbBuilder;
import lk.icbt.billing_system.dao.exception.ConstrainViolationException;
import lk.icbt.billing_system.dto.OrderDTO;
import lk.icbt.billing_system.dto.RespondsDTO;
import lk.icbt.billing_system.dto.UserDTO;
import lk.icbt.billing_system.service.ServiceFactory;
import lk.icbt.billing_system.service.ServiceTypes;
import lk.icbt.billing_system.service.custome.ItemService;
import lk.icbt.billing_system.service.custome.UserService;
import lk.icbt.billing_system.service.exception.NotFoundException;
import org.apache.commons.dbcp2.BasicDataSource;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

public class UserHandler extends HttpServlet {

    private UserService userService;
    private BasicDataSource bds;

    public void init() {
        bds = (BasicDataSource) this.getServletContext().getAttribute("bds");

        userService = (UserService) ServiceFactory.getServiceFactory().getService(ServiceTypes.USER,bds);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Jsonb jsonb = JsonbBuilder.create();
        try {

            UserDTO userDTO = jsonb.fromJson(req.getReader(), UserDTO.class);

            boolean verifyPassword = userService.verifyPassword(userDTO);

            if (verifyPassword) {
                resp.setStatus(HttpServletResponse.SC_OK);
                jsonb.toJson(new RespondsDTO(200, "Login successfully", ""), resp.getWriter());
            } else {
                resp.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
                jsonb.toJson(new RespondsDTO(401, "Invalid password!", ""), resp.getWriter());
            }


        } catch (SQLException | NotFoundException | ConstrainViolationException e) {
            resp.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            jsonb.toJson(new RespondsDTO(400, "Login Failed!", e.getLocalizedMessage()), resp.getWriter());
        }

    }
}
