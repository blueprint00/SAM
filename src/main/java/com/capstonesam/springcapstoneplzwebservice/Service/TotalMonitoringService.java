package com.capstonesam.springcapstoneplzwebservice.Service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.Map;

@AllArgsConstructor
@Service
public class TotalMonitoringService {
    private PlanguageService planguageService;
    private InternService internService;
    private SubjectService subjectService;
    private EducationService educationService;
    private CertificationPostService certificationPostService;
    private ProjectPostService projectPostService;

    @Transactional(readOnly = true)
    public Map<String, Object> totalMonitoring(Long usernum){

        Map<String, Object> totalMonitoring = new HashMap<>();

        //주력언어 점수
        totalMonitoring.put("plangGrade",planguageService.PlanguageGrade(usernum));
        //자격증 점수
        totalMonitoring.put("certGrade",certificationPostService.certificationGrade(usernum));
        //교육 점수
        totalMonitoring.put("eduGrade",educationService.EducationGrade(usernum));
        //프로젝트 점수
        totalMonitoring.put("projGrade",projectPostService.projectGrade(usernum));
        //인턴 점수
        totalMonitoring.put("internGrade",internService.InternGrade(usernum));
        //성적 점수
        totalMonitoring.put("subjectGrade",subjectService.subjectTotalGrade(usernum));

        return totalMonitoring;
    }
}
