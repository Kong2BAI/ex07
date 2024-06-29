<jsp:useBean id="user" scope="request" type="com.entity.User"/>
<%@ page pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
    <c:url var="base" value="/"/>
    <base href="">
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
<h1>${user.name}</h1>
<p>${user.id}</p>
<p>${user.updateTime}</p>
<p>${user.updateTime}</p>

</body>
</html>
