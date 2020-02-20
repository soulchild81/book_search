package com.soulchild.work.api.service.impl;

import com.soulchild.work.api.retrofitService.SearchNaverRetrofitService;
import com.soulchild.work.api.retrofitService.SearchRetrofitService;
import com.soulchild.work.api.service.BookService;
import com.soulchild.work.api.service.KeywordService;
import com.soulchild.work.api.service.PopularService;
import com.soulchild.work.common.Constants;
import com.soulchild.work.common.pager.PageArrayList;
import com.soulchild.work.common.pager.PageList;
import com.soulchild.work.model.*;
import com.soulchild.work.repository.*;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import retrofit2.Call;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service("bookService")
public class BookServiceImpl implements BookService {
    private static final Log logger = LogFactory.getLog(BookServiceImpl.class);

    @Autowired
    SearchRetrofitService searchRetrofitService;

    @Autowired
    SearchNaverRetrofitService searchNaverRetrofitService;

    @Autowired
    BookRepository bookRepository;

    @Autowired
    TranslatorsRepository translatorsRepository;

    @Autowired
    AuthorRepository authorRepository;

    @Autowired
    KeywordRepository keywordRepository;

    @Autowired
    PopularService popularService;

    @Autowired
    KeywordService keywordService;

    @Override
    public PageList<Book> getSearchBook(String query , String target , int page, int size){
        //인기 검색어 업데이트
        popularService.setPopular(query);
        //검색 히스토리 저장
        keywordService.setSearchHistory(query);

        List<Book> list = new ArrayList<>();
        PageInfo info = new PageInfo();
        try{
            //Book search
            Call<BookMeta> searchJson = searchRetrofitService.getSearchBook(Constants.kakaoAuthKey, query , target , page , size);
            BookMeta meta = searchJson.execute().body();
            if(meta.getDocuments() != null){
                list = meta.getDocuments();
                list.stream().forEach(s->bookRepository.save(s));
                info.setTotal_count(meta.getMeta().getTotal_count());
            }
        }catch(Exception e){
            e.printStackTrace();
            try{
                logger.info("카카오 책검색 장애 !!");

                Call<NaverBookMeta> searchNaverJson = searchNaverRetrofitService.getNaverSearchBook(Constants.naverAuthId , Constants.naverAuthSecret , query  , page , size);
                NaverBookMeta naverMeta = searchNaverJson.execute().body();
                info.setTotal_count(naverMeta.getTotal());

                List<NaverBook> naverList = naverMeta.getItems();
                List<Book> convertBookList = new ArrayList<>();

                naverList.forEach(s -> {
                                        Book book = this.convertBooks(s);
                                        convertBookList.add(book);
                                        authorRepository.save(this.convertAuthor(bookRepository.save(book).getBook_id() , s));
                                        }
                                 );
                list = convertBookList;
            }catch(Exception i){
                i.printStackTrace();
            }
        }
        return new PageArrayList<Book>(list, page, size, info.getTotal_count());
    }

    public Book convertBooks(NaverBook nb){
        return Book.builder()
                .title(nb.getTitle())
                .contents(nb.getDescription())
                .sale_price(Integer.parseInt(nb.getDiscount().equals("")?"0":nb.getDiscount()))
                .price(Integer.parseInt(nb.getPrice().equals("")?"0":nb.getPrice()))
                .authors(Arrays.asList(nb.getAuthor()))
                .isbn(nb.getIsbn())
                .publisher(nb.getPublisher())
                .thumbnail(nb.getImage())
                .url(nb.getLink()).build();
    }

    public Authors convertAuthor(int id , NaverBook nb){
        return Authors.builder().book_id(id).Author(nb.getAuthor()).build();
    }
}

















