package com.capstonesam.springcapstoneplzwebservice.domainForFunction;

import com.capstonesam.springcapstoneplzwebservice.domain.Login.User_info;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.stream.Stream;

public interface Project_info_Repository extends JpaRepository<Project_info, Long> {
//    Stream<Project_info> findByUserinfo(User_info user_info);

    @Query(value = "SELECT * FROM project_info p where p.user_num = :user_num ", nativeQuery = true)
    Stream<Project_info> findProject(@Param("user_num")Long user_num);


    @Query(value ="SELECT COUNT(project_ID) FROM project_info p WHERE p.user_num=:usernum", nativeQuery = true)
    long CountProject(@Param("usernum")Long user_num);

}
