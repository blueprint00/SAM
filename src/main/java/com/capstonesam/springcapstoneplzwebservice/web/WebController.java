package com.capstonesam.springcapstoneplzwebservice.web;

import com.capstonesam.springcapstoneplzwebservice.DTO.FilterDto;
import com.capstonesam.springcapstoneplzwebservice.DTO.FilterResponseDto;
import com.capstonesam.springcapstoneplzwebservice.DTO.InternResponseDto;
import com.capstonesam.springcapstoneplzwebservice.Service.*;
import com.capstonesam.springcapstoneplzwebservice.domain.Login.User_info;
import com.capstonesam.springcapstoneplzwebservice.domain.Login.User_info_Repository;
import com.capstonesam.springcapstoneplzwebservice.domainForFunction.Subject_info_Repository;
import lombok.AllArgsConstructor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.sql.Date;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;


@Controller
@AllArgsConstructor
public class WebController {

    private User_info_Repository user_info_repository;
    private Subject_info_Repository subject_info_repository;
    private SubjectService subjectService;
    private ProjectPostService projectPostService;
    private CertificationPostService certificationPostService;
    private InternService internService;
    private EducationService educationService;
    private TotalMonitoringService totalMonitoringService;
    private FilterService filterService;
    private PlanguageService planguageService;
    private InterestService interestService;
    private FootPrintService footPrintService;
    private GraphService graphService;
    HttpSession session;
    HttpSession userInfoSession;
    //첫화면 로그인
    @GetMapping("/")
    public String login(){
        return "index";
    }

    @GetMapping("/newsam")
    public String stdMain(){
        return "newsam";
    }

    @GetMapping("/newmanager")
    public String magMain(){
        return "newmanager";
    }

    @GetMapping("/login")
    public String callLogin(){ return "login"; }

    @PostMapping("/login")
    public String doLogin(String user_num, String user_pw, String user_type,  HttpServletRequest request){


        Long l =Long.parseLong(user_num);

        if(user_num.equals("") || user_pw.equals("")||user_type.equals("")){
            return "login";
        }
        User_info user_info = user_info_repository.findOne(l);


        if(user_info.getUser_name().equals("")){return "login";}


        if(user_info.getUser_pw().equals(user_pw) && user_info.getUser_type().equals(user_type)){


            if(user_type.equals("학생")){

                userInfoSession=request.getSession(true);
                userInfoSession.setAttribute("loginUserInfo",user_info);

                session = request.getSession(true);
                session.setAttribute("loginUserNum",user_num);

                return "redirect:/newsam";
            }
            else if(user_type.equals("관리자")){

                session = request.getSession(true);
                session.setAttribute("loginUser", user_info);

                return "redirect:/newmanager";
            }
        }

    return "login";
    }

    @GetMapping("/logout")
    public String logOut(HttpSession session){
        session.removeAttribute("loginUserNum");
        return "login";
    }

 //사용자 메인 페이징
    @GetMapping("/main_1_first")
    public String callPage1(Model model){

        Object UserNum = session.getAttribute("loginUserNum");

        String temp = (String) UserNum;
        Long curUserNum = Long.parseLong(temp);

        model.addAttribute("totalMonitoring", totalMonitoringService.totalMonitoring(curUserNum));

        return "main_1_first";
    }

    @GetMapping("/main_2_language")
    public String callPage2(Model model){

        Object UserNum = session.getAttribute("loginUserNum");

        String temp = (String) UserNum;
        Long curUserNum = Long.parseLong(temp);

        model.addAttribute("Language", planguageService.PlanguagefindByUserInfo(curUserNum));
        model.addAttribute("Graph", planguageService.PlanguageGraph(curUserNum));

        return "main_2_language";
    }

    @GetMapping("/main_3_project")
    public String callPage3(Model model){
        Object UserNum = session.getAttribute("loginUserNum");

        String temp = (String) UserNum;
        Long curUserNum = Long.parseLong(temp);

        model.addAttribute("contest", projectPostService.ContestfindByUserInfo(curUserNum));
        model.addAttribute("hackathon", projectPostService.HackfindByUserInfo(curUserNum));
        model.addAttribute("project", projectPostService.ProjectfindByUserInfo(curUserNum));
        model.addAttribute("studyclub", projectPostService.StudyClubfindByUserInfo(curUserNum));

        return "main_3_project";
    }

