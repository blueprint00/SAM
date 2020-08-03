package com.capstonesam.springcapstoneplzwebservice.DTO;

import com.capstonesam.springcapstoneplzwebservice.domain.Login.User_info;
import com.capstonesam.springcapstoneplzwebservice.domainForFunction.StudyClub_info;
import com.capstonesam.springcapstoneplzwebservice.domainForFunction.Subject_info;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class StudyClubDto {
    private String studyclub_topic;
    private String planguage_name;
    private User_info user_info;
//    private Subject_info subject_info;

    @Builder
    public StudyClubDto(String studyclub_topic, String planguage_name, User_info user_info/*, Subject_info subject_info*/){
        this.studyclub_topic=studyclub_topic;
        this.planguage_name=planguage_name;
        this.user_info = user_info;
//        this.subject_info=subject_info;
    }

    public StudyClub_info toEntity(){
        return StudyClub_info.builder()
                .studyclub_topic(studyclub_topic)
                .planguage_name(planguage_name)
                .user_info(user_info)
//                .subject_info(subject_info)
                .build();
    }

}
