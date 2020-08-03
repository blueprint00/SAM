package com.capstonesam.springcapstoneplzwebservice.DTO;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class FootPrintDto {
    private String interest_job;
    private String interest_area;
    private List<String> planguage = new ArrayList<>();
    private List<InternResponseDto> intern= new ArrayList<>();
    private List<ContestResponseDto> contest= new ArrayList<>();
    private int totalPer;

    @Builder
    public FootPrintDto(String interest_job, String interest_area, List<String> planguage, List<InternResponseDto> intern, List<ContestResponseDto> contest, int totalPer){

        this.interest_job = interest_job;
        this.interest_area = interest_area;
        this.planguage = planguage;
        this.intern = intern;
        this.contest = contest;
        this.totalPer = totalPer;
    }
}
