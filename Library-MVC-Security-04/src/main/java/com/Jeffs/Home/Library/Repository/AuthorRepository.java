package com.Jeffs.Home.Library.Repository;

import com.Jeffs.Home.Library.Entity.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Author, Integer> {
}
