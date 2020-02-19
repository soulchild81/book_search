package com.soulchild.work.repository;

import com.soulchild.work.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Integer> {
    public List<Book> findByTitleIs(String title);
}
