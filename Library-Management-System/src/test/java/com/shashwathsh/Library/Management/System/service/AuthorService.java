package com.shashwathsh.Library.Management.System.service;

import com.shashwathsh.Library.Management.System.dto.AuthorDTO;
import com.shashwathsh.Library.Management.System.entity.AuthorEntity;
import com.shashwathsh.Library.Management.System.repository.AuthorRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AuthorService {
    private final AuthorRepository authorRepository;
    private final ModelMapper modelMapper;

    // GET all authors
    public List<AuthorDTO> getAllAuthors() {
        return authorRepository.findAll()
                .stream()
                .map(authorEntity -> modelMapper.map(authorEntity,AuthorDTO.class))
                .toList();
    }

    //GET author by ID
    public AuthorDTO getAuthorById(Long authorId) {
        Optional<AuthorEntity> author = authorRepository.findById(authorId);
        return modelMapper.map(author, AuthorDTO.class);
    }

    //CREATE new author
    public AuthorDTO createAuthor(AuthorDTO authorDTO) {
        AuthorEntity authorEntity = modelMapper.map(authorDTO, AuthorEntity.class);
        AuthorEntity createdAuthor = authorRepository.save(authorEntity);
        return modelMapper.map(createdAuthor, AuthorDTO.class);
    }
}
