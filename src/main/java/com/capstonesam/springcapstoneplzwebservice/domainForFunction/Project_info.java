package com.capstonesam.springcapstoneplzwebservice.domainForFunction;

import com.capstonesam.springcapstoneplzwebservice.domain.Login.User_info;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor
@Getter
@Entity
public class Project_info {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long project_ID;

    @Column(nullable = false, length=45)
    private String project_topic;

    @Column(nullable = false, length=45)
    private String planguage_name;

    //FK
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="user_num")
    private User_info userinfo;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="subject_ID")
    private Subject_info subjectinfo;

    @Builder
    public Project_info(String project_topic, String planguage_name, User_info user_info, Subject_info subject_info){
        this.project_topic = project_topic;
        this.planguage_name = planguage_name;
        this.userinfo = user_info;
        this.subjectinfo=subject_info;
    }

}
