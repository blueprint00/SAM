package com.capstonesam.springcapstoneplzwebservice.DTO;

import com.capstonesam.springcapstoneplzwebservice.domain.Login.User_info;
import com.capstonesam.springcapstoneplzwebservice.domainForFunction.Contest_info;
import lombok.Getter;

@Getter
public class ContestResponseDto {
    private String contest_topic;
    private String contest_record;
    //    private Long contest_doc_ID;
    private String planguage_name;
    private User_info userinfo;

    public ContestResponseDto(Contest_info entity){
        contest_topic = entity.getContest_topic();
        contest_record=entity.getContest_record();
        planguage_name=entity.getPlanguage_name();
        userinfo=entity.getUserinfo();
    }


}
