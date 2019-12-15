package by.korolenko.adsdesk.controller.action.impl.authorized;

import by.korolenko.adsdesk.bean.User;
import by.korolenko.adsdesk.bean.enums.EntityType;
import by.korolenko.adsdesk.controller.action.AuthorizedUserAction;
import by.korolenko.adsdesk.service.UserService;
import by.korolenko.adsdesk.service.exception.ServiceException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Sergei Korolenko
 * @version 1.0
 */
public class UserInfoUpdateAction extends AuthorizedUserAction {
    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp) {
        String name = req.getParameter("name");
        String surname = req.getParameter("surname");
        String patronymic = req.getParameter("patronymic");
        String phone = req.getParameter("phone");
        try {
            UserService userService = factory.createService(EntityType.USER);
            if (name != null && phone != null) {
                User user = new User();
                user.setName(name);
                if (surname.length() != 0) {
                    user.setSurname(surname);
                }
                if (patronymic.length() != 0) {
                    user.setPatronymic(patronymic);
                }
                user.setPhone(Long.parseLong(phone));
                User authorized = (User) req.getSession().getAttribute("authorizedUser");
                user.setId(authorized.getId());
                userService.update(user);
                setHeader(true);
                setRedirect(true);
                return req.getHeader("referer");
            }
        } catch (ServiceException | NumberFormatException e) {
            return "/error.jsp";
        }
        return "/error.jsp";
    }
}
