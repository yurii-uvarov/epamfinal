<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<table border="2">

    <%for (int i = 0; i < 10; i++) {%>
    <tr>
        <%for (int j = 0; j < 10; j++) {%>
        <td>
            <%if (j != 0 || i != 0) {%>
            <%if (j == 0) {%>
            <%=i%>
            <%
                    continue;
                }
                if (i == 0) {
            %>
            <%=j%>
            <%} if ( i != 0) { %>
            <%=i * j%>
            <%}}%>
        </td>
        <%}%>

    </tr>


    <%}%>
</table>
</body>
</html>
