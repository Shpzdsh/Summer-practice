package com.shpzdsh.v3.services;

import com.shpzdsh.v3.models.Library;

import java.util.List;
import java.util.Optional;

public interface ILibrary {

    List<Library> getAllBooks();

    Optional<Library> findById(int id_book);

    Library save(Library library);

    void deleteById(int id);

}
