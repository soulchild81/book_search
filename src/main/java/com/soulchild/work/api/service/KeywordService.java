package com.soulchild.work.api.service;

import com.soulchild.work.model.Keyword;
import org.springframework.data.domain.Page;


public interface KeywordService {
    public void setSearchHistory(String query);

    public Page<Keyword> getSearchHistory(int page , int size , String sort);
}
