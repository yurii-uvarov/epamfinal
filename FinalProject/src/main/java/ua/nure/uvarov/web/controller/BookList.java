package ua.nure.uvarov.web.controller;

import ua.nure.uvarov.constants.Parameters;
import ua.nure.uvarov.services.BookLayer;
import ua.nure.uvarov.util.ValidateUtil;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.Map;

@WebServlet("/book-list.do")
public class BookList extends HttpServlet {
    private BookLayer bookLayer;
    private ValidateUtil validateUtil;


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        requestHandler(req, resp);
        URL url = new URL(req.getRequestURL().toString());

        String realPath = url.getPath();
        System.out.println(realPath);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }

    @Override
    public void init(ServletConfig config) throws ServletException {
       bookLayer = (BookLayer) config.getServletContext().getAttribute(Parameters.);
        validateUtil = new ValidateUtil();

    }

    private void requestHandler(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int amount;
        int offset;
        try {
            amount = Integer.parseInt(request.getParameter(Parameters.AMOUNT));
        } catch (NumberFormatException e) {
            amount = 6;
        }
        try {
            offset = Integer.parseInt(request.getParameter(Parameters.OFFSET));
        } catch (NumberFormatException e) {
            offset = 0;
        }

        offset = offset < 0 ? 0 : offset;
        amount = amount < 0 ? 6 : amount;

        FilterParams filterParams = getFilterParam(request);
        System.out.println(filterParams);
        correctFilterBean(filterParams);
        UrlBuilder urlBuilder = new UrlBuilder();
        urlBuilder.build(filterParams);
        String url = urlBuilder.toString();


        List<String> categories = productLayer.getCategories();
        List<String> manufacturers = productLayer.getManufacturers();
        List<Product> productList = productLayer.findProductsByCondition(filterParams, amount, offset);
        int count = productLayer.getCountByCondition(filterParams);

        request.setAttribute(Parameters.PRODUCT_CATEGORIES, categories);
        request.setAttribute(Parameters.PRODUCT_MANUFACTURERS, manufacturers);
        request.setAttribute(Parameters.PRODUCT_LIST, productList);
        request.setAttribute(Parameters.PRODUCT_COUNT, count);
        request.setAttribute(Parameters.AMOUNT, amount);
        request.setAttribute(Parameters.OFFSET, offset);
        request.setAttribute(Parameters.FILTER_PARAMETERS, filterParams);
        request.setAttribute(Parameters.QUERY_URL, url);
        request.getRequestDispatcher("shop.jsp").forward(request, response);

    }

    private FilterParams getFilterParam(HttpServletRequest request) {
        DozerBeanMapper mapper = (DozerBeanMapper) request.getServletContext().getAttribute("mapper");
        Map<String, String[]> paramMap = request.getParameterMap();

        return mapper.map(paramMap, FilterParams.class);
    }

    private void correctFilterBean(FilterParams filterParams) {
        if (!validateUtil.validateByRegex(filterParams.getName(), CommonConstants.PRODUCT_NAME_PATTERN)){
            filterParams.setName(Parameters.DEFAULT_PARAMETER_VALUE);
        }
        if(!validateUtil.validateByRegex(filterParams.getMinPrice(),CommonConstants.PRODUCT_PRICE_PATTERN)){
            filterParams.setMinPrice(Parameters.DEFAULT_PARAMETER_VALUE);
        }
        if(!validateUtil.validateByRegex(filterParams.getMaxPrice(),CommonConstants.PRODUCT_PRICE_PATTERN)){
            filterParams.setMaxPrice(Parameters.DEFAULT_PARAMETER_VALUE);
        }
    }


}
