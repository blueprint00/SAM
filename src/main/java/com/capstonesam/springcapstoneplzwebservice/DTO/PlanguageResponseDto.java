package com.capstonesam.springcapstoneplzwebservice.DTO;

import com.capstonesam.springcapstoneplzwebservice.domain.Login.User_info;
import com.capstonesam.springcapstoneplzwebservice.domainForFunction.Planguage_info;;
import lombok.Getter;

@Getter
public class PlanguageResponseDto {
    private String planguage_name;
    private String planguage_level;
    private User_info user_info;

    public PlanguageResponseDto(Planguage_info entity) {
        this.planguage_name = entity.getPlanguage_name();
        this.planguage_level = entity.getPlanguage_level();
        this.user_info = entity.getUserinfo();
    }
}
