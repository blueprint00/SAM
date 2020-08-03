package com.capstonesam.springcapstoneplzwebservice.Service;

import com.capstonesam.springcapstoneplzwebservice.DTO.CompetitionResponseDto;
import com.capstonesam.springcapstoneplzwebservice.DTO.ContestResponseDto;
import com.capstonesam.springcapstoneplzwebservice.DTO.SubjectResponsDto;
import com.capstonesam.springcapstoneplzwebservice.domainForFunction.Competition_info;
import com.capstonesam.springcapstoneplzwebservice.domainForFunction.Competition_info_Repository;
import com.capstonesam.springcapstoneplzwebservice.domainForFunction.Subject_info_Repository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class SubjectService {
    private Subject_info_Repository subject_info_repository;
    private Competition_info_Repository competition_info_repository;


    @Transactional(readOnly = true)
    public List<SubjectResponsDto> Subjectfind(Long usernum, String subject_option){
//System.out.println("출력: "+);
        return subject_info_repository.findmajor(usernum, subject_option)
                .map(SubjectResponsDto::new)
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public Map<String, Double> totalGradeInfo(Long user_num){

        double totalGrade=0, core=0, elective=0 ,ctest=0;

        int tCnt=0, cCnt=0, eCnt=0;

        List<SubjectResponsDto> subject_info;

        Map<String, Double> GradeMap = new HashMap<String, Double>();

        subject_info = subject_info_repository.findAll(user_num)
                .map(SubjectResponsDto::new)
                .collect(Collectors.toList());

        for(int i=0;i<subject_info.size();i++) {
            tCnt++;
            totalGrade += subject_info.get(i).getSubject_grade();
            if(subject_info.get(i).getSubject_option().equals("전필")){
                cCnt++;
                core+=subject_info.get(i).getSubject_grade();
            }
            if(subject_info.get(i).getSubject_option().equals("전선")){
                eCnt++;
                elective+=subject_info.get(i).getSubject_grade();
            }
        }

        totalGrade = totalGrade/tCnt;
        core = core/cCnt;
        elective = elective/eCnt;

        List<CompetitionResponseDto> competition_info;

        competition_info = competition_info_repository.findCompetitionWithCompetitionName(user_num, "C인증")
                .map(CompetitionResponseDto::new)
                .collect(Collectors.toList());

        for(int i =0;i<competition_info.size();i++){
            ctest+=competition_info.get(i).getCompetition_score();
        }

        GradeMap.put("totalGrade", totalGrade);
        GradeMap.put("core", core);
        GradeMap.put("elective", elective);
        GradeMap.put("ctest", ctest);

        return GradeMap;
    }
    @Transactional
    public Double subjectTotalGrade(Long usernum){
        List<SubjectResponsDto> subject_info;

        double totalGrade=0;
        int cnt=0;
        subject_info = subject_info_repository.findAll(usernum)
                .map(SubjectResponsDto::new)
                .collect(Collectors.toList());

        for(int i=0;i<subject_info.size();i++) {
            cnt++;
            totalGrade += subject_info.get(i).getSubject_grade();
        }
        totalGrade=totalGrade/cnt;
        return totalGrade;
    }
}
