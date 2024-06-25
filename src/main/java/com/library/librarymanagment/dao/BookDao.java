package com.library.librarymanagment.dao;

import com.library.librarymanagment.model.Books;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.awt.print.Book;

@Repository
public interface BookDao extends JpaRepository<Books, Integer> {


    @Modifying
    @Query(value="update issue_book  set isavalable=0 where book_id=:bookId",nativeQuery = true)
    public void flagbook(@Param("bookId") Integer bookId);
    
}
