package com.capstonesam.springcapstoneplzwebservice.DTO;

import com.capstonesam.springcapstoneplzwebservice.domain.Login.User_info;
import com.capstonesam.springcapstoneplzwebservice.domainForFunction.StudyClub_info;
import com.capstonesam.springcapstoneplzwebservice.domainForFunction.Subject_info;
import lombok.Getter;

@Getter
public class StudyClubResponseDto {
    private String studyclub_topic;
    private String planguage_name;
    private User_info user_info;
//    private Subject_info subject_info;

    public StudyClubResponseDto(StudyClub_info entity){
        studyclub_topic = entity.getStudyclub_topic();
        planguage_name =entity.getPlanguage_name();
        user_info=entity.getUserinfo();
//        subject_info = entity.getSubjectinfo();
    }
}
