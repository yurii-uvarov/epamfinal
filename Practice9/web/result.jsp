<%--
  Created by IntelliJ IDEA.
  User: uvaro
  Date: 28.12.2017
  Time: 20:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Result</title>
</head>
<body>
<%Integer sum = (Integer) request.getAttribute("sum"); %>
<%= sum%>
<a href="calc.html">Calc</a>
</body>
</html>
