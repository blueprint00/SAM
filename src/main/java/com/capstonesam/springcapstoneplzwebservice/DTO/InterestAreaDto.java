package com.capstonesam.springcapstoneplzwebservice.DTO;

import com.capstonesam.springcapstoneplzwebservice.domain.Login.User_info;
import com.capstonesam.springcapstoneplzwebservice.domainForFunction.Interest_area_info;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class InterestAreaDto {

    private String interest_area_1;
    private String interest_area_2;
    private String interest_area_3;
    private User_info userInfo;

    @Builder
    public InterestAreaDto(String interest_area_1, String interest_area_2, String interest_area_3, User_info user_info){

        this.interest_area_1 = interest_area_1;
        this.interest_area_2 = interest_area_2;
        this.interest_area_3 = interest_area_3;
        this.userInfo = user_info;

    }

    public Interest_area_info toEntity(){
        return Interest_area_info.builder()
                .interest_area_1(interest_area_1)
                .interest_area_2(interest_area_2)
                .interest_area_3(interest_area_3)
                .user_info(userInfo)
                .build();
    }
}
