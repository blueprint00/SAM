package com.capstonesam.springcapstoneplzwebservice.DTO;

import com.capstonesam.springcapstoneplzwebservice.domain.Login.User_info;
import com.capstonesam.springcapstoneplzwebservice.domainForFunction.Intern_info;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class InternDto {
    private Long intern_ID;
    private String intern_companyName;
    private String intern_companyInfo;
    private String intern_period;
    private String intern_job;
    private String intern_area;
    private User_info user_info;

    @Builder
    public InternDto(Long intern_ID, String intern_companyName, String intern_companyInfo, String intern_period, String intern_job, String intern_area, User_info user_info){
        this.intern_ID = intern_ID;
        this.intern_companyName = intern_companyName;
        this.intern_companyInfo = intern_companyInfo;
        this.intern_period = intern_period;
        this.intern_job = intern_job;
        this.intern_area = intern_area;
        this.user_info = user_info;
    }

    public Intern_info toEntity(){
        return Intern_info.builder()
                .intern_companyName(intern_companyName)
                .intern_companyInfo(intern_companyInfo)
                .intern_period(intern_period)
                .intern_job(intern_job)
                .intern_area(intern_area)
                .user_info(user_info)
                .build();
    }
}
