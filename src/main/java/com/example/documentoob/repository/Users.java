package com.example.documentoob.repository;

import com.example.documentoob.model.UserDtls;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Users extends JpaRepository<UserDtls, Long> {



    // Можно добавить дополнительные методы для работы с товарами, если нужно
}