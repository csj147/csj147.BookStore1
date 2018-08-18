package com.nf.bookstore1.web;

import com.nf.bookstore1.dao.BookInMemoryDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(value = "/del")
public class BookDel extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {

        int id = Integer.parseInt(request.getParameter("id"));

        BookInMemoryDAO bookdao = new BookInMemoryDAO();

        String msg = null;

        if(bookdao.delete(id)){
            msg = "delete success";
        }else{
            msg = "delete failure";
        }

        response.sendRedirect("/BookList?msg="+msg);
        //request.getRequestDispatcher("/BookList?msg="+msg).forward(request,response);
    }

    public void doPost(HttpServletRequest req, HttpServletResponse resp)throws ServletException, IOException{

        String[] ids = req.getParameterValues("id");

        BookInMemoryDAO bookdao = new BookInMemoryDAO();

        String msg = null;

        boolean bool = false;

        for (String id : ids) {
            bool = bookdao.delete(Integer.parseInt(id));
        }

        if(bool){
            msg = "delete success";
        }else{
            msg = "delete failure";
        }
        resp.sendRedirect("/BookList?msg="+msg);
    }
}
