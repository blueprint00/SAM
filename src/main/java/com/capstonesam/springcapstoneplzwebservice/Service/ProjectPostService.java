package com.capstonesam.springcapstoneplzwebservice.Service;


import com.capstonesam.springcapstoneplzwebservice.DTO.*;
import com.capstonesam.springcapstoneplzwebservice.domain.Login.User_info;
import com.capstonesam.springcapstoneplzwebservice.domainForFunction.Contest_info_Repository;
import com.capstonesam.springcapstoneplzwebservice.domainForFunction.Hackathon_info_Repository;
import com.capstonesam.springcapstoneplzwebservice.domainForFunction.Project_info_Repository;
import com.capstonesam.springcapstoneplzwebservice.domainForFunction.StudyClub_info_Repository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class ProjectPostService {
    private Contest_info_Repository contest_info_repository;
    private Hackathon_info_Repository hackathon_info_repository;
    private Project_info_Repository project_info_repository;
    private StudyClub_info_Repository studyClub_info_repository;


    @Transactional
    public void saveContest(String contest_topic, String contest_record, String planguage_name, User_info user_info){
        ContestDto cDTO = ContestDto.builder()
                .contest_topic(contest_topic)
                .contest_record(contest_record)
                .planguage_name(planguage_name)
                .user_info(user_info)
                .build();

        contest_info_repository.save(cDTO.toEntity());
    }

    @Transactional
    public void saveHackathon(String hack_topic, String hack_record, User_info user_info) {
        HackathonDto hDTO = HackathonDto.builder()
                .hack_topic(hack_topic)
                .hack_record(hack_record)
//                .hack_doc_ID(hack_doc_ID)
                .user_info(user_info)
                .build();

        hackathon_info_repository.save(hDTO.toEntity());
    }

    @Transactional
    public void saveProject(String planguage_name, String project_topic, User_info user_info){
        ProjectDto pDTO = ProjectDto.builder()
                .planguage_name(planguage_name)
                .project_topic(project_topic)
                .user_info(user_info)
                .build();

        project_info_repository.save(pDTO.toEntity());
    }

    @Transactional
    public void saveStudyClub(String planguage_name, String studyclub_topic/*, Subject_info subject_info*/, User_info user_info){
        StudyClubDto sDTO=StudyClubDto.builder()
                .planguage_name(planguage_name)
                .studyclub_topic(studyclub_topic)
//                .subject_info(subject_info)
                .user_info(user_info)
                .build();

        studyClub_info_repository.save(sDTO.toEntity());
    }

    @Transactional(readOnly = true)
    public List<ContestResponseDto> ContestfindByUserInfo(Long user_num){


        return contest_info_repository.findContest(user_num)
                .map(ContestResponseDto::new)
                .collect(Collectors.toList());
   }

    @Transactional(readOnly = true)
    public List<HackathonResponseDto> HackfindByUserInfo(Long user_num){
        return hackathon_info_repository.findHackathon(user_num)
                .map(HackathonResponseDto::new)
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public List<ProjectResponseDto> ProjectfindByUserInfo(Long user_num){
        return project_info_repository.findProject(user_num)
                .map(ProjectResponseDto::new)
                .collect(Collectors.toList());
    }
    @Transactional(readOnly = true)
    public List<StudyClubResponseDto> StudyClubfindByUserInfo(Long user_num){
        return studyClub_info_repository.findStudyClub(user_num)
                .map(StudyClubResponseDto::new)
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public Long projectGrade(Long usernum){


        long projectCnt = project_info_repository.CountProject(usernum);
        long contestCnt = contest_info_repository.CountContest(usernum);
        long hackCnt = hackathon_info_repository.CountHackathon(usernum);
        long studyclubCnt = studyClub_info_repository.CountStudyclub(usernum);

        long additional = contest_info_repository.CountContestwithRecord(usernum) + hackathon_info_repository.CountHackathonwithRecord(usernum);

        long certificationGrade = projectCnt + contestCnt*3 + hackCnt*3 + studyclubCnt + additional*2;

        return certificationGrade;
    }

}
