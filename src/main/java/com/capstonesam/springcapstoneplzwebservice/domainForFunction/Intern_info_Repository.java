package com.capstonesam.springcapstoneplzwebservice.domainForFunction;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.stream.Stream;

public interface Intern_info_Repository extends JpaRepository<Intern_info, Long> {
//    List<Intern_info> findByUserinfo(Long usernum);

    @Query(value = "SELECT * FROM Intern_info i where i.user_num = :user_num ", nativeQuery = true)
    Stream<Intern_info> findIntern(@Param("user_num")Long user_num);

    @Query(value ="SELECT COUNT(intern_ID) FROM intern_info i WHERE i.user_num=:usernum", nativeQuery = true)
    long CountIntern(@Param("usernum")Long user_num);


}
