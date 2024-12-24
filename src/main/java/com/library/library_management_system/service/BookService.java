package com.library.library_management_system.service;

import com.library.library_management_system.dto.BookAddDTO;

import com.library.library_management_system.dto.BookUpdateDTO;
import com.library.library_management_system.dto.BookDTO;


import java.util.List;


public interface BookService {
    String addBook(BookAddDTO bookAddDTO);

    List<BookDTO> getAllBooks();

    String getBook(Long id);

    String updateBook(Long id, BookUpdateDTO bookUpdateDTO);

    String deleteBook(Long id);


}
