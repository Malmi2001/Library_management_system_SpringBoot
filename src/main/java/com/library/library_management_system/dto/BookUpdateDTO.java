package com.library.library_management_system.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data

public class BookUpdateDTO {

    private String bookName;

    private Long bookId;
private double price;
private boolean available;
    private Long authorId;


}