    @PostMapping("/main_3_project")
    public void saveProjectInfo(String proj_genre, String proj_language, String proj_topic, String proj_record, String proj_doc){

        Object UserInfo = userInfoSession.getAttribute("loginUserInfo");
        User_info curUserInfo=(User_info) UserInfo;

        if(proj_genre.equals("contest")){
            projectPostService.saveContest(proj_topic, proj_record, proj_language, curUserInfo);
        }
        if(proj_genre.equals("hackathon")){
            projectPostService.saveHackathon(proj_topic, proj_record, curUserInfo);
        }
        if (proj_genre.equals("project")){
            projectPostService.saveProject(proj_language, proj_topic, curUserInfo);
        }
        if (proj_genre.equals("studyclub")){
            projectPostService.saveStudyClub(proj_language, proj_topic,curUserInfo);
        }
    }

    @GetMapping("/main_4_intern")
    public String callPage4(Model model){
        Object UserNum = session.getAttribute("loginUserNum");

        String temp = (String) UserNum;
        Long curUserNum = Long.parseLong(temp);

        model.addAttribute("intern", internService.InternfindByUserInfo(curUserNum));
        List<InternResponseDto> list = internService.InternfindByUserInfo(curUserNum);
        System.out.println(list.get(0));
        return "main_4_intern";
    }

    @PostMapping("/main_4_intern")
    public String saveInternInfo(String intern_companyname, String intern_companyinfo, String intern_period, String intern_job, String intern_area){

        Object UserInfo = userInfoSession.getAttribute("loginUserInfo");
        User_info curUserInfo=(User_info) UserInfo;

        internService.saveIntern(intern_companyname,intern_companyinfo, intern_period, intern_job, intern_area, curUserInfo);

        return "main_4_intern";
    }

    @GetMapping("/main_5_edu")
    public String callPage5(Model model){
        Object UserNum = session.getAttribute("loginUserNum");

        String temp = (String) UserNum;
        Long curUserNum = Long.parseLong(temp);

        model.addAttribute("education", educationService.EducationfindByUserinfo(curUserNum));

        return "main_5_edu";
    }

    @PostMapping("/main_5_edu")
    public void saveEducationInfo(String education_name, String education_period, String education_content){

        Object UserInfo = userInfoSession.getAttribute("loginUserInfo");
        User_info curUserInfo=(User_info) UserInfo;

        educationService.saveEducation(education_name, education_period,  education_content, curUserInfo);

        //return "main_5_edu";
    }


    @GetMapping("/main_6_cert")
    public String callPage6(Model model){
        Object UserNum = session.getAttribute("loginUserNum");

        String temp = (String) UserNum;
        Long curUserNum = Long.parseLong(temp);


        model.addAttribute("competition", certificationPostService.CompetitionfindByUserInfo(curUserNum));
        model.addAttribute("language", certificationPostService.LanguagefindByUserInfo(curUserNum));
        model.addAttribute("license", certificationPostService.LicensefindByUserInfo(curUserNum));


        return "main_6_cert";
    }

    @PostMapping("/main_6_cert/License")
    public String saveLicenseInfo(String license_name, HttpServletRequest request){

        Object UserInfo = userInfoSession.getAttribute("loginUserInfo");
        User_info curUserInfo=(User_info) UserInfo;

        System.out.println("usernum : "+curUserInfo.getUser_num());

        certificationPostService.saveLicense(license_name, curUserInfo);

         return "grade_ceritificate";
    }

    @PostMapping("/main_6_cert/Competition")
    public String saveCompetitionInfo(Integer competition_score, Date competition_date, HttpServletRequest request){

        Object UserInfo = userInfoSession.getAttribute("loginUserInfo");
        User_info curUserInfo=(User_info) UserInfo;

        certificationPostService.saveCompetition(competition_score, competition_date, curUserInfo);

        return "grade_topcitc";
    }

    @PostMapping("/main_6_cert/Language")
    public String saveLanguageInfo(String language_name, String language_grade, Date language_date){

        Object UserInfo = userInfoSession.getAttribute("loginUserInfo");
        User_info curUserInfo=(User_info) UserInfo;

        certificationPostService.saveLanguage(language_name, language_grade, language_date, curUserInfo);
        return "grade_languages";
    }

