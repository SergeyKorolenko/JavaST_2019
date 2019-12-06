package by.korolenko.adsdesk.controller.action.user;

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
        String comment = req.getParameter("comment");
        String adsId = req.getParameter("adsId");
        String userId = req.getParameter("userId");
        Comment comment1 = new Comment();
        comment1.setComment(comment);
        comment1.setAddedDate(new Date());
        Ads ads = new Ads();
        ads.setId(Integer.parseInt(adsId));
        comment1.setAds(ads);
        User user = new User();
        user.setId(Integer.parseInt(userId));
        comment1.setUser(user);
        CommentService commentService = factory.createService(EntityType.COMMENT);
        try {
            commentService.add(comment1);
            setRedirect(true);
            return "/main.html";
        } catch (ServiceException e) {
            return "/error.jsp";
        }
    }
}
