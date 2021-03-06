package by.korolenko.adsdesk.controller.action.impl.alluser;

import by.korolenko.adsdesk.bean.Ads;
import by.korolenko.adsdesk.bean.Comment;
import by.korolenko.adsdesk.bean.User;
import by.korolenko.adsdesk.bean.enums.EntityType;
import by.korolenko.adsdesk.controller.action.AllUserAction;
import by.korolenko.adsdesk.controller.manager.PagePathManager;
import by.korolenko.adsdesk.service.AdsService;
import by.korolenko.adsdesk.service.CommentService;
import by.korolenko.adsdesk.service.UserService;
import by.korolenko.adsdesk.service.exception.ServiceException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * @author Sergei Korolenko
 * @version 1.0
 */
public class AdsDetailAction extends AllUserAction {
    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp) {
        String id = req.getParameter("adsId");
        if (id != null) {
            try {
                AdsService adsService = factory.createService(EntityType.ADS);
                Ads ads = adsService.findById(Integer.parseInt(id));
                CommentService commentService = factory.createService(EntityType.COMMENT);
                List<Comment> comments = commentService.findByAdsId(ads.getId());
                UserService userService = factory.createService(EntityType.USER);
                User user = userService.findById(ads.getUser().getId());
                Integer commentCount = commentService.countOfComment(ads.getId());
                req.setAttribute("commentCount", commentCount);
                req.setAttribute("user", user);
                req.setAttribute("ads", ads);
                req.setAttribute("comments", comments);
                return PagePathManager.getProperty("path.page.detail");
            } catch (ServiceException | NumberFormatException e) {
                return PagePathManager.getProperty("path.page.error");
            }
        }
        return PagePathManager.getProperty("path.page.error");
    }
}
