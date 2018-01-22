package ua.nure.uvarov.bean.rowMapper;



import ua.nure.uvarov.constants.Parameters;
import ua.nure.uvarov.entity.User;

import javax.servlet.http.HttpServletRequest;

public class RegisterUserBeanRowMapper implements BeanRowMapper<User> {

    @Override
    public User mapRow(HttpServletRequest request) {
        User user = new User();
        user.setEmail(request.getParameter(Parameters.EMAIL));
        user.setPassword(request.getParameter(Parameters.PASSWORD));
        user.setLastName(request.getParameter(Parameters.LAST_NAME));
        user.setFirstName(request.getParameter(Parameters.FIRST_NAME));
        user.setRole(Parameters.ROLE_CLIENT);
        return user;
    }

}
