package dev.jessehaniel.springcloud.ratingservice.rating;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ratings")
public class RatingRestController {
    
    private List<Rating> ratingList = Arrays.asList(
        new Rating(1L, 1L, 2),
        new Rating(2L, 1L, 3),
        new Rating(3L, 2L, 4),
        new Rating(4L, 2L, 5)
    );
    
    @GetMapping
    public List<Rating> listAllRatings() {
        return ratingList;
    }
    
    @GetMapping("{bookId}")
    public List<Rating> getById(@PathVariable Long bookId) {
        return bookId == null || bookId.equals(0L) ? Collections.emptyList() :
            ratingList.stream().filter(r -> r.getBookId().equals(bookId)).collect(
            Collectors.toList());
    }
}
