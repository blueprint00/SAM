package com.capstonesam.springcapstoneplzwebservice.DTO;

import com.capstonesam.springcapstoneplzwebservice.domain.Login.User_info;
import com.capstonesam.springcapstoneplzwebservice.domainForFunction.Language_info;
import lombok.Getter;

import java.sql.Date;

@Getter
public class LanguageResponseDto {
    private String language_name;
//    private Integer language_score;
    private String language_grade;
    private Date language_date;
    private User_info user_info;

    public LanguageResponseDto(Language_info entity){
        language_name=entity.getLanguage_name();
        language_grade=entity.getLanguage_grade();
        language_date=entity.getLanguage_date();
        user_info=entity.getUserinfo();
    }
}
