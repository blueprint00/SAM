package com.capstonesam.springcapstoneplzwebservice.Service;

import com.capstonesam.springcapstoneplzwebservice.DTO.*;
import com.capstonesam.springcapstoneplzwebservice.domain.Login.User_info;
import com.capstonesam.springcapstoneplzwebservice.domainForFunction.Competition_info_Repository;
import com.capstonesam.springcapstoneplzwebservice.domainForFunction.Language_info_Repository;
import com.capstonesam.springcapstoneplzwebservice.domainForFunction.License_info_Repository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class CertificationPostService {
    private Competition_info_Repository competition_info_repository;
    private Language_info_Repository language_info_repository;
    private License_info_Repository license_info_repository;


    @Transactional
    public void save(CompetitionDto CDTO, LanguageDto LanDTO, LicenseDto LicDTO){
        competition_info_repository.save(CDTO.toEntity());
        language_info_repository.save(LanDTO.toEntity());
        license_info_repository.save(LicDTO.toEntity());

    }

    @Transactional
    public void saveLicense(String license_name, User_info user_info){
        LicenseDto lDTO =  LicenseDto.builder()
                .license_name(license_name)
                .user_info(user_info)
                .build();
        license_info_repository.save(lDTO.toEntity());
    }
    @Transactional
    public void saveLanguage(String language_name, String language_grade, Date language_date, User_info user_info){
        LanguageDto lDTO = LanguageDto.builder()
                .language_name(language_name)
                .language_grade(language_grade)
                .language_date(language_date)
                .user_info(user_info)
                .build();
        language_info_repository.save(lDTO.toEntity());

    }
    @Transactional
    public void saveCompetition(Integer competition_score, Date competition_date, User_info user_info){
        CompetitionDto cDTO = CompetitionDto.builder()
                .competition_name("topcit")
                .competition_score(competition_score)
                .competition_date(competition_date)
                .user_info(user_info)
                .build();

        competition_info_repository.save(cDTO.toEntity());
    }

    @Transactional(readOnly = true)
    public List<CompetitionResponseDto> CompetitionfindByUserInfo(Long user_num){


        return competition_info_repository.findCompetitionWithCompetitionName(user_num, "topcit")
                .map(CompetitionResponseDto::new)
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public List<LanguageResponseDto> LanguagefindByUserInfo(Long user_num){


        return language_info_repository.findLanguage(user_num)
                .map(LanguageResponseDto::new)
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public List<LicenseResponseDto> LicensefindByUserInfo(Long user_num){
        return license_info_repository.findLicense(user_num)
                .map(LicenseResponseDto::new)
                .collect(Collectors.toList());
    }
    @Transactional(readOnly = true)
    public Long certificationGrade(Long usernum){

        long certificationGrade;

        long competitionCnt = competition_info_repository.CountCompetition(usernum);
        long licenseCnt = license_info_repository.CountLicense(usernum);
        long languageCnt = language_info_repository.CountLanguage(usernum);



        certificationGrade = competitionCnt + licenseCnt + languageCnt;

        return certificationGrade;
    }




}
