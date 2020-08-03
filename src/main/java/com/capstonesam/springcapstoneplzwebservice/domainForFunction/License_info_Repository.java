package com.capstonesam.springcapstoneplzwebservice.domainForFunction;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.stream.Stream;

public interface License_info_Repository extends JpaRepository<License_info, Long> {

    @Query(value = "SELECT * FROM license_info l where l.user_num = :user_num ", nativeQuery = true)
    Stream<License_info> findLicense(@Param("user_num")Long user_num);


    @Query(value ="SELECT COUNT(license_ID) FROM license_info l WHERE l.user_num=:usernum", nativeQuery = true)
    long CountLicense(@Param("usernum")Long user_num);


    //    long countByUserinfo(Long user_num);


}
