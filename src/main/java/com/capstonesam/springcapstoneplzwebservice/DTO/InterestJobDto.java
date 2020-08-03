package com.capstonesam.springcapstoneplzwebservice.DTO;

import com.capstonesam.springcapstoneplzwebservice.domain.Login.User_info;
import com.capstonesam.springcapstoneplzwebservice.domainForFunction.Interest_job_info;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class InterestJobDto {

    private String interest_job_1;
    private String interest_job_2;
    private String interest_job_3;
    private User_info userInfo;

    @Builder
    public InterestJobDto(String interest_job_1, String interest_job_2, String interest_job_3, User_info user_info){

        this.interest_job_1 = interest_job_1;
        this.interest_job_2 = interest_job_2;
        this.interest_job_3 = interest_job_3;
        this.userInfo = user_info;

    }

    public Interest_job_info toEntity(){
        return Interest_job_info.builder()
                .interest_job_1(interest_job_1)
                .interest_job_2(interest_job_2)
                .interest_job_3(interest_job_3)
                .user_info(userInfo)
                .build();
    }

}
