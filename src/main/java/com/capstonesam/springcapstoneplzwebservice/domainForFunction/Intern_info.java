package com.capstonesam.springcapstoneplzwebservice.domainForFunction;

import com.capstonesam.springcapstoneplzwebservice.domain.Login.User_info;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor
@Getter
@Entity
@Table(name = "intern_info")
public class Intern_info {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long intern_ID;

    @Column(nullable = false, length=45)
    private String intern_companyname;

    @Column(nullable = false, length = 45)
    private String intern_companyinfo;

    @Column(nullable = false, length = 45)
    private String intern_period;

    @Column(nullable = false, length = 45)
    private String intern_job;

    @Column(nullable = false, length = 45)
    private String intern_area;

    @ManyToOne
    @JoinColumn(name = "user_num")
    private User_info userinfo;

    @Builder
    public Intern_info(Long intern_id, String intern_companyName, String intern_companyInfo, String intern_period, String intern_job, String intern_area, User_info user_info){
        this.intern_ID = intern_ID;
        this.intern_companyname = intern_companyName;
        this.intern_companyinfo = intern_companyInfo;
        this.intern_period = intern_period;
        this.intern_job = intern_job;
        this.intern_area = intern_area;
        this.userinfo = user_info;
    }

}
