<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<table border="2">

    <c:forEach begin="0" end="9" var="i">
        <tr>
            <c:forEach begin="0" end="9" var="j">
            <td>
                <c:if test="${j != 0 || i!=0}">
                    <c:if test="${j == 0}">
                        ${i}
                    </c:if>
                    <c:if test="${i == 0}">
                        ${j}
                    </c:if>
                    <c:if test="${i!=0 && j!=0}">
                        ${j*i}
                    </c:if>
                </c:if>

            </td>
            </c:forEach>
        </tr>
    </c:forEach>


</table>
</body>
</html>
