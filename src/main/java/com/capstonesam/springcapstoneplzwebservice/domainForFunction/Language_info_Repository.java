package com.capstonesam.springcapstoneplzwebservice.domainForFunction;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.stream.Stream;

public interface Language_info_Repository extends JpaRepository<Language_info, Long> {
//    long countByUserinfo(Long user_num);

    @Query(value = "SELECT * FROM language_info l where l.user_num = :user_num ", nativeQuery = true)
    Stream<Language_info> findLanguage(@Param("user_num")Long user_num);


    @Query(value ="SELECT COUNT(language_ID) FROM language_info l WHERE l.user_num=:usernum", nativeQuery = true)
    long CountLanguage(@Param("usernum")Long user_num);

}
