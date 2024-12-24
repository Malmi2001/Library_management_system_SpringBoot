package com.library.library_management_system.service;


import com.library.library_management_system.dto.*;

import java.util.List;


public interface AuthorService {

     String addAuthor(AuthorAddDTO authorAddDTO);

     List<AuthorDTO> getAllAuthors();

     String updateAuthor(Long authorId, AuthorUpdateDTO authorUpdateDTO);

     String deleteAuthor(Long id);

     String getAuthor(Long id);
}

