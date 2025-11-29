package inc.hustles.sims.controller;

import inc.hustles.sims.model.Book;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookFinderRestController {

    private static final Logger logger = LoggerFactory.getLogger(BookFinderRestController.class);

    @GetMapping("book")
    public Book getBook(){
        logger.info("getBook() method called");
        return new Book("Sims", "The stories of Hustling in the streets");
    }
}
