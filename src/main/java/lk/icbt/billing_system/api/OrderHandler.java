package lk.icbt.billing_system.api;

import jakarta.json.bind.Jsonb;
import jakarta.json.bind.JsonbBuilder;
import lk.icbt.billing_system.dto.ItemDTO;
import lk.icbt.billing_system.dto.OrderDTO;
import lk.icbt.billing_system.dto.RespondsDTO;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class OrderHandler extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Jsonb jsonb = JsonbBuilder.create();
        OrderDTO orderDTO = jsonb.fromJson(req.getReader(), OrderDTO.class);

        System.out.println(orderDTO.toString());
        System.out.println(orderDTO.getOrderDetails().toString());

        jsonb.toJson(new RespondsDTO(400, "Item not updated!",""), resp.getWriter());

    }
}
