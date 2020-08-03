package com.capstonesam.springcapstoneplzwebservice.Service;

import com.capstonesam.springcapstoneplzwebservice.DTO.*;
import com.capstonesam.springcapstoneplzwebservice.domain.Login.User_info;
import com.capstonesam.springcapstoneplzwebservice.domainForFunction.*;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class FootPrintService {
    private Interest_area_info_Repository interest_area_info_repository;
    private Interest_job_info_Repository interest_job_info_repository;
    private Interest_planguage_info_Repository interest_planguage_info_repository;
    private Planguage_info_Repository planguage_info_repository;
    private Intern_info_Repository intern_info_repository;
    private  Contest_info_Repository contest_info_repository;

    @Transactional(readOnly = true)
    public List<FootPrintDto> FootPrintfindByUserInfo(User_info user_info){
        String interest_job = interest_job_info_repository.findMostInteretJob(user_info.getUser_num());
        String interest_area = interest_area_info_repository.findMostInteretArea(user_info.getUser_num());
        Long user_num;
        int areaPer=0, jobPer=0, plangPer=0, totalPer=0;
        List<String> planguage = new ArrayList<>();
        List<Long> areaMatch;
        List<Long> areaMatch2;
        List<Long> areaMatch3;
        List<Long> jobMatch1;
        List<Long> jobMatch2 = new ArrayList<>();
        List<Long> jobMatch3 = new ArrayList<>();
        List<Long> plangMatch = new ArrayList<>();

        List<List> plangMatchList = new ArrayList<>();

        List<Long> Match = new ArrayList<>();

        int cnt=0;

        List<FootPrintDto> footprintList=new ArrayList<>();

        FootPrintDto footprint=new FootPrintDto();

        List<PlanguageResponseDto> planguageInfo= planguage_info_repository.findPlanguage(user_info.getUser_num()).map(PlanguageResponseDto::new).collect(Collectors.toList());

        List<String> existUserNum=new ArrayList<>();

        for(int i=0;i<planguageInfo.size();i++) {
            planguage.add(i, planguageInfo.get(i).getPlanguage_name());
        }
//        List <String> plang =new ArrayList<>();

        areaMatch=interest_area_info_repository.findUser1(interest_area).collect(Collectors.toList());

        for(int i = 0; i<planguage.size();i++){
            plangMatch = planguage_info_repository.findUser(planguage.get(i)).collect(Collectors.toList());
            plangMatchList.add(i, plangMatch);
        }

        List<String> plList= new ArrayList<>();

        while(cnt<2) {
            for (int i = 0; i < areaMatch.size(); i++) {
                for (int t = 0; t < planguage.size(); t++) {
                    for (int j = 0; j < plangMatchList.size(); j++) {
                        if (areaMatch.get(i).equals(plangMatchList.get(t).get(j))) {
                            if (existUserNum.equals(areaMatch)) {
                            } else {
                                List<Planguage_info> pl = planguage_info_repository.findPlanguage((Long) plangMatchList.get(t).get(j)).collect(Collectors.toList());
                                for (int a = 0; a < pl.size(); a++) {
                                    plList.add(a, pl.get(a).getPlanguage_name());
                                }
                                footprint.setPlanguage(plList);
                                footprint.setInterest_area(interest_area);
                                footprint.setInterest_job(interest_job_info_repository.findInteretJob(plangMatch.get(j)).map(Interest_job_info::getInterest_job_1).collect(Collectors.joining()));
                                footprint.setIntern(intern_info_repository.findIntern(plangMatch.get(j)).map(InternResponseDto::new).collect(Collectors.toList()));
                                footprint.setContest(contest_info_repository.findContest(plangMatch.get(j)).map(ContestResponseDto::new).collect(Collectors.toList()));
                                footprintList.add(cnt, footprint);
                                cnt++;
                            }
                        }
                    }
                }
            }
        }

        return footprintList;
   }

}
