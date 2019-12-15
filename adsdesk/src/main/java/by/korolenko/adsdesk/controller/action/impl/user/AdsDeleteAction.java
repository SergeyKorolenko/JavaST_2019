package by.korolenko.adsdesk.controller.action.impl.user;

import by.korolenko.adsdesk.bean.enums.EntityType;
import by.korolenko.adsdesk.controller.action.AuthorizedUserAction;
import by.korolenko.adsdesk.controller.action.UserAction;
import by.korolenko.adsdesk.service.AdsService;
import by.korolenko.adsdesk.service.exception.ServiceException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AdsDeleteAction extends UserAction {
    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp) {
        String adsId = req.getParameter("adsId");
        if (adsId != null) {
            try {
                AdsService adsService = factory.createService(EntityType.ADS);
                adsService.delete(Integer.parseInt(adsId));
                setRedirect(true);
                return "/main.html";
            } catch (ServiceException | NumberFormatException e) {
                return "/error.jsp";
            }
        }
        return "/error.jsp";
    }
}
