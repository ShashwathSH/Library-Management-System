package com.shashwathsh.Library.Management.System.controller;

import com.shashwathsh.Library.Management.System.dto.AuthorDTO;
import com.shashwathsh.Library.Management.System.dto.BookDTO;
import com.shashwathsh.Library.Management.System.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

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