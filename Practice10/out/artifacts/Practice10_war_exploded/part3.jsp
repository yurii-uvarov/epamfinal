<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Title</title>
</head>
<body>
<form id="»м€шко" action="/name" method="post">
    <p>
        <input name="name">
        <input type="submit" value="submit">
    </p>
</form>
${sessionScope.names}
</body>
</html>
