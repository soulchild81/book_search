package com.soulchild.work.repository;

import com.soulchild.work.model.Keyword;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface KeywordRepository extends PagingAndSortingRepository<Keyword, Integer> {
    Page<Keyword> findAll(Pageable page);
}
