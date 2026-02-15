package com.example.chat_application.repository;

import com.example.chat_application.repository.entity.Users;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.Optional;

@Mapper
public interface UserRepository {
    Optional<Users> findByEmail(@Param("mailaddress") String mailaddress);
}
