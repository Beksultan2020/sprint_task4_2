<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL"
            crossorigin="anonymous"></script>
</head>
<body>
<%@include file="navbar.jsp" %>
<form action="/registerShop" method="post">
<div class="mb-3">
    <div class="mb-3">
        <label for="exampleInputPassword1" class="form-label">FullName</label>
        <input type="text" name="FullName" class="form-control">
    </div>
    <label for="exampleInputEmail1" class="form-label">Email address</label>
    <input type="email" name="email" class="form-control" id="exampleInputEmail1"
           aria-describedby="emailHelp">
    <div id="emailHelp" class="form-text">We'll never share your email with anyone else.</div>
</div>
<div class="mb-3">
    <label for="exampleInputPassword1" class="form-label">Password</label>
    <input type="password" name="password" class="form-control" id="exampleInputPassword1">
</div>
<div class="mb-3">
    <label for="exampleInputPassword1" class="form-label">Password Repeat</label>
    <input type="password" name="passwordRep" class="form-control">
</div>
<div class="modal-footer">
    <button type="submit" class="btn btn-primary">Register</button>
</div>
</form>
</body>
</html>
