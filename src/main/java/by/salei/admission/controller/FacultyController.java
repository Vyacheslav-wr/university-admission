package by.salei.admission.controller;

import by.salei.admission.dto.FacultyGetDto;
import by.salei.admission.dto.SubjectGetDto;
import by.salei.admission.service.api.FacultyService;
import by.salei.admission.service.api.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
@RequestMapping(value = "/faculty")
public class FacultyController {

    @Autowired
    FacultyService facultyService;

    @Autowired
    SubjectService subjectService;

    @GetMapping
    public ModelAndView getAllFaculties(ModelAndView modelAndView) {

        modelAndView.addObject("faculties", facultyService.getAll());
        modelAndView.setViewName("faculty_list");
        return modelAndView;
    }

    @GetMapping(value = "/subjects")
    public ModelAndView getFacultySubjects(@ModelAttribute(value = "id") Long id) {

        ModelAndView modelAndView = new ModelAndView();

        FacultyGetDto faculty = facultyService.getById(id);
        List<SubjectGetDto> subjects = faculty.getSubjects();

        modelAndView.addObject("subjects", subjects);
        modelAndView.setViewName("faculty_info");
        return modelAndView;

    }

}
