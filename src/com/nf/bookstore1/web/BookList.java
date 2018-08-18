package com.nf.bookstore1.web;

import com.nf.bookstore1.dao.*;
import com.nf.bookstore1.entity.Book;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class BookList extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{

        BookDAO bookdao = new BookInMemoryDAO();
        List<Book> books = bookdao.listAll();
        request.setAttribute("books",books);
        request.getRequestDispatcher("jsp/book_list.jsp").forward(request, response);
    }
}
