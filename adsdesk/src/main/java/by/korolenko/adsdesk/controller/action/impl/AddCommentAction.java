package by.korolenko.adsdesk.controller.action.impl;

import by.korolenko.adsdesk.bean.Ads;
import by.korolenko.adsdesk.bean.Comment;
import by.korolenko.adsdesk.bean.User;
import by.korolenko.adsdesk.bean.enums.EntityType;
import by.korolenko.adsdesk.controller.action.Action;
import by.korolenko.adsdesk.service.CommentService;
import by.korolenko.adsdesk.service.exception.ServiceException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;

public class AddCommentAction extends Action {

    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp) {
        String commentTest = req.getParameter("comment");
        String adsId = req.getParameter("adsId");
        String userId = req.getParameter("userId");
        if (commentTest != null && adsId != null && userId != null) {
            Comment comment = new Comment();
            comment.setComment(commentTest);
            comment.setAddedDate(new Date());
            Ads ads = new Ads();
            User user = new User();
            try {
                ads.setId(Integer.parseInt(adsId));
                comment.setAds(ads);
                user.setId(Integer.parseInt(userId));
                comment.setUser(user);
                CommentService commentService = factory.createService(EntityType.COMMENT);
                commentService.add(comment);
                setRedirect(true);
                return "/ads/detail.html?adsId=" + adsId;
            } catch (ServiceException | NumberFormatException e) {
                return "/error.jsp";
            }
        }
        return "error.jsp";
    }
}
