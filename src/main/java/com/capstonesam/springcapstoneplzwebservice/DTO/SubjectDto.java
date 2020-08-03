package com.capstonesam.springcapstoneplzwebservice.DTO;

import com.capstonesam.springcapstoneplzwebservice.domainForFunction.Subject_info;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class SubjectDto {

    private String subject_name;
    private double subject_credit;
    private double subject_grade;
    private String subject_option;


    public Subject_info toEntity(){
        return Subject_info.builder()
                .subject_name(subject_name)
                .subject_credit(subject_credit)
                .subject_grade(subject_grade)
                .subject_option(subject_option)
                .build();
    }

}
