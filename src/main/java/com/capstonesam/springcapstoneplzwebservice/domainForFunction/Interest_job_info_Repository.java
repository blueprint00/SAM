package com.capstonesam.springcapstoneplzwebservice.domainForFunction;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.stream.Stream;

public interface Interest_job_info_Repository extends JpaRepository<Interest_job_info, Long> {

    @Query(value = "SELECT * FROM interest_job_info i where i.user_num = :user_num ", nativeQuery = true)
    Stream<Interest_job_info> findInteretJob(@Param("user_num")Long user_num);


    @Query(value = "SELECT interest_job_1 FROM interest_job_info i where i.user_num = :user_num ", nativeQuery = true)
    String findMostInteretJob(@Param("user_num")Long user_num);
/*
    @Query(value = "SELECT user_num FROM interest_job_info i where i.interest_job_1 = :interest_job_1 ", nativeQuery = true)
    Stream <Long> findUser1(@Param("interest_job_1")String interest_job);

    @Query(value = "SELECT user_num FROM interest_job_info i where i.interest_job_2 = :interest_job_1 ", nativeQuery = true)
    Stream <Long> findUser2(@Param("interest_job_2")String interest_job);

    @Query(value = "SELECT user_num FROM interest_job_info i where i.interest_job_3 = :interest_job_1 ", nativeQuery = true)
    Stream <Long> findUser3(@Param("interest_job_3")String interest_job);
*/

}
