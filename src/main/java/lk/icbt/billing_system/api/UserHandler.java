package lk.icbt.billing_system.api;

import lk.icbt.billing_system.service.ServiceFactory;
import lk.icbt.billing_system.service.ServiceTypes;
import lk.icbt.billing_system.service.custome.ItemService;
import org.apache.commons.dbcp2.BasicDataSource;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class UserHandler extends HttpServlet {

    private ItemService itemService;
    private BasicDataSource bds;

    public void init() {
        bds = (BasicDataSource) this.getServletContext().getAttribute("bds");

        itemService = (ItemService) ServiceFactory.getServiceFactory().getService(ServiceTypes.ITEM,bds);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
