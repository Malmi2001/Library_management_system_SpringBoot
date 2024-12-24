package com.library.library_management_system.dto;

import com.library.library_management_system.entity.Author;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
@Data

public class BookDTO {




    private long bookId;
    private String bookName;
    private String authorName;
    private String genre;
    private boolean available;
    private double price;


    private Author author;


    public BookDTO(long bookId, String bookName, String authorName, double price, String genre) {
        this.bookId = bookId;
        this.bookName = bookName;
        this.authorName = authorName;
        this.price = price;
        this.genre = genre;
        this.available = true;

    }

    public BookDTO(long bookId, String bookName, String authorName, double price, String genre, boolean available) {
    }
}
