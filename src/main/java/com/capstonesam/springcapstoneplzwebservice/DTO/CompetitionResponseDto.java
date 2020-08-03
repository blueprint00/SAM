package com.capstonesam.springcapstoneplzwebservice.DTO;

import com.capstonesam.springcapstoneplzwebservice.domain.Login.User_info;
import com.capstonesam.springcapstoneplzwebservice.domainForFunction.Competition_info;
import lombok.Getter;

import java.sql.Date;

@Getter
public class CompetitionResponseDto {
    private String competition_name;
    private Integer competition_score;
    private Date competition_date;
    private User_info user_info;

    public CompetitionResponseDto(Competition_info entity){
        competition_name=entity.getCompetition_name();
        competition_score=entity.getCompetition_score();
        competition_date=entity.getCompetition_date();
        user_info=entity.getUserinfo();
    }
}
