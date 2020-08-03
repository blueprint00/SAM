package com.capstonesam.springcapstoneplzwebservice.DTO;

import com.capstonesam.springcapstoneplzwebservice.domain.Login.User_info;
import com.capstonesam.springcapstoneplzwebservice.domainForFunction.Project_info;
import com.capstonesam.springcapstoneplzwebservice.domainForFunction.Subject_info;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ProjectDto {
    private String project_topic;
    private String planguage_name;
    private User_info user_info;
    private Subject_info subject_info;

    @Builder
    public ProjectDto(String project_topic, String planguage_name, User_info user_info, Subject_info subject_info){
        this.project_topic=project_topic;
        this.planguage_name=planguage_name;
        this.user_info=user_info;
        this.subject_info=subject_info;
    }

    public Project_info toEntity(){
        return Project_info.builder()
                .project_topic(project_topic)
                .planguage_name(planguage_name)
                .user_info(user_info)
                .subject_info(subject_info)
                .build();
    }


}
