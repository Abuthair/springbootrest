package com.bookapp.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Book {
    private Integer bookId;
    public String title;
    private String  author;
    private String categegory;
    private double price;
}
