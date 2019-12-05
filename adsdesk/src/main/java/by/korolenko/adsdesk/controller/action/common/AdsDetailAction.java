package by.korolenko.adsdesk.controller.action.common;

import by.korolenko.adsdesk.bean.Ads;
import by.korolenko.adsdesk.bean.Comment;
import by.korolenko.adsdesk.bean.enums.EntityType;
import by.korolenko.adsdesk.controller.action.Action;
import by.korolenko.adsdesk.service.AdsService;
import by.korolenko.adsdesk.service.CommentService;
import by.korolenko.adsdesk.service.exception.ServiceException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class AdsDetailAction extends Action {
    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp) {
        String id = req.getParameter("adsDetail");
        AdsService adsService = factory.createService(EntityType.ADS);
        try {
            Ads ads = adsService.findById(Integer.parseInt(id));
            CommentService commentService = factory.createService(EntityType.COMMENT);
            List<Comment> comments = commentService.findByAdsId(ads.getId());
            req.setAttribute("ads", ads);
            req.setAttribute("comments", comments);
            return "/detail.jsp";
        } catch (ServiceException | NumberFormatException e) {
            return "/error.jsp";
        }
    }
}
