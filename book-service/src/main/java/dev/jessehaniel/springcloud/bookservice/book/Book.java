package dev.jessehaniel.springcloud.bookservice.book;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Book {
    private Long id;
    private String author;
    private String title;
    
}
