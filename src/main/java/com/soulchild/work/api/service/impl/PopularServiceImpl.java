package com.soulchild.work.api.service.impl;

import com.soulchild.work.api.service.PopularService;
import com.soulchild.work.model.Popular;
import com.soulchild.work.repository.PopularRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service("popularService")
public class PopularServiceImpl implements PopularService {

    @Autowired
    PopularRepository popularRepository;

    @Override
    public void setPopular(String query){
        Popular popular = popularRepository.findByWord(query);
        if(popular==null) {
            Popular po = Popular.builder().word(query).count(1).build();
            popularRepository.save(po);
        }else {
            popular.setCount(popular.getCount()+1);
        }
    }

    @Override
    public Page<Popular> getPopularList(int size){
        PageRequest req = PageRequest.of(0, size , Sort.by("count").descending());
        Page<Popular> list = popularRepository.findByOrderByCountDesc(req);
        return list;
    }
}
