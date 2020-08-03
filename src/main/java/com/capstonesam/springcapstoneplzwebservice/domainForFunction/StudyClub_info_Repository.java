package com.capstonesam.springcapstoneplzwebservice.domainForFunction;

import com.capstonesam.springcapstoneplzwebservice.domain.Login.User_info;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.stream.Stream;

public interface StudyClub_info_Repository extends JpaRepository<StudyClub_info, Long> {
//    Stream<StudyClub_info> findByUserinfo(User_info user_info);

    @Query(value = "SELECT * FROM studyclub_info s where s.user_num = :user_num ", nativeQuery = true)
    Stream<StudyClub_info> findStudyClub(@Param("user_num")Long user_num);


    @Query(value ="SELECT COUNT(studyclub_ID) FROM studyclub_info s WHERE s.user_num=:usernum", nativeQuery = true)
    long CountStudyclub(@Param("usernum")Long user_num);

}
