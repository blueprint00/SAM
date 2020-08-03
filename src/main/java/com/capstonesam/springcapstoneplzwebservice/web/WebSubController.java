package com.capstonesam.springcapstoneplzwebservice.web;

import com.capstonesam.springcapstoneplzwebservice.Service.PlanguageService;
import com.capstonesam.springcapstoneplzwebservice.Service.SubjectService;
import com.capstonesam.springcapstoneplzwebservice.domain.Login.User_info;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;

@Controller
@AllArgsConstructor
public class WebSubController {
    WebController webController;
    private PlanguageService planguageService;

    private SubjectService subjectService;

    @GetMapping("/exam_C")
    public String examC(){

        return "exam_C";
    }
    @PostMapping("/exam_C")
    public String examCP(String user_A1, String user_A2, String user_A3){

        Object UserInfo = webController.userInfoSession.getAttribute("loginUserInfo");
        User_info curUserInfo=(User_info) UserInfo;

        planguageService.saveTestResult("C", user_A1, user_A2, user_A3, curUserInfo);

        return "exam_C";
    }

    @GetMapping("/exam_cplus")
    public String examCplus(){
        return "exam_cplus";
    }

    @PostMapping("/exam_cplus")
    public String examCplusP(String user_A1, String user_A2, String user_A3){


        Object UserInfo = webController.userInfoSession.getAttribute("loginUserInfo");
        User_info curUserInfo=(User_info) UserInfo;

        planguageService.saveTestResult("Cpp", user_A1, user_A2, user_A3, curUserInfo);

        return "exam_cplus";
    }


    @GetMapping("/exam_etc")
    public String examEtc(){
        return "exam_etc";
    }



    @PostMapping("/exam_etc")
    public String examEtc(String planguage_name, String planguage_level){


        Object UserInfo = webController.userInfoSession.getAttribute("loginUserInfo");
        User_info curUserInfo=(User_info) UserInfo;


        planguageService.saveTestResultEtc( planguage_name,  planguage_level, curUserInfo);
        return "exam_etc";
    }


    @GetMapping("/exam_java")
    public String examJava(){
        return "exam_java";
    }

    @PostMapping("/exam_java")
    public String examJavaP(String user_A1, String user_A2, String user_A3){

        Object UserInfo = webController.userInfoSession.getAttribute("loginUserInfo");
        User_info curUserInfo=(User_info) UserInfo;

        planguageService.saveTestResult("Java", user_A1, user_A2, user_A3, curUserInfo);


        return "exam_java";
    }

    @GetMapping("/exam_python")
    public String examPython(){
        return "exam_python";
    }

    @PostMapping("/exam_python")
    public String examPythonP(String user_A1, String user_A2, String user_A3){

        Object UserInfo = webController.userInfoSession.getAttribute("loginUserInfo");
        User_info curUserInfo=(User_info) UserInfo;

        planguageService.saveTestResult("Python", user_A1, user_A2, user_A3, curUserInfo);

        return "exam_python";
    }

    @GetMapping("/grade_ceritificate")
    public String gradeCer(){
        return "grade_ceritificate";
    }

    @GetMapping("/grade_languages")
    public String gradeLag(){
        return "grade_languages";
    }

    @GetMapping("/grade_topcitc")
    public String gradeTop(){
        return "grade_topcitc";
    }

    @GetMapping("/grade_credit_majorCore")
    public String gradeCore(Model model){

        Object UserNum = webController.session.getAttribute("loginUserNum");

        String temp = (String)UserNum;
        Long curUserNum = Long.parseLong(temp);

        model.addAttribute("grade", subjectService.Subjectfind(curUserNum,"전필"));


        return "grade_credit_majorCore";
    }

    @GetMapping("/grade_credit_majorElective")
    public String gradeEle(Model model){

        Object UserNum = webController.session.getAttribute("loginUserNum");

        String temp = (String)UserNum;
        Long curUserNum = Long.parseLong(temp);

        model.addAttribute("grade", subjectService.Subjectfind(curUserNum,"전선"));

        return "grade_credit_majorElective";
    }

    @GetMapping("/job_5")
    public String job_5(){
        return "job_5";
    }

    @GetMapping("/job_C")
    public String job_C(){
        return "job_C";
    }

    @GetMapping("/job_etc")
    public String job_etc(){
        return "job_etc";
    }

    @GetMapping("/job_java")
    public String job_java(){
        return "job_java";
    }

    @GetMapping("/job_javascript")
    public String job_javascript(){
        return "job_javascript";
    }

    @GetMapping("/job_objectc")
    public String job_objectc(){
        return "job_objectc";
    }

    @GetMapping("/job_php")
    public String job_php(){
        return "job_php";
    }

    @GetMapping("/job_py")
    public String job_py(){
        return "job_py";
    }

    @GetMapping("/job_visual")
    public String job_visual(){
        return "job_visual";
    }


}
