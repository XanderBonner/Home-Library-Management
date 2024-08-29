package com.Jeffs.Home.Library.Repository;

import com.Jeffs.Home.Library.Entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Integer> {
}
