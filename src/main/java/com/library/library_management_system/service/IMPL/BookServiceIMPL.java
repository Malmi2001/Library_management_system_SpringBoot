package com.library.library_management_system.service.IMPL;
import com.library.library_management_system.dto.BookAddDTO;
import com.library.library_management_system.dto.BookDTO;
import com.library.library_management_system.dto.BookUpdateDTO;
import com.library.library_management_system.entity.Book;
import com.library.library_management_system.repository.AuthorRepository;
import com.library.library_management_system.repository.BookRepository;
import com.library.library_management_system.service.BookService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service


public class BookServiceIMPL implements BookService {
    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private AuthorRepository authorRepository;



//Add a book
        @Override
        public String addBook(BookAddDTO bookAddDTO) {
            Book book= new Book(
                    bookAddDTO.getBookName(),
                    bookAddDTO.getAuthorName(),
                    bookAddDTO.getPrice(),
                    bookAddDTO.getGenre(),
                    bookAddDTO.isAvailable(),
                    authorRepository.getReferenceById(bookAddDTO.getAuthorId()));

            bookRepository.save(book);
            return book.getBookName();

        }
    //Get all books
    @Override
    public List<BookDTO> getAllBooks() {



            List<Book> getBooks = bookRepository.findAll();
            List<BookDTO> bookDTOList= new ArrayList<>();

            for(Book book : getBooks) {
                BookDTO bookDTO = new BookDTO(
                        book.getBookId(),
                        book.getBookName(),
                        book.getAuthorName(),
                        book.getPrice(),
                        book.getGenre()

                );
                bookDTOList.add(bookDTO);
            }
            return bookDTOList;
        }
    //Get a book
    @Override
    public String getBook(Long id) {
        //Get a book

            if(bookRepository.existsById(id)) {
                Book book = bookRepository.getReferenceById(id);
                return book.getBookName();
            } else{
                throw new EntityNotFoundException("The book not found");
            }



        }

    @Override
    public String updateBook(Long id, BookUpdateDTO bookUpdateDTO) {

        if(bookRepository.existsById(id)){
            Book book = bookRepository.getReferenceById((id));
            book.setBookName(bookUpdateDTO.getBookName());
            book.setPrice(bookUpdateDTO.getPrice());
            book.setAvailable(bookUpdateDTO.isAvailable());
            bookRepository.save(book);
            return book.getBookName();

        }else{
            throw new EntityNotFoundException("Book not found");

        }
    }

    @Override
    public String deleteBook(Long id) {

            if(bookRepository.existsById(id)) {
                Book book= bookRepository.getReferenceById(id);
                String bookName = book.getBookName();
                bookRepository.deleteById(id);
                return bookName;

            } else{
                throw new EntityNotFoundException("Book not found for id : " + id);
            }


        }

    }









