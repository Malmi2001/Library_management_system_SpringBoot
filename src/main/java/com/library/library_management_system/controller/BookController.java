package com.library.library_management_system.controller;

import com.library.library_management_system.dto.BookAddDTO;
import com.library.library_management_system.dto.BookDTO;
import com.library.library_management_system.dto.BookUpdateDTO;
import com.library.library_management_system.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@RestController

@RequestMapping("/api/books")
public class BookController {
    @Autowired
    private BookService bookService;

    @PostMapping("/addBook") //For Add a new book
    public ResponseEntity<String> addBook(@RequestBody BookAddDTO bookAddDTO) {
        String bookName;
        try {
            bookName = bookService.addBook(bookAddDTO);
            return ResponseEntity.status(HttpStatus.CREATED).body("Successfully added new book: " + bookName);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body( "An error occurred while adding new book: " + e.getMessage());
        }

    }
    @GetMapping( "/getAllBooks")   //For Retrieve all books
    public ResponseEntity<List<BookDTO>> getAllBooks(){


        try {
            List<BookDTO> allBooks = bookService.getAllBooks();
            return  ResponseEntity.ok(allBooks);

        } catch (Exception e) {
            System.out.println("An error occurred while getting all books"+e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(Collections.emptyList());
        }

    }

    @GetMapping( "/getBook/{id}")   //For Retrieve a book
    public ResponseEntity<String> getBook( @PathVariable Long id) {

        try {
            String  bookName = bookService.getBook(id);
            return ResponseEntity.ok("Successfully Retrieved a book: "+ bookName) ;
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body( "An error occurred while Retrieving an exiting book: " + e.getMessage());
        }

    }
    @PutMapping( "/updateBook/{id}")  //For Update an existing book
    public ResponseEntity<String> updateBook( @PathVariable Long id,@RequestBody BookUpdateDTO bookUpdateDTO) {

        try {
            String  updateBook = bookService.updateBook(id, bookUpdateDTO);
            return ResponseEntity.ok("Successfully updated book: "+ updateBook) ;
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body( "An error occurred while updating an exiting book: " + e.getMessage());
        }

    }


    @DeleteMapping( "/deleteBook/{id}")  //For Delete a book
    public ResponseEntity<String> deleteBook(@PathVariable Long id) {

        try {

            String   bookName = bookService.deleteBook(id);
            return ResponseEntity.ok("Successfully deleted  book: " + bookName);
        }catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("An error occurred while deleting an exiting book: " + e.getMessage());
        }

    }




}