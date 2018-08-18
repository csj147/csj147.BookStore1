package com.nf.bookstore1.web;

import com.nf.bookstore1.dao.*;
import com.nf.bookstore1.entity.Book;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(value = "/add")
public class BookAdd extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException{

        request.getRequestDispatcher("jsp/book_add_form.jsp").forward(request,response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException{

        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        float price = Float.parseFloat(request.getParameter("price"));
        String author = request.getParameter("author");
        String press = request.getParameter("press");

        Book book = new Book(id,name,price,author,press);

        BookDAO bookdao = new BookInMemoryDAO();
        bookdao.add(book);
        response.sendRedirect("/BookList");
    }
}