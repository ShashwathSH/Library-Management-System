package com.shashwathsh.Library.Management.System.controller;

import com.shashwathsh.Library.Management.System.dto.BookDTO;
import com.shashwathsh.Library.Management.System.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping(path = "/api/books")
@RequiredArgsConstructor
public class BookController {
    private final BookService bookService;

    @GetMapping
    public List<BookDTO> getAllBooks(){
        return bookService.getAllBooks();
    }

    @GetMapping(value = "/search",params = "name")
    public BookDTO findByNameContainingIgnoreCase(@RequestParam String name){
        return bookService.findBooksByTitle(name);
    }

    @GetMapping(value = "/search",params = "date")
    public List<BookDTO> findByPublishDateAfter(@RequestParam LocalDate date){
        return bookService.findByPublishDateAfter(date);
    }

    @GetMapping("/by-author")
    public List<BookDTO> getNameByAuthorId(@RequestParam Long authorId){
        return bookService.findBooksByAuthor(authorId);
    }

    @GetMapping("/{bookId}")
    public BookDTO getBookById(@PathVariable Long bookId){
        return bookService.getBookById(bookId);
    }

    @PostMapping
    public BookDTO createBook(@RequestBody BookDTO bookDTO){
        return bookService.createBook(bookDTO);
    }

    @PutMapping("/{bookId}")
    public BookDTO updateBook(@PathVariable Long bookId,
                              @RequestBody BookDTO bookDTO){
        return bookService.updateBook(bookId,bookDTO);
    }

    @DeleteMapping("/{bookId}")
    public void deleteBook(@PathVariable Long bookId){
        bookService.deleteBook(bookId);
    }
}