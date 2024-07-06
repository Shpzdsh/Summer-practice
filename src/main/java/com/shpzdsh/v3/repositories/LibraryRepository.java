package com.shpzdsh.v3.repositories;

import com.shpzdsh.v3.models.Library;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface LibraryRepository extends JpaRepository<Library, Integer>{

    Optional<Library> findById(int id_book);

}
