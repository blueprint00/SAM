package com.capstonesam.springcapstoneplzwebservice.domainForFunction;

import com.capstonesam.springcapstoneplzwebservice.domain.Login.User_info;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.context.annotation.Configuration;

import javax.persistence.*;

@NoArgsConstructor
@Getter
@Entity
@Configuration
public class Planguage_info {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long planguage_ID;

    @Column(nullable = false, length = 45)
    private String planguage_name;

    @Column(nullable = false, length = 45)
    private String planguage_level;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_num")
    User_info userinfo;

    @Builder
    public Planguage_info(String planguage_name, String planguage_level, User_info user_info){
        this.planguage_name = planguage_name;
        this.planguage_level= planguage_level;
        this.userinfo = user_info;

    }

}
