package com.nf.bookstore1.test;

import com.nf.bookstore1.dao.*;
import com.nf.bookstore1.entity.Book;
import com.nf.bookstore1.web.*;

public class Main {

    public static void main(String[] args){
        BookDAO bookdao = new BookInMemoryDAO();
        for (Book book : bookdao.listAll()) {
            System.out.println(book);
        }
    }
}
