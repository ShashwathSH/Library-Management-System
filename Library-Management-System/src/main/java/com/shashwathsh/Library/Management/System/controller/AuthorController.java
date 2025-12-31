package com.shashwathsh.Library.Management.System.controller;

import com.shashwathsh.Library.Management.System.dto.AuthorDTO;
import com.shashwathsh.Library.Management.System.dto.BookDTO;
import com.shashwathsh.Library.Management.System.service.AuthorService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/authors")
@RequiredArgsConstructor
public class AuthorController {
    private final AuthorService authorService;

    @GetMapping
    public List<AuthorDTO> getAllAuthors(){
        return authorService.getAllAuthors();
    }

    @GetMapping("/search")
    public AuthorDTO findByNameContainingIgnoreCase(@RequestParam String name){
        return authorService.findByNameContainingIgnoreCase(name);
    }

    @GetMapping("/{authorId}")
    public AuthorDTO getAuthorById(@PathVariable Long authorId){
        return authorService.getAuthorById(authorId);
    }

    @PostMapping
    public AuthorDTO createAuthor(@RequestBody AuthorDTO authorDTO){
        return authorService.createAuthor(authorDTO);
    }

    @PutMapping("{authorId}")
    public AuthorDTO updateAuthor(@PathVariable Long authorId,
                                  @RequestBody AuthorDTO authorDTO){
        return authorService.updateAuthor(authorId,authorDTO);
    }

    @DeleteMapping("/{authorId}")
    public void deleteAuthor(@PathVariable Long authorId){
        authorService.deleteAuthor(authorId);
    }

}