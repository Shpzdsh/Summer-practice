package com.shpzdsh.v3.services;

import com.shpzdsh.v3.models.Library;
import com.shpzdsh.v3.repositories.LibraryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LibraryService implements ILibrary {
    LibraryRepository libraryRepository;

    @Autowired
    public LibraryService(LibraryRepository libraryRepository) {
        this.libraryRepository = libraryRepository;
    }

    @Override
    public List<Library> getAllBooks() {
        return libraryRepository.findAll();
    }

    @Override
    public Optional<Library> findById(int id_book) {
        return libraryRepository.findById(id_book);
    }

    @Override
    public Library save(Library library) {
        return libraryRepository.save(library);
    }

    @Override
    public void deleteById(int id_book) {
        libraryRepository.deleteById(id_book);
    }
}
