package com.capstonesam.springcapstoneplzwebservice.domainForFunction;


import com.capstonesam.springcapstoneplzwebservice.domain.Login.User_info;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@NoArgsConstructor(access= AccessLevel.PROTECTED)
@Getter
@Builder
@Entity
@Table(name="license_info")
public class License_info {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long license_ID ;

    @Column(nullable = false, length=45)
    private String license_name ;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name = "user_num")
    private User_info userinfo;

    @Builder//construct 생성자??
    public License_info(String license_name, User_info user_info) {
        //this.user_num=user_num;
        this.license_name=license_name;
        this.userinfo=user_info;
    }
    @Builder//construct 생성자??
    public License_info(Long license_ID, String license_name, User_info user_info) {
        //this.user_num=user_num;
        this.license_ID = license_ID;
        this.license_name=license_name;
        this.userinfo=user_info;
    }

}