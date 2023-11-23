<%@ page import="java.util.ArrayList" %>
<%@ page import="db.Item" %>
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
<%
    ArrayList<Item> items = (ArrayList<Item>) request.getAttribute("items");
    if (items != null) {
%>
<div class="container">
    <div class="row">
        <%
            for (Item item : items) {
        %>
        <div class="col-md-4">
            <div class="card text-center mb-3" style="width: 18rem;">
                <div class="card-header"><%= item.getName() %></div>
                <div class="card-body">
                    <h5 class="card-title"><%= item.getPrice() %></h5>
                    <p class="card-text"><%= item.getDescription() %></p>
                    <a href="#" class="btn btn-primary">Купить сейчас</a>
                </div>
            </div>
        </div>
        <%
            }
        %>
    </div>
</div>
<%
    }
%>

</body>
</html>
