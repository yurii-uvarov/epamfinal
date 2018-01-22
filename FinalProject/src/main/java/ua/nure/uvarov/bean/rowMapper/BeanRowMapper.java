package ua.nure.uvarov.bean.rowMapper;


import javax.servlet.http.HttpServletRequest;

public interface BeanRowMapper<T> {
    T mapRow(HttpServletRequest request);

}
