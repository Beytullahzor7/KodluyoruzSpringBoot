package com.kodluyoruz.controller;

import com.kodluyoruz.dto.TeacherDto;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
@Log4j2
public class FormController {

    //FORM
    //GET METHOD
    // http://localhost:8080/form
    @GetMapping("/form")
    public String getForm(Model model){
        model.addAttribute("cv_teacher", new TeacherDto());
        return "formvalidation";
    }

    //POST METHOD
    // http://localhost:8080/form
    @PostMapping("/form")
    public String postForm(@Valid @ModelAttribute("cv_teacher") TeacherDto teacherDto, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            log.error("Hata Var!!!");
            return "formvalidation";
        }
        log.info("Success " + teacherDto);
        //db ye kaydet
        return "success";
    }
}