    @GetMapping("/main_7_grade")
    public String callPage7(Model model){

        Object UserNum = session.getAttribute("loginUserNum");

        String temp = (String) UserNum;
        Long curUserNum = Long.parseLong(temp);

        model.addAttribute("GradeGraph", subjectService.totalGradeInfo(curUserNum));

        return "main_7_grade";
    }


    @GetMapping("/main_8_interest")
    public String callPage8(Model model){

        Object UserNum = session.getAttribute("loginUserNum");

        String temp = (String) UserNum;
        Long curUserNum = Long.parseLong(temp);

    //    model.addAttribute("Area", interestService.InterestAreafinByUserInfo(curUserNum));
    //    model.addAttribute("Job", interestService.InterestJobfinByUserInfo(curUserNum));
    //    model.addAttribute("Planguage", interestService.InterestPlanguagefinByUserInfo(curUserNum));


        return "main_8_interest";
    }
    @PostMapping("/main_8_interest/Area")
    public void saveAreaInfo(String area1, String area2, String area3){

        Object UserInfo = userInfoSession.getAttribute("loginUserInfo");
        User_info curUserInfo=(User_info) UserInfo;

        interestService.saveInterestArea(area1, area2, area3, curUserInfo);

    }
    @PostMapping("/main_8_interest/Job")
    public void saveJobInfo(String job1, String job2, String job3){

        Object UserInfo = userInfoSession.getAttribute("loginUserInfo");
        User_info curUserInfo=(User_info) UserInfo;

        interestService.saveInterestJob(job1, job2, job3, curUserInfo);

    }
    @PostMapping("/main_8_interest/Planguage")
    public void savePlangInfo(String plang1, String plang2, String plang3){

        Object UserInfo = userInfoSession.getAttribute("loginUserInfo");
        User_info curUserInfo=(User_info) UserInfo;

        interestService.saveInterestPlang(plang1, plang2, plang3, curUserInfo);

    }

    @GetMapping("/main_9_footprint")
    public String callPage9(Model model){

        Object UserInfo = userInfoSession.getAttribute("loginUserInfo");
        User_info curUserInfo=(User_info) UserInfo;

      //  model.addAttribute("Footprint", footPrintService.FootPrintfindByUserInfo(curUserInfo));


        return "main_9_footprint";
    }


    // 관리자 메인 페이징
    @GetMapping("/m_main_1_graph")
    public String callMPage1(){
        return "m_main_1_graph";
    }

    @GetMapping("/graph")
    public String callMPage1re(HttpServletRequest request, Model model){

        String x= request.getParameter("x");
        String y=request.getParameter("y");
        String style=request.getParameter("graph");

        model.addAttribute("ResultY",graphService.showGraph(x,y,style));

        return "m_main_1_graph";
    }

    @GetMapping("/m_main_2_filter")
    public String callMPage2(){
        return "m_main_2_filter";
    }

    @GetMapping("/filter")
    public String callMPage2(HttpServletRequest request,Model model){


         String user_major = request.getParameter("user_major");
         String  user_admyear = request.getParameter("user_admyear");
         String user_num = request.getParameter("user_num");
         String user_name = request.getParameter("user_name");
         String subject_name = request.getParameter("subject_name");
         String subject_option = request.getParameter("subject_option");
         String subject_grade = request.getParameter("subject_grade") ;
         String planguage_name= request.getParameter("planguage_name");
         String contestnum=  request.getParameter("contestnum");
         String studyclubnum= request.getParameter("studyclubnum");
         String projectnum=  request.getParameter("projectnum");
         String internnum=  request.getParameter("internnum");
         String educationnum= request.getParameter("educationnum");
         String topcit= request.getParameter("topcit");
         String toeic=  request.getParameter("toeic");


         model.addAttribute("filter",filterService.conditionfind(user_admyear, user_major, user_num, user_name, subject_name, subject_option, subject_grade, planguage_name, contestnum, studyclubnum, projectnum, internnum, educationnum, topcit, toeic));

        return "m_main_2_filter";
    }

    @GetMapping("/m_main_3_update")
    public String callMPage3(){
        return "m_main_3_update";
    }

    @GetMapping("/m_main_4_add")
    public String callMPage4(){
        return "m_main_4_add";
    }

    @GetMapping("/main_0_home")
    public String main0(){
        return "main_0_home";
    }
}
