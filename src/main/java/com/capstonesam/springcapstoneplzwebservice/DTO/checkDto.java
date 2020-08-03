package com.capstonesam.springcapstoneplzwebservice.DTO;

import com.capstonesam.springcapstoneplzwebservice.domain.Login.User_info;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class checkDto {

    private String user_name;
    private String user_pw;
    private String user_admyear;
    private String user_major;
    private String user_type;

    public User_info toEntity(){
        return User_info.builder()
                .user_name(user_name)
                .user_pw(user_pw)
                .user_admyear(user_admyear)
                .user_major(user_major)
                .user_type(user_type)
                .build();
    }


}
