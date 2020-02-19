package com.soulchild.work.repository;

import com.soulchild.work.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
    public User findById(String id);

    public User findByIdEqualsAndPasswordEquals(String id , String pw);
}
