package com.capstonesam.springcapstoneplzwebservice.domainForFunction;

import com.capstonesam.springcapstoneplzwebservice.domain.Login.User_info;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor
@Getter
@Entity
@Table(name = "studyclub_info")
public class StudyClub_info {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long studyclub_ID;

    @Column(nullable = false, length=45)
    private String studyclub_topic;

    @Column(nullable = false, length=45)
    private String planguage_name;

//    private String subject_name;
/*    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="subject_name")
    private Subject_info subjectinfo;
*/
    //fk
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="user_num")
    private User_info userinfo;

    @Builder
    public StudyClub_info(String studyclub_topic, String planguage_name, User_info user_info/*, Subject_info subject_info*/){
        this.studyclub_topic=studyclub_topic;
        this.planguage_name=planguage_name;
        this.userinfo=user_info;
//        this.subjectinfo = subject_info;
    }

}
