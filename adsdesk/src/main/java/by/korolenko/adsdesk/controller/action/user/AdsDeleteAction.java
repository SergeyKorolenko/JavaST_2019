package by.korolenko.adsdesk.controller.action.user;

import by.korolenko.adsdesk.bean.enums.EntityType;
import by.korolenko.adsdesk.controller.action.Action;
import by.korolenko.adsdesk.service.AdsService;
import by.korolenko.adsdesk.service.exception.ServiceException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AdsDeleteAction extends Action {
    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp) {
        AdsService adsService = factory.createService(EntityType.ADS);
        String adsId = req.getParameter("adsId");
        try {
            adsService.delete(Integer.parseInt(adsId));
            setRedirect(true);
            return "/main.jsp";
        } catch (ServiceException e) {
            return "/error.jsp";
        }
    }
}
