package com.capstonesam.springcapstoneplzwebservice.DTO;

import com.capstonesam.springcapstoneplzwebservice.domain.Login.User_info;
import com.capstonesam.springcapstoneplzwebservice.domainForFunction.Hackathon_info;
import lombok.Getter;

@Getter
public class HackathonResponseDto {
    private String hack_topic;
    private String hack_record;
    //    private Long hack_doc_ID;
    private User_info user_info;

    public HackathonResponseDto(Hackathon_info entity) {
        hack_topic = entity.getHack_topic();
        hack_record = entity.getHack_record();
        user_info = entity.getUserinfo();
    }

}