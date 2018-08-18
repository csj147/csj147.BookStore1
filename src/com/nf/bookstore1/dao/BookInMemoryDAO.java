package com.nf.bookstore1.dao;

import com.nf.bookstore1.entity.Book;

import java.util.ArrayList;
import java.util.List;

public class BookInMemoryDAO implements BookDAO {

    private static List<Book> bookDB = new ArrayList<>();

    static{
        Book b1 = new Book(1,"java",110.5f,"张三","南方出版社");
        Book b2 = new Book(2,"C#",120.5f,"李四","西方出版社");
        Book b3 = new Book(3,"C++",130.5f,"王五","东方出版社");
        Book b4 = new Book(4,"HTML",140.5f,"赵六","北方出版社");

        bookDB.add(b1);
        bookDB.add(b2);
        bookDB.add(b3);
        bookDB.add(b4);
    }

    public List<Book> listAll(){

        return bookDB;
    }

    public Book getBookById(int id){

        for (Book book : bookDB) {
            if(book.getId() == id){
                return book;
            }
        }

        return null;
    }

    public List<Book> getBooksByName(String name){

        ArrayList<Book> books = new ArrayList<>();

        for(Book book : bookDB){
            String realName = book.getName().toLowerCase();

            if(realName.contains(name.toLowerCase())){
                books.add(book);
            }
        }

        return books;
    }

    public boolean delete(int id){

        for(Book book : bookDB){
            if(book.getId() == id){
                return bookDB.remove(book);
            }
        }

        return false;
    }

    public boolean update (Book book){

        for (Book bookNew : bookDB) {
            if(bookNew.getId() == book.getId()){
                bookNew.setName(book.getName());
                bookNew.setAuthor(book.getAuthor());
                bookNew.setPrice(book.getPrice());
                bookNew.setPress(book.getPress());

                return true;
            }
        }

        return false;
    }

    public Book add(Book book){

        if(bookDB.add(book)){
            return book;
        }

        return null;
    }
}
