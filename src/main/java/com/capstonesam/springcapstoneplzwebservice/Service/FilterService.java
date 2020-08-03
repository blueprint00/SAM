package com.capstonesam.springcapstoneplzwebservice.Service;

import com.capstonesam.springcapstoneplzwebservice.DTO.FilterResponseDto;
import com.capstonesam.springcapstoneplzwebservice.domain.Login.User_info_Repository;
import com.capstonesam.springcapstoneplzwebservice.domainForFunction.Subject_info_Repository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


@AllArgsConstructor
@Service

public class FilterService {

private User_info_Repository user_info_repository;
private Subject_info_Repository subject_info_repository;

    @Transactional(readOnly = true)
        public List<FilterResponseDto> conditionfind(String  user_admyear,String  user_major, String user_num, String user_name, String subject_name, String subject_option, String subject_grade, String planguage_name, String contestnum, String studyclubnum, String projectnum, String internnum, String educationnum, String topcit, String toeic){

        List <FilterResponseDto> filterResponseDtomajor = new ArrayList<>();
        List <FilterResponseDto> filterResponseDtoadmyear= new ArrayList<>();
        List <FilterResponseDto> filterResponseDtosubname= new ArrayList<>();
        List <FilterResponseDto> filterResponseDtosuboption= new ArrayList<>();

        List <FilterResponseDto> filterResponseDtoresult= new ArrayList<>();

       // double subjectgrade= Double.parseDouble(subject_grade);
       // Long contest_num = Long.parseLong(contestnum);
       // Long studyclub_num = Long.parseLong(studyclubnum);
       // Long project_num = Long.parseLong(projectnum);
       // Long intern_num = Long.parseLong(internnum);
       // Long education_num = Long.parseLong(educationnum);
       // Long topcitnum = Long.parseLong(topcit);
       // Long toeicnum= Long.parseLong(toeic);

        if(user_major != null){
            filterResponseDtomajor = user_info_repository.findmajor(user_major).map(FilterResponseDto::new).collect(Collectors.toList());
        }
        if(user_admyear != null ){
            filterResponseDtoadmyear = user_info_repository.findadmyear(user_admyear).map(FilterResponseDto::new).collect(Collectors.toList());
        }

        if(subject_name != null ){
            filterResponseDtosubname = subject_info_repository.findsubname(subject_name).collect(Collectors.toList());
            System.out.println(filterResponseDtosubname.get(0));
        }

        if(subject_option != null ){
            filterResponseDtosuboption = subject_info_repository.findsuboption(subject_option).collect(Collectors.toList());
        }

        if(filterResponseDtomajor.get(0).getUser_num().equals( filterResponseDtosuboption.get(0).getUser_num())){

            filterResponseDtoresult.add(filterResponseDtomajor.get(0));
        }


        return filterResponseDtoresult;
    }



}
