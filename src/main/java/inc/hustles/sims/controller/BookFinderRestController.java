package inc.hustles.sims.controller;

import inc.hustles.sims.model.Book;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookFinderRestController {

    @GetMapping("book")
    public Book getBook(){
        return new Book("Sims", "The stories of Hustling in the streets");
    }
}
