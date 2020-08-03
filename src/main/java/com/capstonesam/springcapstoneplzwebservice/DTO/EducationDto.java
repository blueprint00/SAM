package com.capstonesam.springcapstoneplzwebservice.DTO;

import com.capstonesam.springcapstoneplzwebservice.domain.Login.User_info;
import com.capstonesam.springcapstoneplzwebservice.domainForFunction.Education_info;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class EducationDto {

    private Long education_ID;
    private String education_name;
    private String education_period;
    private String education_content;
    private User_info user_info;

    @Builder
    public EducationDto(Long education_ID, String education_name, String education_period, String education_content, User_info user_info){
        this.education_ID = education_ID;
        this.education_name = education_name;
        this.education_period = education_period;
        this.education_content = education_content;
        this.user_info = user_info;
    }

    public Education_info toEntity(){
        return Education_info.builder()
                .education_ID(education_ID)
                .education_name(education_name)
                .education_period(education_period)
                .education_content(education_content)
                .user_info(user_info)
                .build();
    }

}
