package com.capstonesam.springcapstoneplzwebservice.DTO;


import com.capstonesam.springcapstoneplzwebservice.domain.Login.User_info;
import com.capstonesam.springcapstoneplzwebservice.domainForFunction.Competition_info;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Date;

@Getter
@Setter
@NoArgsConstructor
public class CompetitionDto {
    private String competition_name;
    private Integer competition_score;
    private Date competition_date;
    private User_info user_info;

    @Builder
    public CompetitionDto(String competition_name, Integer competition_score, Date competition_date, User_info user_info){
        this.competition_name = competition_name;
        this.competition_score=competition_score;
        this.competition_date=competition_date;
        this.user_info=user_info;

    }

    public Competition_info toEntity(){
        return Competition_info.builder()
                .competition_name(competition_name)
                .competition_date(competition_date)
                .competition_score(competition_score)
                .user_info(user_info)
                .build();

    }
}
