package com.library.library_management_system.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data

public class BookAddDTO {

private Long bookId;
    private String bookName;
private String authorName;
private String genre;
private boolean available;
private double price;

    private Long authorId;

}
