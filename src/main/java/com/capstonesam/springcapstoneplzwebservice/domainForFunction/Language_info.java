package com.capstonesam.springcapstoneplzwebservice.domainForFunction;

import com.capstonesam.springcapstoneplzwebservice.domain.Login.User_info;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Date;

@NoArgsConstructor
@Getter
@Entity
@Table(name="language_info")
public class Language_info {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long language_ID;

    @Column(nullable = false, length=45)
    private String language_name;

    @Column(nullable = false, length=45)
    private String language_grade;

    @Column(nullable = false)
    private Date language_date;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name = "user_num")
    private User_info userinfo;

    @Builder//construct 생성자??
    public Language_info(String language_name, String language_grade, Date language_date, User_info user_info) {
        //this.user_num=user_num;
        this.language_name=language_name;
        this.language_grade=language_grade;
        this.language_date=language_date;
        this.userinfo = user_info;
    }

}
