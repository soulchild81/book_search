package com.soulchild.work.api.v1;

import com.soulchild.work.api.service.BookService;
import com.soulchild.work.api.service.KeywordService;
import com.soulchild.work.api.service.PopularService;
import com.soulchild.work.common.Exception.CommonException;
import com.soulchild.work.common.pager.PageList;
import com.soulchild.work.common.result.ListResult;
import com.soulchild.work.common.result.PageListResult;
import com.soulchild.work.model.Book;
import com.soulchild.work.model.Keyword;
import com.soulchild.work.model.Popular;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/v1/book")
public class BookController {

    @Autowired
    BookService bookService;

    @Autowired
    KeywordService keywordService;

    @Autowired
    PopularService popularService;

    /**
     * BOOK 검색
     * @param query
     * @param target
     * @return
     */
    @GetMapping("/search/list")
    public PageListResult<Book> searchBook(@RequestParam(value="query", required=true) String query,
                                           @RequestParam(value="target", required=false , defaultValue = "title") String target,
                                           @RequestParam(value="page", required=false , defaultValue = "1") int page,
                                           @RequestParam(value="size", required=false , defaultValue = "10") int size){
        PageList<Book> bookList = bookService.getSearchBook(query , target , page , size);

        return new PageListResult<Book>(bookList);
    }


    /**
     * 검색 히스토리 조회
     * @return
     */
    @GetMapping("/search/history/list")
    public ListResult<Keyword> historyBookSearch(@RequestParam(value="page", required=false , defaultValue = "0") int page,
                                                 @RequestParam(value="size", required=false , defaultValue = "10") int size,
                                                 @RequestParam(value="sort", required=false , defaultValue = "regDate") String sort){
        Page<Keyword> list = keywordService.getSearchHistory(page , size , sort);
        List<Keyword> keywordList = list.getContent();
        return new ListResult<Keyword>(keywordList);
    }

    /**
     * 인기 키워드 조회
     * @return
     */
    @GetMapping("/popular/keyword/list")
    public ListResult<Popular> popularBook(@RequestParam(value="size", required=false , defaultValue = "10") int size){
        Page<Popular> list = popularService.getPopularList(size);
        List<Popular> popularList = list.getContent();
        return new ListResult<Popular>(popularList);
    }
}














