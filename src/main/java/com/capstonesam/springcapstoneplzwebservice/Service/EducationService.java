package com.capstonesam.springcapstoneplzwebservice.Service;

import com.capstonesam.springcapstoneplzwebservice.DTO.EducationDto;
import com.capstonesam.springcapstoneplzwebservice.DTO.EducationResponseDto;
import com.capstonesam.springcapstoneplzwebservice.domain.Login.User_info;
import com.capstonesam.springcapstoneplzwebservice.domainForFunction.Education_info_Repository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class EducationService {
    private Education_info_Repository education_info_repository;

    @Transactional
    public void saveEducation(String education_name, String education_period, String education_content, User_info userinfo){
        EducationDto eDto;

        eDto = EducationDto.builder()
                .education_name(education_name)
                .education_period(education_period)
                .education_content(education_content)
                .user_info(userinfo)
                .build();

        education_info_repository.save(eDto.toEntity());
    }

    @Transactional(readOnly = true)
    public List<EducationResponseDto> EducationfindByUserinfo(Long usernum){

        return education_info_repository.findEducation(usernum)
                .map(EducationResponseDto::new)
                .collect(Collectors.toList());//.map(EducationDto::new).collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public Long EducationGrade(Long usernum){

        long threeMonth = education_info_repository.CountEducationwithPeriod(usernum, "3month");
        long sixMonth = education_info_repository.CountEducationwithPeriod(usernum, "6month");
        long twoeleveMonth = education_info_repository.CountEducationwithPeriod(usernum, "12month");
        long ayear = education_info_repository.CountEducationwithPeriod(usernum, "1year");

        long educationGrade = threeMonth*2 + sixMonth*3 + threeMonth*4 + ayear*5;

        return educationGrade;
    }

}
