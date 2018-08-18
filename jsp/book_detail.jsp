<%--
  Created by IntelliJ IDEA.
  User: 陈小子
  Date: 2018/8/15
  Time: 19:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="com.nf.bookstore1.entity.Book"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>书籍详细</title>
</head>
<body>
    <% Book book = (Book)request.getAttribute("book");%>

    <h1><%=book.getName()%></h1>

    <ul>
        <li><%=book.getAuthor()%></li>
        <li><%=book.getPrice()%></li>
        <li><%=book.getPress()%></li>
    </ul>

    <a href="/BookList">返回</a>
</body>
</html>
