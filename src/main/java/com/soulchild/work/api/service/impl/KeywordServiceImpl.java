package com.soulchild.work.api.service.impl;

import com.soulchild.work.api.service.KeywordService;
import com.soulchild.work.model.Keyword;
import com.soulchild.work.repository.KeywordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service("keywordService")
public class KeywordServiceImpl implements KeywordService {
    @Autowired
    KeywordRepository keywordRepository;

    @Override
    public void setSearchHistory(String query){
        Keyword keyword = Keyword.builder().word(query).regDate(new Date()).build();
        keywordRepository.save(keyword);
    }

    @Override
    public Page<Keyword> getSearchHistory(int page , int size , String sort){
        PageRequest req = PageRequest.of(page, size , Sort.by("regDate").descending());
        Page<Keyword> list = keywordRepository.findAll(req);
        return list;
    }
}
