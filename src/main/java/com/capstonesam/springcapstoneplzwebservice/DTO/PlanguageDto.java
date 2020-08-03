package com.capstonesam.springcapstoneplzwebservice.DTO;

import com.capstonesam.springcapstoneplzwebservice.domain.Login.User_info;
import com.capstonesam.springcapstoneplzwebservice.domainForFunction.Planguage_info;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter //오류 나면 Setting -> build ~~ -> Compiler -> Annotation
@NoArgsConstructor
public class PlanguageDto {
    private Long planguage_ID;
    private String planguage_name;
    private String planguage_level;
    private User_info user_info;

    @Builder
    public PlanguageDto(String planguage_name, String planguage_level, User_info user_info){
        this.planguage_name = planguage_name;
        this.planguage_level = planguage_level;
        this.user_info = user_info;
    }

    public  Planguage_info toEntity(){
        return Planguage_info.builder()
                .planguage_name(planguage_name)
                .planguage_level(planguage_level)
                .user_info(user_info)
                .build();
    }

}
