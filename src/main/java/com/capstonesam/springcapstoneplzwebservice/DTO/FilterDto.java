package com.capstonesam.springcapstoneplzwebservice.DTO;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class FilterDto {
    private String  user_admyear;
    private String  user_major;
    private Long user_num;
    private String user_name;
    private String subject_name;
    private String subject_option;
    private double subject_grade;
    private String planguage_name;
    private Long contestnum;
    private Long studyclubnum;
    private Long projectnum;
    private Long internnum;
    private Long educationnum;
    private Long topcit;
    private Long toeic;

    @Builder
    public FilterDto(String  user_admyear,String  user_major, Long user_num, String user_name, String subject_name, String subject_option, double subject_grade, String planguage_name, Long contestnum, Long studyclubnum, Long projectnum, Long internnum, Long educationnum, Long topcit, Long toeic){
        this.user_admyear =user_admyear;
        this.user_major = user_major;
        this.user_num = user_num;
        this.user_name = user_name;
        this.subject_name = subject_name;
        this.subject_option= subject_option;
        this.subject_grade=subject_grade;
        this.planguage_name=planguage_name;
        this.contestnum=contestnum;
        this.studyclubnum=studyclubnum;
        this.projectnum= projectnum;
        this.internnum=internnum;
        this.educationnum= educationnum;
        this.topcit= topcit;
        this.toeic= toeic;
    }
}
