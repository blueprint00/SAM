package com.capstonesam.springcapstoneplzwebservice.domainForFunction;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.stream.Stream;

public interface Interest_planguage_info_Repository extends JpaRepository<Interest_planguage_info, Long> {

    @Query(value = "SELECT * FROM interest_planguage_info i where i.user_num = :user_num ", nativeQuery = true)
    Stream<Interest_planguage_info> findInteretPlang(@Param("user_num")Long user_num);

}
