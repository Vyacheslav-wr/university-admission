package by.salei.admission.controller;

import by.salei.admission.dto.FacultyGetDto;
import by.salei.admission.dto.SubjectGetDto;
import by.salei.admission.dto.UserGetDto;
import by.salei.admission.entity.UserRole;
import by.salei.admission.service.api.FacultyService;
import by.salei.admission.service.api.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping(value = "/faculty")
public class FacultyController {

    private final FacultyService facultyService;

    private final SubjectService subjectService;

    @Autowired
    public FacultyController(FacultyService facultyService, SubjectService subjectService) {
        this.facultyService = facultyService;
        this.subjectService = subjectService;
    }

    @GetMapping
    public ModelAndView getAllFaculties(ModelAndView modelAndView, HttpServletRequest request) {

        modelAndView.addObject("faculties", facultyService.getAll());
        modelAndView.addObject("user", request.getSession().getAttribute("user"));
        modelAndView.setViewName("faculty_list");
        return modelAndView;
    }

    @GetMapping(value = "/{id}/subjects")
    public ModelAndView getFacultySubjects(@PathVariable(name = "id") Long id,
                                           ModelAndView modelAndView,
                                           HttpServletRequest request) {

        UserGetDto user = (UserGetDto) request.getSession().getAttribute("user");

        if (user != null && user.getRole().equals(UserRole.USER.toString())) {

            FacultyGetDto faculty = facultyService.getById(id);
            List<SubjectGetDto> subjects = faculty.getSubjects();

            modelAndView.addObject("facultyId", id);
            modelAndView.addObject("subjects", subjects);
            modelAndView.addObject("user", request.getSession().getAttribute("user"));
            modelAndView.addObject("registered",
                    request.getSession().getAttribute("registered"));
            modelAndView.addObject("numbers", new ArrayList<Integer>(Arrays.asList(0, 1, 2)));
            modelAndView.setViewName("faculty_info");
            return modelAndView;
        }

        return new ModelAndView("error");

    }

}
