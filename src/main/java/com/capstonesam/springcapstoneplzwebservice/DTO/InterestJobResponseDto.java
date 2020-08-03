package com.capstonesam.springcapstoneplzwebservice.DTO;

import com.capstonesam.springcapstoneplzwebservice.domain.Login.User_info;
import com.capstonesam.springcapstoneplzwebservice.domainForFunction.Interest_job_info;
import lombok.Getter;

@Getter
public class InterestJobResponseDto {

    private String interest_job_1;
    private String interest_job_2;
    private String interest_job_3;
    private User_info userInfo;

    public InterestJobResponseDto(Interest_job_info entity){
        interest_job_1=entity.getInterest_job_1();
        interest_job_2=entity.getInterest_job_2();
        interest_job_3=entity.getInterest_job_3();
        userInfo=entity.getUserinfo();

    }

}
