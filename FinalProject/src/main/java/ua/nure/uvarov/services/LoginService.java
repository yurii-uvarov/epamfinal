package ua.nure.uvarov.services;

import ua.nure.uvarov.bean.rowMapper.BeanRowMapper;
import ua.nure.uvarov.bean.rowMapper.RegisterUserBeanRowMapper;
import ua.nure.uvarov.constants.Parameters;
import ua.nure.uvarov.entity.User;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

public class  LoginService {
    public User getUser(HttpServletRequest request) {
        BeanRowMapper<User> userBeanRowMapper = new RegisterUserBeanRowMapper();
        return userBeanRowMapper.mapRow(request);
    }

    public void setMap(HttpServletRequest request) {
        Map<String, String> map = (Map<String, String>) request.getSession().getAttribute(Parameters.S_ERRORS);
        request.setAttribute(Parameters.ERRORS_LOGIN, map);
        request.getSession().removeAttribute(Parameters.S_ERRORS);
    }
}
