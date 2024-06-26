package com.library.librarymanagment.controller;


import com.library.librarymanagment.model.*;
import com.library.librarymanagment.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("http://localhost:4200")
@RequestMapping("admin")
public class AdminController {

    @Autowired
    private AdminService adminService;

   //to search for books
    @GetMapping("searchbooks")
    public List<Books> searchBooks() {
   return adminService.searchbooks();
    }

    //to save the new book in the library

    @PostMapping("savebook")
    public void addBook(@RequestBody Books book) {
       adminService.addBook(book);

    }


//admin Signup
@PostMapping("adminsignup")
public void addAdmin(@RequestBody AdminSignup adminSignup) {

        adminService.addAdmin(adminSignup);

}

//validation of the admin
    @GetMapping("validate/{userName}/{password}")
    public int validateAdmin(@PathVariable("userName") String adminId, @PathVariable("password") String adminPassword) {
        int flag = 0;
          return adminService.validateAdmin(adminId,adminPassword);
    }



//return studentid and fine amount and take the student id
@GetMapping("fineamount/{Id}")
    public FineDetails findFineAmount (@PathVariable Integer studentdId) {
        return adminService.findFineAmount(studentdId);
    }

    @GetMapping("returnbook/{id}")
    public void returnBook(@PathVariable Integer id) {
adminService.returnBook(id);
}

    }

