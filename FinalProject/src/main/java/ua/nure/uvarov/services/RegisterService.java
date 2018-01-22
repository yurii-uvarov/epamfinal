package ua.nure.uvarov.services;


import ua.nure.uvarov.bean.UsersBean;
import ua.nure.uvarov.bean.rowMapper.BeanRowMapper;
import ua.nure.uvarov.bean.rowMapper.RegisterUserBeanRowMapper;
import ua.nure.uvarov.bean.rowMapper.UsersBeanBeanRowMapper;
import ua.nure.uvarov.constants.Messages;
import ua.nure.uvarov.constants.Parameters;
import ua.nure.uvarov.entity.User;
import ua.nure.uvarov.util.ValidateUtil;


import javax.servlet.http.HttpServletRequest;
import java.util.Map;

public class RegisterService {


    public void setBean(HttpServletRequest req) {
        UsersBean usersBean = (UsersBean) req.getSession().getAttribute(Parameters.S_BEAN);
        if (usersBean == null) {
            req.setAttribute(Parameters.BEAN, new UsersBean());
        } else {
            req.setAttribute(Parameters.BEAN, usersBean);
        }
        req.getSession().removeAttribute(Parameters.S_BEAN);
    }

    public void setMap(HttpServletRequest request) {
        Map<String, String> map = (Map<String, String>) request.getSession().getAttribute(Parameters.S_ERRORS);
        request.setAttribute(Parameters.ERRORS, map);
        request.getSession().removeAttribute(Parameters.S_ERRORS);
    }


    public UsersBean getUserBean(HttpServletRequest request) {
        BeanRowMapper<UsersBean> beanBeanRowMapper = new UsersBeanBeanRowMapper();
        return beanBeanRowMapper.mapRow(request);
    }

    public User getUser(HttpServletRequest request) {
        BeanRowMapper<User> userBeanRowMapper = new RegisterUserBeanRowMapper();
        return userBeanRowMapper.mapRow(request);
    }

    public Map<String, String> getErrorMap(HttpServletRequest request, UserService userService) {
        UsersBean usersBean = getUserBean(request);
        Map<String, String> errors = new ValidateUtil().validateBean(usersBean);
        if (userService.isExist(usersBean.getEmail())) {
            errors.put(Parameters.USER_ERR_MESSAGE, Messages.CANNOT_CREATE_USER);
        }
        return errors;
    }


}


