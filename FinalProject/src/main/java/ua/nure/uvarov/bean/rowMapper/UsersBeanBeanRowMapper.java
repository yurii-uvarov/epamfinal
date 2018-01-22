package ua.nure.uvarov.bean.rowMapper;


import ua.nure.uvarov.bean.UsersBean;
import ua.nure.uvarov.constants.Parameters;

import javax.servlet.http.HttpServletRequest;

public class UsersBeanBeanRowMapper implements BeanRowMapper<UsersBean> {

	@Override
    public UsersBean mapRow(HttpServletRequest request) {
        UsersBean usersBean = new UsersBean();
        usersBean.setEmail(request.getParameter(Parameters.EMAIL));
        usersBean.setPassword(request.getParameter(Parameters.PASSWORD));
        usersBean.setPasswordRepeat(request.getParameter(Parameters.PASSWORD));
        usersBean.setFirstName(request.getParameter(Parameters.FIRST_NAME));
        usersBean.setLastName(request.getParameter(Parameters.LAST_NAME));
        return usersBean;
    }
}
