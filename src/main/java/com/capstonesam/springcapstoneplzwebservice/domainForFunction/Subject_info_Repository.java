package com.capstonesam.springcapstoneplzwebservice.domainForFunction;

import com.capstonesam.springcapstoneplzwebservice.DTO.FilterResponseDto;
import com.capstonesam.springcapstoneplzwebservice.domain.Login.User_info;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.stream.Stream;

public interface Subject_info_Repository extends JpaRepository<Subject_info, Long> {
    @Query(value = "SELECT subject_id,subject_name, subject_credit, subject_grade, subject_option, user_num FROM subject_info s where s.user_num = :user_num and s.subject_option=:subject_option", nativeQuery = true)
        Stream<Subject_info> findmajor(@Param("user_num")Long user_num , @Param("subject_option") String subject_option);

    @Query(value = "SELECT * FROM subject_info s where s.user_num = :user_num", nativeQuery = true)
    Stream<Subject_info> findAll(@Param("user_num")Long user_num);

    @Query(value = "SELECT user_num, user_name FROM subject_info s  user_info u where s.subject_name = :subject_name and u.user_num = :s.user_num", nativeQuery = true)
    Stream<FilterResponseDto> findsubname(@Param("subject_name")String  subject_name);

    @Query(value = "SELECT user_num, user_name FROM subject_info s  user_info u where s.subject_option = :subject_option and u.user_num = :s.user_num", nativeQuery = true)
    Stream<FilterResponseDto> findsuboption(@Param("subject_option")String  subject_option);

    @Query(value = "SELECT user_admyear, SUM(subject_grade) AS allGrade FROM subject_info s , user_info GROUP BY user_info.user_admyear", nativeQuery = true)
    Stream<List> findGraph1();

}
