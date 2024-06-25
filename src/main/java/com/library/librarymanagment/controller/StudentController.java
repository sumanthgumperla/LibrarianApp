package com.library.librarymanagment.controller;

import com.library.librarymanagment.model.Student;
import com.library.librarymanagment.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("student")
public class StudentController {

    @Autowired
    StudentService studentService;


    @GetMapping("findStudent/{Id}")
    public ResponseEntity<Student> pullStudentDetails(@PathVariable int Id){
        Student student = studentService.pullStudentDetails(Id);

       if(student!=null)
           return ResponseEntity.ok(student);
       else
           return ResponseEntity.notFound().build();



    }


}
