package com.capstonesam.springcapstoneplzwebservice.DTO;

import com.capstonesam.springcapstoneplzwebservice.domain.Login.User_info;
import com.capstonesam.springcapstoneplzwebservice.domainForFunction.Intern_info;
import lombok.Getter;

@Getter
public class InternResponseDto {
    private String intern_companyname;
    private String intern_companyinfo;
    private String intern_period;
    private String intern_job;
    private String intern_area;
    private User_info user_info;

    public InternResponseDto(Intern_info entity){
        intern_companyname = entity.getIntern_companyname();
        intern_companyinfo = entity.getIntern_companyinfo();
        intern_period = entity.getIntern_period();
        intern_job = entity.getIntern_job();
        intern_area=entity.getIntern_area();
        user_info=entity.getUserinfo();
    }
}
