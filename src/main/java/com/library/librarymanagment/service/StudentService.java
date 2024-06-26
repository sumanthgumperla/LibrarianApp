package com.library.librarymanagment.service;

import com.library.librarymanagment.model.Student;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.net.SocketTimeoutException;
import java.util.Map;

@Service
public class StudentService {


    @Autowired
    @Qualifier("restTemplate1")
    RestTemplate restTemplate;

    @Value("${finalurl}")
    String serviceURL;

    public Student pullStudentDetails(Integer id) {

//        RestTemplate restTemplate = new RestTemplate();

    //String response=restTemplate.getForObject("http://localhost:8081/student/getstudent", String.class);
//    HttpHeaders headers = new HttpHeaders();
//    headers.set("Accept", "text/plain");
//
//    HttpEntity<String> httpEntity = new HttpEntity<>(headers);

     ResponseEntity<Student> responseEntity=restTemplate.getForEntity(serviceURL, Student.class, Map.of("Id",id));
//    ResponseEntity<String> responseEntity = restTemplate.exchange("http://localhost:8081/student/getstudent", HttpMethod.GET, httpEntity, String.class);
//    System.out.println(responseEntity.getStatusCode());
//    System.out.println(responseEntity.getBody());

        if( responseEntity.getBody()!=null)
            return responseEntity.getBody();
        else return null;

    }


}
