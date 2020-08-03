package com.capstonesam.springcapstoneplzwebservice.DTO;

import com.capstonesam.springcapstoneplzwebservice.domain.Login.User_info;
import com.capstonesam.springcapstoneplzwebservice.domainForFunction.Contest_info;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ContestDto {

    private String contest_topic;
    private String contest_record;
//    private Long contest_doc_ID;
    private String planguage_name;
    private User_info userinfo;

    @Builder
    public ContestDto(String contest_topic, String contest_record, String planguage_name, User_info user_info){
        this.contest_topic=contest_topic;
        this.contest_record = contest_record;
//        this.contest_doc_ID=contest_doc_ID;
        this.planguage_name=planguage_name;
        this.userinfo=user_info;
    }

    public Contest_info toEntity(){
        return Contest_info.builder()
                .contest_topic(contest_topic)
                .contest_record(contest_record)
 //               .contest_doc_ID(contest_doc_ID)
                .planguage_name(planguage_name)
                .user_info(userinfo)
                .build();
    }

}
