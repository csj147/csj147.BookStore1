package com.nf.bookstore1.web;

import com.nf.bookstore1.dao.*;
import com.nf.bookstore1.entity.Book;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(value = "/detail")
public class BookDetail extends HttpServlet {

    protected void doGet (HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException{


        int id = Integer.parseInt(request.getParameter("id"));

        BookDAO bookdao = new BookInMemoryDAO();

        Book book = bookdao.getBookById(id);

        request.setAttribute("book",book);

        request.getRequestDispatcher("jsp/book_detail.jsp").forward(request, response);
    }
}
