package com.library.librarymanagment.service;

import com.library.librarymanagment.dao.AdminSignupDao;
import com.library.librarymanagment.dao.BookDao;
import com.library.librarymanagment.dao.IssueBookDao;
//import com.library.librarymanagment.dao.StudentDao;
import com.library.librarymanagment.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class AdminService {
//    @Autowired
//    StudentDao studentDao;

    @Autowired
    BookDao bookDao;

    @Autowired
    AdminSignupDao adminDao;

    @Autowired
    IssueBookDao issueBookDao;
//
//    public Student addStudent(Student student) {
//        System.out.println(student.getName());
//        System.out.println(student.getBranch());
//        System.out.println(student.getDataOfAdding());
//        return studentDao.save(student);
//
//    }

    public void addBook(Books book) {

        bookDao.save(book);

    }

    public List<Books> searchbooks() {

        return bookDao.findAll();
    }

    public int validateAdmin(String adminName, String adminPassword) {

        return adminDao.validateAdmin(adminName, adminPassword);
    }

    public void addAdmin(AdminSignup adminSignup) {
        adminDao.save(adminSignup);

    }


    public Integer updateFine(Integer studentId) {

        return issueBookDao.checkIsFineExists(20, studentId);

    }

    public Integer checkFineAmount(Integer studentId) {

        return issueBookDao.checkFineAmount(20, studentId);

    }

    public Map<Integer, OutputFine> findFines(Integer studentId) {
        List<Object[]> outputResults = issueBookDao.findfines(20, studentId);
        Map<Integer, OutputFine> fineMap = new HashMap<>();
        outputResults.stream().forEach((record) -> {
            Integer bookId = (Integer) record[0];
            boolean isReturned = (boolean) record[1];
            String issueDate = (String) record[2];
            Integer studId = (Integer) record[3];
            Long fine = (Long) record[4];
            fineMap.put(bookId, new OutputFine(bookId, studId, issueDate, isReturned, fine));
        });

        return fineMap;
    }

    public List<FineForStudent> specificfines(Integer studentId) {

        return issueBookDao.specificfines(studentId);


    }


    public void flagBook(Integer bookId) {
         bookDao.flagbook(bookId);


    }

    public boolean updateflag(Integer bookid) {
        Books updatedBook = bookDao.findById(bookid).orElse(null);
        if(updatedBook != null) {
            updatedBook.setIsavalable(false);
            bookDao.save(updatedBook);

        }
        return updatedBook.isIsavalable();
    }

}