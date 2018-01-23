<%@ tag body-content="empty" language="java" pageEncoding="UTF-8" %>
<%@ include file="/WEB-INF/jspf/directive/taglib.jspf"%>

<header id="header">
    <nav class="navbar navbar navbar-fixed-top" role="navigation">
        <div class="container">
            <!-- Brand and toggle get grouped for better mobile display -->
            <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse"
                        data-target="#bs-example-navbar-collapse-1">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href="#">Library</a>
            </div>
            <!-- Collect the nav links, forms, and other content for toggling -->
            <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                <ul class="nav navbar-nav">
                    <li>
                        <a href="#">About</a>
                    </li>
                    <c:choose>
                    <c:when test="${not empty sessionScope.s_user}">
                        <li
                                class="login"><a href="#">${sessionScope.s_user.email} <i class="fa fa-user"></i></a>
                        </li>
                        <li>
                            <a href="logout.do"><i class="fa fa-lock"></i> LogOut</a>
                        </li>
                    </c:when>
                    <c:otherwise>
                        <li>
                            <a href="register.jsp">Register</a>
                        </li>
                        <li>
                            <a href="login.jsp">Login</a>
                        </li>
                    </c:otherwise>
                    </c:choose>
                </ul>
            </div>
            <!-- /.navbar-collapse -->
        </div>
        <!-- /.container -->
    </nav>
</header>