package com.library.library_management_system.service.IMPL;
import com.library.library_management_system.dto.AuthorAddDTO;
import com.library.library_management_system.dto.AuthorDTO;
import com.library.library_management_system.dto.AuthorUpdateDTO;
import com.library.library_management_system.entity.Author;
import com.library.library_management_system.repository.AuthorRepository;
import com.library.library_management_system.service.AuthorService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public  class AuthorServiceIMPL implements AuthorService {

    @Autowired
    private AuthorRepository authorRepository;

    @Override
    public String addAuthor(AuthorAddDTO authorAddDTO) {

        Author author= new Author(
                authorAddDTO.getAuthorName()
        );
        authorRepository.save(author);
       return author.getAuthorName();
    }

    @Override
    public List<AuthorDTO> getAllAuthors() {
        List<Author> getAuthors = authorRepository.findAll();
        List<AuthorDTO> authorDTOList= new ArrayList<>();


        for(Author author : getAuthors) {
            AuthorDTO authorDTO = new AuthorDTO(
                    author.getAuthorId(),
                    author.getAuthorName()
            );
            authorDTOList.add(authorDTO);
        }
        return authorDTOList;
    }


    @Override
    public String updateAuthor(Long authorId, AuthorUpdateDTO authorUpdateDTO) {

      if(authorRepository.existsById(authorId)) {
          Author author = authorRepository.getReferenceById((authorId));
author.setAuthorName(authorUpdateDTO.getAuthorName());
          authorRepository.save(author);
          return author.getAuthorName();
      }else{
         throw new EntityNotFoundException("Author not found");

      }

    }

    @Override
    public String deleteAuthor(Long id) {

        if(authorRepository.existsById(id)) {
            Author author = authorRepository.getReferenceById(id);
            String authorName = author.getAuthorName();
            authorRepository.deleteById(id);
            return authorName;
        } else{
            throw new EntityNotFoundException("Author not found for id: "+id);
        }

    }

    @Override
    public String getAuthor(Long id) {
        if(authorRepository.existsById(id)) {
            Author author = authorRepository.getReferenceById((long) id);
            return author.getAuthorName();
        } else{
            throw new EntityNotFoundException("The author not found");
        }



    }


}

