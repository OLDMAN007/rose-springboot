package com.freedom.rose.repository;

import com.freedom.rose.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

    User findByCode(String code);
    User findByName(String name);

}
