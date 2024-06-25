package com.library.librarymanagment.dao;

import com.library.librarymanagment.model.AdminSignup;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminSignupDao extends JpaRepository<AdminSignup, Integer> {

    @Query(value= "select count(*) from admin_signup where username=:userName and password=:password",nativeQuery = true)
    public Integer validateAdmin(@Param("userName")String name, @Param("password") String pass);

}
