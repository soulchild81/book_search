package com.soulchild.work.repository;


import com.soulchild.work.model.Authors;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Authors, Integer> {}

