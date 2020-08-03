package com.capstonesam.springcapstoneplzwebservice.Service;

import com.capstonesam.springcapstoneplzwebservice.DTO.InternDto;
import com.capstonesam.springcapstoneplzwebservice.DTO.InternResponseDto;
import com.capstonesam.springcapstoneplzwebservice.domain.Login.User_info;
import com.capstonesam.springcapstoneplzwebservice.domainForFunction.Intern_info_Repository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class InternService {
    private Intern_info_Repository intern_info_repository;

    public void saveIntern(String intern_companyName, String intern_companyInfo, String intern_period, String intern_job, String intern_area, User_info userInfo){
        InternDto iDto; //어째서 밖에 적으면 안될까...

        iDto = InternDto.builder()
                .intern_companyName(intern_companyName)
                .intern_companyInfo(intern_companyInfo)
                .intern_period(intern_period)
                .intern_job(intern_job)
                .intern_area(intern_area)
                .user_info(userInfo)
                .build();

        intern_info_repository.save(iDto.toEntity());
    }

    @Transactional(readOnly = true)
    public List<InternResponseDto> InternfindByUserInfo(Long usernum){

        return intern_info_repository.findIntern(usernum)
                .map(InternResponseDto::new)
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public Long InternGrade(Long usernum){
        return intern_info_repository.CountIntern(usernum);
    }


}
