package com.capstonesam.springcapstoneplzwebservice.DTO;

import com.capstonesam.springcapstoneplzwebservice.domain.Login.User_info;
import com.capstonesam.springcapstoneplzwebservice.domainForFunction.License_info;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class LicenseDto {
    private String license_name;
    private User_info user_info;

    @Builder
    public LicenseDto(String license_name, User_info user_info){
        this.license_name=license_name;
        this.user_info=user_info;
    }


    public License_info toEntity(){
        return License_info.builder()
                .license_name(license_name)
                .userinfo(user_info)
                .build();
    }
}
