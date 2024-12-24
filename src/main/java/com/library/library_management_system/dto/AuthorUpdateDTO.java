package com.library.library_management_system.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
@Data


public class AuthorUpdateDTO {
    private Long authorId;
    private String authorName;
}
