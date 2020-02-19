package com.soulchild.work.api.service;

import com.soulchild.work.model.Popular;
import org.springframework.data.domain.Page;

public interface PopularService {
    public void setPopular(String query);

    public Page<Popular> getPopularList(int size);

}
