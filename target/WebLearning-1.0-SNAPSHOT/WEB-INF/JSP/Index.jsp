<%@ page pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<jsp:useBean id="users" scope="request" type="java.util.List<com.entity.User>"/>
<!DOCTYPE html>
<html>
<head>
    <c:url var="base" value="/" />
    <base href="${base}">
    <meta charset="UTF-8">
    <title>#[[$Title$]]#</title>
</head>
<body>
<ul>

    <c:forEach items="${users}" var="u">
        <li><a href="ex07/getUser?userid=${u.id}" > ${u.id} - ${u.name} - ${u.insertTime} - ${u.updateTime}</a></li>
    </c:forEach>
</ul>
<br>
<form action="ex07/updateUser" method="post">
    <select name="userid" >
        <%--选择列表，先放置一个空的option，方便取消 --%>
        <option ></option>
        <c:forEach items="${users}" var="u">
            <option value="${u.id}"> ${u.name}</option>
        </c:forEach>
    </select>
    <label>
       -> NewName：<input type="text" name="newName" >
    </label><br>
    <button type="submit">修改</button>
</form>
</body>
</html>