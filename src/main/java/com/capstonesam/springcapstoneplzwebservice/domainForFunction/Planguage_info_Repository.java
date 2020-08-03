package com.capstonesam.springcapstoneplzwebservice.domainForFunction;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.stream.Stream;

@Repository
public interface Planguage_info_Repository extends JpaRepository<Planguage_info, Long> {

    //List<Planguage_info> findByUserinfo(Long usernum);

    @Query(value = "SELECT * FROM planguage_info p where p.user_num = :user_num ", nativeQuery = true)
    Stream<Planguage_info> findPlanguage(@Param("user_num")Long user_num);

 //   Stream<Planguage_info> findByUserinfo(Long usernum);


    @Query(value ="SELECT COUNT(planguage_ID) FROM planguage_info p WHERE p.planguage_name=:planguage_name and p.planguage_level=:planguage_level", nativeQuery = true)
    long CountPlanguageWithPlanguageLevel(@Param("planguage_name")String planguage_name, @Param("planguage_level")String planguage_level);


//    long countByPlanguagenameAndPlanguagelevel(String planguage_name, String planguage_level);

    @Query(value ="SELECT COUNT(planguage_ID) FROM planguage_info p WHERE p.planguage_level=:planguage_level", nativeQuery = true)
    long CountPlanguageLevel(@Param("planguage_level")String planguage_level);

    @Query(value = "SELECT user_num FROM planguage_info p where p.planguage_name = :planguage_name ", nativeQuery = true)
    Stream<Long> findUser(@Param("planguage_name")String plang);


}
