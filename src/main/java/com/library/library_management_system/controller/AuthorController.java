package com.library.library_management_system.controller;
import com.library.library_management_system.dto.*;
import com.library.library_management_system.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/authors")
public class AuthorController {


    @Autowired
    private AuthorService authorService;

    @PostMapping( "/addAuthor")  //For Add a new author
    public ResponseEntity<String> addAuthor(@RequestBody AuthorAddDTO authorAddDTO) {

        try {
           String authorName = authorService.addAuthor(authorAddDTO);
            return ResponseEntity.status(HttpStatus.CREATED).body( "Successfully added new author: " + authorName);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("An error occurred while adding new author: " + e.getMessage());
        }

    }




    @GetMapping("/getAllAuthors")   //For Retrieve all authors
    public ResponseEntity <List<AuthorDTO>>getAllAuthors(){

        try {
       List <AuthorDTO> allAuthors = authorService.getAllAuthors();
          return ResponseEntity.ok(allAuthors);
        } catch (Exception e) {
            System.out.println("An error occurred while getting all authors"+e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(Collections.emptyList());
        }


    }


    @GetMapping( "/getAuthor/{id}")  //For Retrieve an author by id
    public ResponseEntity<String> getAuthor(@PathVariable Long id) {

try {
    String authorName = authorService.getAuthor(id);
    return  ResponseEntity.ok("Successfully get author: " + authorName);
}catch (Exception e){
    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body( "An error occurred while Retrieving an exiting author: " + e.getMessage());
}

    }


    @PutMapping( "/updateAuthor/{id}")  //For Update an existing author
    public ResponseEntity<String> updateAuthor( @PathVariable Long id ,@RequestBody AuthorUpdateDTO authorUpdateDTO) {


      try {
          String  authorName = authorService.updateAuthor(id,authorUpdateDTO);
            return ResponseEntity.ok("Successfully updated author: " + authorName);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body( "An error occurred while updating an exiting author: " + e.getMessage());
        }

    }


    @DeleteMapping( "/deleteAuthor/{id}")  //For Create a new author
    public ResponseEntity<String> deleteAuthor(@PathVariable Long id) {

        try {


           String authorName = authorService.deleteAuthor(id);
            return ResponseEntity.ok("Successfully deleted  author: " + authorName);
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body( "An error occurred while deleting an exiting author: " + e.getMessage());
        }

    }





}
