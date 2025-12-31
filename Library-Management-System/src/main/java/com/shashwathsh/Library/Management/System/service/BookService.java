package com.shashwathsh.Library.Management.System.service;

import com.shashwathsh.Library.Management.System.dto.AuthorDTO;
import com.shashwathsh.Library.Management.System.dto.BookDTO;
import com.shashwathsh.Library.Management.System.entity.AuthorEntity;
import com.shashwathsh.Library.Management.System.entity.BookEntity;
import com.shashwathsh.Library.Management.System.repository.AuthorRepository;
import com.shashwathsh.Library.Management.System.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.awt.print.Book;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BookService {
    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;
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

        AuthorEntity author = authorRepository.findById(bookDTO.getAuthorId())
                .orElseThrow(() ->
                        new RuntimeException("Author not found with id: " + bookDTO.getAuthorId())
                );

        BookEntity bookEntity = new BookEntity();
        bookEntity.setName(bookDTO.getName());
        bookEntity.setPrice(bookDTO.getPrice());
        bookEntity.setPublishDate(bookDTO.getPublishDate());
        bookEntity.setAuthor(author);

        BookEntity createdBook = bookRepository.save(bookEntity);

        return modelMapper.map(createdBook, BookDTO.class);
    }


    // UPDATE existing book
    public BookDTO updateBook(Long bookId, BookDTO bookDTO) {
        BookEntity existingBook = bookRepository.findById(bookId)
                .orElseThrow(() ->
                        new RuntimeException("Book not found with id: "+bookId)
                );


        existingBook.setName(bookDTO.getName());
        existingBook.setPrice(bookDTO.getPrice());
        existingBook.setPublishDate(bookDTO.getPublishDate());

        BookEntity savedBook = bookRepository.save(existingBook);

        return modelMapper.map(savedBook,BookDTO.class);
    }

    // DELETE a Book
    public void deleteBook(Long bookId) {
        bookRepository.deleteById(bookId);
        System.out.println("Deleted Book with id: " + bookId);
    }


    public BookDTO findBooksByTitle(String title) {
        BookEntity bookEntity =  bookRepository.findByNameContainingIgnoreCase(title);
        return modelMapper.map(bookEntity,BookDTO.class);
    }

    public List<BookDTO> findByPublishDateAfter(LocalDate date) {
        return  bookRepository.findByPublishDateAfter(date)
                .stream()
                .map(bookEntity -> modelMapper.map(bookEntity, BookDTO.class))
                .toList();

    }

    public List<BookDTO> findBooksByAuthor(Long authorId) {
        return bookRepository.findByAuthorAuthorId(authorId)
                .stream()
                .map(bookEntity -> modelMapper.map(bookEntity, BookDTO.class))
                .toList();
    }


}