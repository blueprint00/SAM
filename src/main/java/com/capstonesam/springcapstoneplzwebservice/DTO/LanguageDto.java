package com.capstonesam.springcapstoneplzwebservice.DTO;

import com.capstonesam.springcapstoneplzwebservice.domain.Login.User_info;
import com.capstonesam.springcapstoneplzwebservice.domainForFunction.Language_info;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Date;

@Getter
@Setter
@NoArgsConstructor
public class LanguageDto {
    private String language_name;
//    private Integer language_score;
    private String language_grade;
    private Date language_date;
    private User_info user_info;

    @Builder
    public LanguageDto(String language_name, String language_grade, Date language_date, User_info user_info){
        this.language_name=language_name;
        this.language_grade=language_grade;
        this.language_date=language_date;
        this.user_info=user_info;
    }

    public Language_info toEntity(){
        return Language_info.builder()
                .language_name(language_name)
                .language_grade(language_grade)
                .language_date(language_date)
                .user_info(user_info)
                .build();
    }

}
