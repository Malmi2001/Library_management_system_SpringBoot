package com.library.library_management_system.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import  com.library.library_management_system.entity.Author;

public interface AuthorRepository extends JpaRepository<Author,Long>{
}
