package com.nf.bookstore1.web;

import com.nf.bookstore1.dao.*;
import com.nf.bookstore1.entity.Book;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(value = "/update")
public class BookUpdate extends HttpServlet {

    protected void doGet (HttpServletRequest req, HttpServletResponse resp)throws ServletException, IOException{

        int id = Integer.parseInt(req.getParameter("id"));

        BookDAO bookdao = new BookInMemoryDAO();

        Book book = bookdao.getBookById(id);

        req.setAttribute("book",book);

        req.getRequestDispatcher("jsp/book_update.jsp").forward(req, resp);
    }

    protected void doPost (HttpServletRequest req, HttpServletResponse resp)throws ServletException, IOException{

        req.setCharacterEncoding("UTF-8");

        int id = Integer.parseInt(req.getParameter("id"));

        String name = req.getParameter("name");

        float price = Float.parseFloat(req.getParameter("price"));

        String author = req.getParameter("author");

        String press = req.getParameter("press");

        Book book = new Book(id,name,price,author,press);

        BookDAO bookdao = new BookInMemoryDAO();

        bookdao.update(book);

        resp.sendRedirect("/detail?id="+id);
    }
}
