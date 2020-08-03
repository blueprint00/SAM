package com.capstonesam.springcapstoneplzwebservice.domainForFunction;

import com.capstonesam.springcapstoneplzwebservice.domain.Login.User_info;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Controller;

import javax.persistence.*;

@NoArgsConstructor
@Getter
@Entity
@Table(name="subject_info")
public class Subject_info {

    @Id
    @GeneratedValue
    private Long subject_ID;

    @Column(nullable = false, length = 45)
    private String subject_name;

    @Column(nullable = false)
    private double subject_credit;

    @Column(nullable = false)
    private double subject_grade;

    @Column(nullable = false, length = 15)
    private String subject_option;


    //외래키 선언하기
    @ManyToOne(fetch = FetchType.LAZY)
   @JoinColumn(name= "user_num")
    private User_info userinfo;

    @Builder
    public Subject_info(String subject_name, double subject_credit, double subject_grade, String subject_option, User_info user_info) {
        this.subject_name= subject_name;
        this.subject_credit = subject_credit;
        this.subject_grade =subject_grade;
        this.subject_option = subject_option;
        this.userinfo=user_info;
    }


}
