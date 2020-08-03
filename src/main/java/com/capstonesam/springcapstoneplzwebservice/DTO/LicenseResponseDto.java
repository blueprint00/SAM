package com.capstonesam.springcapstoneplzwebservice.DTO;

import com.capstonesam.springcapstoneplzwebservice.domain.Login.User_info;
import com.capstonesam.springcapstoneplzwebservice.domainForFunction.Language_info;
import com.capstonesam.springcapstoneplzwebservice.domainForFunction.License_info;
import lombok.Getter;

@Getter
public class LicenseResponseDto {
    private String license_name;
    private User_info user_info;

    public LicenseResponseDto(License_info entity) {
        license_name=entity.getLicense_name();
        user_info=entity.getUserinfo();
    }
}
