package com.capstonesam.springcapstoneplzwebservice.Service;

import com.capstonesam.springcapstoneplzwebservice.domainForFunction.Subject_info_Repository;
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
public class GraphService {
    private Subject_info_Repository subject_info_repository;
    @Transactional(readOnly = true)
    public Map<String, Object> showGraph(String x, String y, String style){
        List<Object> yList = new ArrayList<>();

        Map<String, Object> resultMap = new HashMap<>();

        if(x.equals("user_admyear")) {
            yList = subject_info_repository.findGraph1().collect(Collectors.toList());
        }

        resultMap.put("yList", yList);
        resultMap.put("style", style);

        return resultMap;
    }
}
