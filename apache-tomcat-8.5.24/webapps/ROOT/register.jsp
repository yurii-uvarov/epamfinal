<%@ include file="/WEB-INF/jspf/directive/page.jspf"%>
<%@ include file="/WEB-INF/jspf/directive/taglib.jspf"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="t"%>
<%@ include file="/WEB-INF/jspf/directive/head.jspf"%>
<!DOCTYPE html>
<html lang="en">
<t:header/>



<body>
<div class="container">

    <form class="form-signin" role="form" method="post" action="register.do">
        <h2 class="form-signin-heading">Registration</h2>
        <input name="email" type="email" class="form-control" placeholder="Email address" required="" autofocus="">
        <input name="password" type="password" class="form-control" placeholder="Password" required="">
        <input name="passwordrepeat" type="password" class="form-control" placeholder=" Repeat password" required="">
        <input name="firstname" type="text" class="form-control" placeholder="Name" required="">
        <input name="lastname" type="text" class="form-control" placeholder="Surname" required="">

        <button class="btn btn-lg btn-primary btn-block" type="submit">Sign in</button>
    </form>

</div> <!-- /container -->

<!-- jQuery -->
<script src="js/jquery.js"></script>

<!-- Bootstrap Core JavaScript -->
<script src="js/bootstrap.min.js"></script>

</body>

</html>