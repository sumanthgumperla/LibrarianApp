package com.library.librarymanagment.controller;


import com.library.librarymanagment.model.*;
import com.library.librarymanagment.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin("http://localhost:4200")
@RequestMapping("admin")
public class AdminController {

    @Autowired
    private AdminService adminService;

    @GetMapping("searchbooks")
    public List<Books> searchBooks() {

       return new ArrayList<Books>();

  //  return adminService.searchbooks();
    }

    @PostMapping("savebook")
    public void addBook(@RequestBody Books book) {


       adminService.addBook(book);

    }

@PostMapping("adminsignup")
public void addAdmin(@RequestBody AdminSignup adminSignup) {

        adminService.addAdmin(adminSignup);

}

    @GetMapping("validate/{userName}/{password}")
    public int validateAdmin(@PathVariable("userName") String adminId, @PathVariable("password") String adminPassword) {
        int flag = 0;
          return adminService.validateAdmin(adminId,adminPassword);
    }


    @GetMapping("checkFine/{studentId}")
    public int checkFine(@PathVariable("studentId") Integer studentId) {

        return adminService.updateFine(studentId);
    }

    @GetMapping("checkFineAmount/{studentId}")
    public int checkFineAmount(@PathVariable("studentId") Integer studentId) {

        return adminService.checkFineAmount(studentId);
    }
    @GetMapping("findfines/{studentId}")
    public Map<Integer,OutputFine> findfines(@PathVariable("studentId") Integer studentId) {

        return adminService.findFines(studentId);
    }


    public List<FineForStudent> specificfines(@PathVariable("studentId") Integer studentId) {

        return adminService.specificfines(studentId);
    }


    @GetMapping("flagbook/{bookid}")
    public void flagBook(@PathVariable("bookid") Integer bookid) {
    adminService.flagBook(bookid);

    }

    @PostMapping("unavalablebook/{studentId}")
    public boolean updateflag(@PathVariable("studentId") Integer stdId){
        return adminService.updateflag(stdId);
}


}
