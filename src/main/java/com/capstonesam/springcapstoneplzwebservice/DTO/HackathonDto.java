package com.capstonesam.springcapstoneplzwebservice.DTO;

import com.capstonesam.springcapstoneplzwebservice.domain.Login.User_info;
import com.capstonesam.springcapstoneplzwebservice.domainForFunction.Hackathon_info;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class HackathonDto {

    private String hack_topic;
    private String hack_record;
//    private Long hack_doc_ID;
    private User_info user_info;

    @Builder
    public HackathonDto(String hack_topic, String hack_record, Long hack_doc_ID, User_info user_info){

        this.hack_topic=hack_topic;
        this.hack_record=hack_record;
//        this.hack_doc_ID=hack_doc_ID;
        this.user_info=user_info;

    }

    public Hackathon_info toEntity(){
        return Hackathon_info.builder()
                .hack_topic(hack_topic)
                .hack_record(hack_record)
//                .hack_doc_ID(hack_doc_ID)
                .user_info(user_info)
                .build();

    }

}
