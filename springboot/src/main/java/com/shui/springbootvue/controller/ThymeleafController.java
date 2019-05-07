package com.shui.springbootvue.controller;

import com.shui.springbootvue.model.Book;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

/**
 * thymeleaf模板，访问
 * http://localhost:8081/thymeleaf/books
 */
@Controller
@RequestMapping("thymeleaf")
public class ThymeleafController {

    @GetMapping("/books")
    public ModelAndView books(){
        List<Book> books = new ArrayList<>();
        Book book1 = new Book();
        book1.setId(1);
        book1.setName("spring");
        book1.setAuthor("boot");
        Book book2 = new Book();
        book2.setId(2);
        book2.setName("spring");
        book2.setAuthor("mvc");
        books.add(book1);
        books.add(book2);
        ModelAndView mv = new ModelAndView();
        mv.addObject("books",books);
        mv.setViewName("books");
        return mv;

    }

    @GetMapping("/hi")
    public String hello(){
        return "Hello World!";
    }


    @GetMapping("/fastjson")
    @ResponseBody
    public Book json(){
        Book book = new Book();
        book.setId(1);
        book.setName("spring");
        book.setAuthor("boot");
        return book;
    }
}


