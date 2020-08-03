package com.capstonesam.springcapstoneplzwebservice.DTO;

import com.capstonesam.springcapstoneplzwebservice.domain.Login.User_info;
import com.capstonesam.springcapstoneplzwebservice.domainForFunction.Project_info;
import com.capstonesam.springcapstoneplzwebservice.domainForFunction.Subject_info;
import lombok.Getter;

@Getter

public class ProjectResponseDto {
    private String project_topic;
    private String planguage_name;
    private User_info user_info;
    private Subject_info subject_info;

    public ProjectResponseDto(Project_info entity){
        project_topic = entity.getProject_topic();
        planguage_name = entity.getPlanguage_name();
        user_info=entity.getUserinfo();
        subject_info=entity.getSubjectinfo();
    }

}
