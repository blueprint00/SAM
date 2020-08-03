package com.capstonesam.springcapstoneplzwebservice.DTO;

import com.capstonesam.springcapstoneplzwebservice.domain.Login.User_info;
import lombok.Getter;

@Getter
public class FilterResponseDto {

    private Long user_num;
    private String user_name;

    public FilterResponseDto(User_info entity){
        user_num = entity.getUser_num();
        user_name = entity.getUser_name();
    }

}
