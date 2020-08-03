package com.capstonesam.springcapstoneplzwebservice.DTO;

import com.capstonesam.springcapstoneplzwebservice.domain.Login.User_info;
import com.capstonesam.springcapstoneplzwebservice.domainForFunction.Interest_planguage_info;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class InterestPlanguageDto {

    private String interest_plang_1;
    private String interest_plang_2;
    private String interest_plang_3;
    private User_info userInfo;

    @Builder
    public InterestPlanguageDto(String interest_planguage_1, String interest_planguage_2, String interest_planguage_3, User_info user_info){


        this.interest_plang_1 = interest_planguage_1;
        this.interest_plang_2 = interest_planguage_2;
        this.interest_plang_3 = interest_planguage_3;
        this.userInfo = user_info;

    }

    public Interest_planguage_info toEntity(){
        return Interest_planguage_info.builder()
                .interest_planguage_1(interest_plang_1)
                .interest_planguage_2(interest_plang_2)
                .interest_planguage_3(interest_plang_3)
                .user_info(userInfo)
                .build();
    }

}
