package com.capstonesam.springcapstoneplzwebservice.web;

import com.capstonesam.springcapstoneplzwebservice.DTO.checkDto;
import com.capstonesam.springcapstoneplzwebservice.domain.Login.User_info_Repository;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
@AllArgsConstructor
public class WebRestController {

    private User_info_Repository user_info_repository;

    @GetMapping("/hello")
    public String hello(){
        return "제발되어주라";
    }

    @PostMapping("/input") //이 매핑은 회원가입 같은 정보를 넣을 때만 실행 시켜야 한다!
    public void saveSomething(@RequestBody checkDto dto){
        user_info_repository.save(dto.toEntity());
    }



}
