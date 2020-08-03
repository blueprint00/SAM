package com.capstonesam.springcapstoneplzwebservice.DTO;

import com.capstonesam.springcapstoneplzwebservice.domain.Login.User_info;
import com.capstonesam.springcapstoneplzwebservice.domainForFunction.Interest_area_info;
import lombok.Getter;

@Getter
public class InterestAreaResponseDto {

    private String interest_area_1;
    private String interest_area_2;
    private String interest_area_3;
    private User_info userInfo;

    public InterestAreaResponseDto(Interest_area_info entity){
        interest_area_1=entity.getInterest_area_1();
        interest_area_2=entity.getInterest_area_2();
        interest_area_3=entity.getInterest_area_3();
        userInfo=entity.getUserinfo();

    }

}
