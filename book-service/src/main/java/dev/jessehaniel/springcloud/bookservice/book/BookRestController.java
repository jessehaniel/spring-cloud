package dev.jessehaniel.springcloud.bookservice.book;

import java.util.Arrays;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/books")
public class BookRestController {

    private List<Book> bookList = Arrays.asList(
        new Book(1L, "title", "author"),
        new Book(2L, "title", "author")
    );
    
    @GetMapping
    public List<Book> listAllBooks(){
        return bookList;
    }
    
    @GetMapping("{id}")
    public Book getById(@PathVariable Long id){
        return bookList.stream().filter(b -> b.getId().equals(id)).findFirst().orElse(null);
    }
}
