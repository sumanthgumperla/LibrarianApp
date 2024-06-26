package com.library.librarymanagment.dao;

import com.library.librarymanagment.model.FineForStudent;
import com.library.librarymanagment.model.IssueBook;
import com.library.librarymanagment.model.OutputFine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IssueBookDao extends JpaRepository<IssueBook,Integer> {

//returns count of no of books having fine
    @Query(value="select count(*) from issue_book where student_id=:studentId and datediff(curdate(),issue_date) >:daysDifference",nativeQuery = true)
    public Integer checkIsFineExists(@Param("daysDifference") Integer daysDifference, @Param("studentId") Integer studentId);


    @Query(value="select sum( datediff(curdate(),issue_date)) from issue_book where student_id=:studentId and datediff(curdate(),issue_date) >:daysDifference ",nativeQuery = true)
    public Integer checkFineAmount(@Param("daysDifference") Integer daysDifference, @Param("studentId") Integer studentId);

    @Query(value="select *,(datediff(curdate(),STR_TO_DATE(issue_date,'%Y-%m-%d'))-:daysDifference)*5 as fine from issue_book where student_id=:studentId and datediff(curdate(),STR_TO_DATE(issue_date,'%Y-%m-%d')) >:daysDifference ",nativeQuery = true)
    public List<Object[]> findfines(@Param("daysDifference") Integer daysDifference, @Param("studentId") Integer studentId);

    @Query(value = "select new com.library.librarymanagment.model.FineForStudent((e.bookId),(e.studentId)) from issue_book e where student_id=:studentId",nativeQuery = true)
    List<FineForStudent> specificfines(@Param("studentId") Integer studentId);

//gives total amount of fine
@Query(value="select (sum(datediff(curdate(),issue_date))-:daysDifference)*1 from issue_book where student_id=:studentId and datediff(curdate(),issue_date) >:daysDifference",nativeQuery = true)
public Integer findFineAmount(@Param("daysDifference") Integer daysDifference, @Param("studentId") Integer studentId);



}
