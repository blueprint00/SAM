package com.capstonesam.springcapstoneplzwebservice.DTO;

import com.capstonesam.springcapstoneplzwebservice.domain.Login.User_info;
import com.capstonesam.springcapstoneplzwebservice.domainForFunction.Interest_job_info;
import com.capstonesam.springcapstoneplzwebservice.domainForFunction.Interest_planguage_info;
import lombok.Getter;

@Getter
public class InterestPlanguageResponseDto {

    private Long interest_plang_id;
    private String interest_plang_1;
    private String interest_plang_2;
    private String interest_plang_3;
    private User_info userInfo;

    public InterestPlanguageResponseDto(Interest_planguage_info entity){
        interest_plang_id=entity.getInterest_plang_id();
        interest_plang_1=entity.getInterest_plang_1();
        interest_plang_2=entity.getInterest_plang_2();
        interest_plang_3=entity.getInterest_plang_3();
        userInfo=entity.getUserinfo();

    }


}
