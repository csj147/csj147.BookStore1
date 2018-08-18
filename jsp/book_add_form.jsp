<%--
  Created by IntelliJ IDEA.
  User: 陈小子
  Date: 2018/8/15
  Time: 19:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>添加页面</title>
</head>
<body>
    <form action="/add" method="post">
        <div><input type="text" name="id" placeholder="id"></div>
        <div><input type="text" name="name" placeholder="书名"></div>
        <div><input type="text" name="price" placeholder="价格"></div>
        <div><input type="text" name="author" placeholder="作者"></div>
        <div><input type="text" name="press" placeholder="出版社"></div>
        <div><input type="submit"></div>
    </form>
</body>
</html>
