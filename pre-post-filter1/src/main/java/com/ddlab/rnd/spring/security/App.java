package com.ddlab.rnd.spring.security;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        Book novel = new Book();
        novel.setBookName("Novel Book");
        novel.setType(BookType.NOVEL.name());
//        novel.setUploadedBy(ROLETYPE.ADMIN.name());
        novel.setUploadedBy("Deb");
        
        Book adult = new Book();
        adult.setBookName("Sex Book");
        adult.setType(BookType.ADULT.name());
//        adult.setUploadedBy(ROLETYPE.USER_ABOVE_18.name());
        adult.setUploadedBy("Deb1");
        
        List<Book> bookList = new ArrayList<Book>();
        bookList.add(novel);
        bookList.add(adult);
        
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        
        SecurityUtil.loginAs("Deb", "pqrs", ROLETYPE.ADMIN);
        
        BookService bookService = (BookService) context.getBean("bookService");
        bookService.addBooks(bookList);
        
        SecurityUtil.loginAs("Deb", "pqrs", ROLETYPE.USER_ABOVE_18);
//        SecurityUtil.loginAs("Deb", "pqrs", ROLETYPE.USER_BELOW_18);
//        SecurityUtil.loginAs("Deb1", "pqrs", ROLETYPE.USER_ABOVE_18);
//        SecurityUtil.loginAs("Deb", "pqrs", ROLETYPE.ADMIN);
//        List<Book> books = bookService.getBooks();
//        List<Book> books = bookService.getAllTypeBooks();
//        List<Book> books = bookService.getAdultBooks();
//        List<Book> books = bookService.getBooks1();
//        List<Book> books = bookService.getBooks1();
//        for( Book book : books ) {
//        	System.out.println("Final Book Name :::"+book.getBookName());
//        }
        
        bookService.uploadYourBooks(bookList);
        
        
        
//        List<Book> books = bookService.getAllBooks();
//        for( Book book : books ) {
//        	System.out.println("Final Book Name :::"+book.getBookName());
//        }
    }
}
