package com.capstonesam.springcapstoneplzwebservice.Service;

import com.capstonesam.springcapstoneplzwebservice.DTO.PlanguageDto;
import com.capstonesam.springcapstoneplzwebservice.DTO.PlanguageResponseDto;
import com.capstonesam.springcapstoneplzwebservice.DTO.checkDto;
import com.capstonesam.springcapstoneplzwebservice.domain.Login.User_info;
import com.capstonesam.springcapstoneplzwebservice.domainForFunction.Planguage_info;
import com.capstonesam.springcapstoneplzwebservice.domainForFunction.Planguage_info_Repository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class PlanguageService {

    private Planguage_info_Repository planguage_info_repository;

    @Transactional
    public void saveTestResult(String planguage_name, String user_A1, String user_A2, String user_A3, User_info userinfo){
        PlanguageDto pDto;


        Integer sum = 0; //왜 밖에 적으면 안되지????????????????
    if(planguage_name.equals("C")){
        if(user_A1.equals("number <=")) sum += 1;
        if(user_A2.equals("*")) sum += 3;
        if(user_A3.equals("b, c, a")) sum += 5;
    }

        if(planguage_name.equals("Cpp")){
            if(user_A1.equals("캡슐화")) sum += 1;
            if(user_A2.equals("Stack")) sum += 3;
            if(user_A3.equals("num / digit % 10 == 0")) sum += 5;
        }

        if(planguage_name.equals("Java")){
            if(user_A1.equals("캡슐화")) sum += 1;
            if(user_A2.equals("++i")) sum += 3;
            if(user_A3.equals("current /= 10")) sum += 5;
        }

        if(planguage_name.equals("Python")){
            if(user_A1.equals("len")) sum += 1;
            if(user_A2.equals("from, import")) sum += 3;
            if(user_A3.equals("urllib.request")) sum += 5;
        }


        if(sum < 4) {
            pDto = PlanguageDto.builder()
                    .planguage_name(planguage_name)
                    .planguage_level("하")
                    .user_info(userinfo)
                    .build();
        }
        else if(sum < 8) {

            pDto = PlanguageDto.builder()
                    .planguage_name(planguage_name)
                    .planguage_level("중")
                    .user_info(userinfo)
                    .build();
        }
        else {
            pDto = PlanguageDto.builder()
                    .planguage_name(planguage_name)
                    .planguage_level("상")
                    .user_info(userinfo)
                    .build();
        }

        planguage_info_repository.save(pDto.toEntity());
    }

    @Transactional
    public void saveTestResultEtc(String planguage_name, String planguage_level, User_info userinfo){

       PlanguageDto pDto;

        pDto = PlanguageDto.builder()
                .planguage_name(planguage_name)
                .planguage_level(planguage_level)
                .user_info(userinfo)
                .build();

        planguage_info_repository.save(pDto.toEntity());
    }

    @Transactional
    public List<PlanguageResponseDto> PlanguagefindByUserInfo(Long usernum){
        return planguage_info_repository.findPlanguage(usernum)
                .map(PlanguageResponseDto::new)
                .collect(Collectors.toList());
    }

    @Transactional
    public List<Map<String, Object>> PlanguageGraph(Long usernum){
        long low, mid, high;
        String planguage_name;
        List<String> planguageNameList=new ArrayList<>();
        List<Planguage_info> p_info = new ArrayList<>();
        p_info=planguage_info_repository.findPlanguage(usernum).collect(Collectors.toList());

        List <Map<String , Object>> Graph = new ArrayList<>();

        Map<String, Object> PlanguageGraph = new HashMap<>();

        for(int i= 0 ; i<p_info.size();i++) {
            low = planguage_info_repository.CountPlanguageWithPlanguageLevel(p_info.get(i).getPlanguage_name(), "하");
            mid = planguage_info_repository.CountPlanguageWithPlanguageLevel(p_info.get(i).getPlanguage_name(), "중");
            high = planguage_info_repository.CountPlanguageWithPlanguageLevel(p_info.get(i).getPlanguage_name(), "상");

            PlanguageGraph.put("planguageName", p_info.get(i).getPlanguage_name());
            PlanguageGraph.put("low", low);
            PlanguageGraph.put("mid", mid);
            PlanguageGraph.put("high", high);

            Graph.add(i, PlanguageGraph);
        }
        return Graph;
    }

    @Transactional
    public Long PlanguageGrade(Long usernum){
        long low, mid, high, totalgrade;

        low = planguage_info_repository.CountPlanguageLevel("하");
        mid = planguage_info_repository.CountPlanguageLevel("중");
        high = planguage_info_repository.CountPlanguageLevel("상");

        totalgrade= low + mid * 3 + high * 5;

        return totalgrade;
    }

}
