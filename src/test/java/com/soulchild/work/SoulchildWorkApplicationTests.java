package com.soulchild.work;

import com.soulchild.work.api.service.BookService;
import com.soulchild.work.api.service.KeywordService;
import com.soulchild.work.api.service.PopularService;
import com.soulchild.work.model.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

import java.util.List;

@SpringBootTest
class SoulchildWorkApplicationTests {

    @Autowired
    BookService bookService;

    @Autowired
    PopularService popularService;

    @Autowired
    KeywordService keywordService;

    @Test
    void contextLoads() {
        System.out.println("init");
    }

    @Test
    void bookTest() {
        try{
            bookService.getSearchBook("2pac" , "title" , 1 , 5);
            //Thread.sleep(1000);
            bookService.getSearchBook("이상민" , "title" , 1 , 5);
            bookService.getSearchBook("이상민" , "title" , 1 , 5);
            //Thread.sleep(1000);
            bookService.getSearchBook("전소민" , "title" , 1 , 5);
            bookService.getSearchBook("전소민" , "title" , 1 , 5);
            bookService.getSearchBook("전소민" , "title" , 1 , 5);
            bookService.getSearchBook("전소민" , "title" , 1 , 5);

            bookService.getSearchBook("한준" , "title" , 1 , 5);
            bookService.getSearchBook("한준" , "title" , 1 , 5);
            bookService.getSearchBook("한준" , "title" , 1 , 5);
        }catch(Exception e){
            e.printStackTrace();
        }

        PageRequest req = PageRequest.of(1, 10 , Sort.by("count").descending());
        Page<Keyword> list = keywordService.getSearchHistory(1 , 10 , "regDate");
        list.stream().forEach(s -> System.out.println(s.getWord()));

        popularService.setPopular("전소민");
        popularService.setPopular("전소민");
        popularService.setPopular("전소민");
        popularService.setPopular("전소민");
        popularService.setPopular("전소민");
        popularService.setPopular("전소민");

        Page<Popular> list2 = popularService.getPopularList(10);
        list2.stream().forEach(s -> System.out.println(s.getWord()+":"+s.getCount()));


        System.out.println("----------------------------------------------------------------END");
    }

    @Test
    void memberTest() {


    }

}

















