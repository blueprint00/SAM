package com.capstonesam.springcapstoneplzwebservice.DTO;

import com.capstonesam.springcapstoneplzwebservice.domain.Login.User_info;
import com.capstonesam.springcapstoneplzwebservice.domainForFunction.Education_info;
import lombok.Getter;

@Getter
public class EducationResponseDto {

    private String education_name;
    private String education_period;
    private String education_content;
    private User_info userinfo;

    public EducationResponseDto(Education_info entity){
        education_name = entity.getEducation_name();
        education_period=entity.getEducation_period();
        education_content=entity.getEducation_content();
        userinfo=entity.getUserinfo();
    }
}
