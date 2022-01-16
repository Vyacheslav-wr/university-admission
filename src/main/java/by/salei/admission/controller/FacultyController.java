package by.salei.admission.controller;

import by.salei.admission.dto.FacultyGetDto;
import by.salei.admission.dto.SubjectGetDto;
import by.salei.admission.service.api.FacultyService;
import by.salei.admission.service.api.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping(value = "/faculty")
public class FacultyController {

    @Autowired
    FacultyService facultyService;

    @Autowired
    SubjectService subjectService;

    @GetMapping
    public ModelAndView getAllFaculties(ModelAndView modelAndView, HttpServletRequest request) {
        modelAndView.addObject("faculties", facultyService.getAll());
        modelAndView.addObject("user", request.getSession().getAttribute("user"));
        modelAndView.setViewName("faculty_list");
        return modelAndView;
    }

    @GetMapping(value = "/{id}/subjects")
    public ModelAndView getFacultySubjects(@PathVariable(name = "id") Long id, ModelAndView modelAndView,
                                           HttpServletRequest request) {
        FacultyGetDto faculty = facultyService.getById(id);
        List<SubjectGetDto> subjects = faculty.getSubjects();

        modelAndView.addObject("facultyId", id);
        modelAndView.addObject("subjects", subjects);
        modelAndView.addObject("user", request.getSession().getAttribute("user"));
        modelAndView.addObject("registered", request.getSession().getAttribute("registered"));
        modelAndView.setViewName("faculty_info");
        return modelAndView;

    }

}
