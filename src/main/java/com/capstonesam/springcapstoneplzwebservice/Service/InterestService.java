package com.capstonesam.springcapstoneplzwebservice.Service;

import com.capstonesam.springcapstoneplzwebservice.DTO.*;
import com.capstonesam.springcapstoneplzwebservice.domain.Login.User_info;
import com.capstonesam.springcapstoneplzwebservice.domainForFunction.Interest_area_info_Repository;
import com.capstonesam.springcapstoneplzwebservice.domainForFunction.Interest_job_info_Repository;
import com.capstonesam.springcapstoneplzwebservice.domainForFunction.Interest_planguage_info_Repository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class InterestService {
    private Interest_area_info_Repository interest_area_info_repository;
    private Interest_job_info_Repository interest_job_info_repository;
    private Interest_planguage_info_Repository interest_planguage_info_repository;

    @Transactional
    public void saveInterestArea(String interestArea1, String interestArea2, String interestArea3, User_info userInfo){
        InterestAreaDto aDto;

        aDto = InterestAreaDto.builder()
                .interest_area_1(interestArea1)
                .interest_area_2(interestArea2)
                .interest_area_3(interestArea3)
                .user_info(userInfo)
                .build();

        interest_area_info_repository.save(aDto.toEntity());
    }

    @Transactional
    public void saveInterestJob(String interestJob1, String interestJob2, String interestJob3, User_info userInfo){
        InterestJobDto jDto;

        jDto = InterestJobDto.builder()
                .interest_job_1(interestJob1)
                .interest_job_2(interestJob2)
                .interest_job_3(interestJob3)
                .user_info(userInfo)
                .build();

        interest_job_info_repository.save(jDto.toEntity());
    }

    @Transactional
    public void saveInterestPlang(String interestPlang1, String interestPlang2, String interestPlang3, User_info userInfo){
        InterestPlanguageDto pDto;

        pDto = InterestPlanguageDto.builder()
                .interest_planguage_1(interestPlang1)
                .interest_planguage_2(interestPlang2)
                .interest_planguage_3(interestPlang3)
                .user_info(userInfo)
                .build();

        interest_planguage_info_repository.save(pDto.toEntity());
    }

    @Transactional(readOnly = true)
    public List<InterestAreaResponseDto> InterestAreafinByUserInfo(Long user_num){

        return interest_area_info_repository.findInteretArea(user_num)
                .map(InterestAreaResponseDto::new)
                .collect(Collectors.toList());

    }
    @Transactional(readOnly = true)
    public List<InterestJobResponseDto> InterestJobfinByUserInfo(Long user_num){

        return interest_job_info_repository.findInteretJob(user_num)
                .map(InterestJobResponseDto::new)
                .collect(Collectors.toList());

    }
    @Transactional(readOnly = true)
    public List<InterestPlanguageResponseDto> InterestPlanguagefinByUserInfo(Long user_num){

        return interest_planguage_info_repository.findInteretPlang(user_num)
                .map(InterestPlanguageResponseDto::new)
                .collect(Collectors.toList());

    }
}
