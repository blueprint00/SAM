package com.capstonesam.springcapstoneplzwebservice.DTO;

import com.capstonesam.springcapstoneplzwebservice.domainForFunction.Subject_info;
import lombok.Getter;

@Getter
public class SubjectResponsDto {
    private Long subject_ID;
    private String subject_name;
    private double subject_credit;
    private double subject_grade;
    private String subject_option;


    public SubjectResponsDto(Subject_info entity){
        subject_ID=entity.getSubject_ID();
        subject_name=entity.getSubject_name();
        subject_credit=entity.getSubject_credit();
        subject_grade=entity.getSubject_grade();
        subject_option=entity.getSubject_option();
    }
}
