package com.capstonesam.springcapstoneplzwebservice.domain.login;

import com.capstonesam.springcapstoneplzwebservice.domain.Login.User_info;
import com.capstonesam.springcapstoneplzwebservice.domain.Login.User_info_Repository;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;


@RunWith(SpringRunner.class)
@SpringBootTest
public class User_info_RepositoryTest {

    @Autowired
    User_info_Repository user_info_repository;

    @After
    public void cleanup(){
        user_info_repository.deleteAll();
    }

    @Test
    public void Login_test(){
        user_info_repository.save(User_info.builder()
                .user_name("학생테스트")
                .user_pw("1234")
                .user_admyear("12")
                .user_major("컴퓨터공학")
                .user_type("학생")
                .build());

        List<User_info> userList = user_info_repository.findAll();

        User_info user_info = userList.get(0);

        assertThat(user_info.getUser_name(), is("학생테스트"));
        assertThat(user_info.getUser_pw(), is("1234"));

    }




}
