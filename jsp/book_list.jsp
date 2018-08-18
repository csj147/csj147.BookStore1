<%--
  Created by IntelliJ IDEA.
  User: 陈小子
  Date: 2018/8/15
  Time: 14:31
  To change this template use File | Settings | File Templates.
--%>

<%@ page import="com.nf.bookstore1.entity.Book" %>
<%@ page import="java.util.List"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>图书列表</title>

    <style>
        table{
            border-collapse:collapse;
        }
        table,th,td{
            padding:3px 1em;
            border:1px solid black;
        }
    </style>
</head>
<body>

<%
    String msg = request.getParameter("msg");

    if(msg != null && !msg.isEmpty()){
%>

<div style="border:1px solid red;background:pink;margin-bottom:2em;">
    <%=request.getParameter("msg")%>
</div>

<%}%>

<form action="/q">
    <input type="text" placeholder="查询条件(书名)" name="condition" />
    <input type="submit" value="搜索">
</form>

<form action="/del" method="post">
    <table>
        <tr>
            <th><input type="checkbox" onclick="alls(this)"></th>
            <th>id</th>
            <th>书名</th>
            <th>单价</th>
            <th>作者</th>
            <th>出版社</th>
            <th>其它</th>
        </tr>

        <%
            List<Book> book = (List<Book>)request.getAttribute("books");

            for (Book books : book) {
        %>

        <tr>
            <td><input name="id" value="<%=books.getId()%>" type="checkbox"></td>
            <td><%=books.getId()%></td>
            <td><a href="/detail?id=<%=books.getId()%>"><%=books.getName()%></a></td>
            <td><%=books.getPrice()%></td>
            <td><%=books.getAuthor()%></td>
            <td><%=books.getPress()%></td>
            <td>
                <a href="/del?id=<%=books.getId()%>">删除</a>
                <a href="/update?id=<%=books.getId()%>">更新</a>
            </td>
        </tr>

        <%
            }
        %>
    </table>

    <div style="margin-top:2em;">
        <input type="submit" value="删除">
        <a href="/add">增加新的书籍</a>
    </div>
</form>

<script>
    function alls(e){
        var checkboxs = document.getElementByName("id");
        for (var i = 0; i < checkboxs.length; i++) {
            checkboxs[i].checked = e.checked;
        }
    }
</script>
</body>
</html>
