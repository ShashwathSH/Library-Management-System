package com.shashwathsh.Library.Management.System.service;

import com.shashwathsh.Library.Management.System.dto.AuthorDTO;
import com.shashwathsh.Library.Management.System.dto.BookDTO;
import com.shashwathsh.Library.Management.System.entity.BookEntity;
import com.shashwathsh.Library.Management.System.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BookService {
    private final BookRepository bookRepository;
    private final ModelMapper modelMapper;

    //GET all books
    public List<BookDTO> getAllBooks() {
        return bookRepository.findAll()
                .stream()
                .map(bookEntity -> modelMapper.map(bookEntity,BookDTO.class))
                .toList();
    }

    //GET book by ID
    public BookDTO getBookById(Long bookId) {
        Optional<BookEntity> bookEntity = bookRepository.findById(bookId);
        return modelMapper.map(bookEntity, BookDTO.class);
    }

    //CREATE new book
    public BookDTO createBook(BookDTO bookDTO) {
        BookEntity bookEntity = modelMapper.map(bookDTO, BookEntity.class);
        BookEntity createdBook = bookRepository.save(bookEntity);
        return modelMapper.map(createdBook, BookDTO.class);
    }
}
