package com.soulchild.work.api.service;

import com.soulchild.work.common.pager.PageList;
import com.soulchild.work.model.Book;

public interface BookService {
    public PageList<Book> getSearchBook(String query , String target , int page, int size);
}
