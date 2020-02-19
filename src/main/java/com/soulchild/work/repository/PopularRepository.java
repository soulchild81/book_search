package com.soulchild.work.repository;

import com.soulchild.work.model.Popular;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface PopularRepository extends PagingAndSortingRepository<Popular, Integer> {
    Popular findByWord(String word);

    Page<Popular> findByOrderByCountDesc(Pageable page);
}
