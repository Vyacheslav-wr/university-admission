package by.salei.admission.controller;

import by.salei.admission.dto.FacultyCreateDto;
import by.salei.admission.dto.UserGetDto;
import by.salei.admission.entity.UserRole;
import by.salei.admission.service.api.FacultyService;
import by.salei.admission.service.api.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@Controller
public class FacultyCreationController {

    @Autowired
    private SubjectService subjectService;

    @Autowired
    private FacultyService facultyService;

    @GetMapping(value = "/faculty/new")
    public ModelAndView openFacultyCreation(HttpServletRequest request) {

        UserGetDto user = (UserGetDto) request.getSession().getAttribute("user");

        if (user != null && user.getRole().equals(UserRole.ADMIN.toString())) {

            ModelAndView modelAndView = new ModelAndView();

            modelAndView.addObject("subjects", subjectService.getAll());
            modelAndView.setViewName("faculty_creation");
            modelAndView.addObject("user", user);

            return modelAndView;
        }

        return new ModelAndView("error");
    }

    @PostMapping(value = "/faculty/create")
    public ModelAndView createNewFaculty(@ModelAttribute FacultyCreateDto facultyCreateDto,
                                         HttpServletRequest request) {

        UserGetDto user = (UserGetDto) request.getSession().getAttribute("user");

        if (user != null) {

            ModelAndView modelAndView = new ModelAndView("redirect:/faculty");

            facultyService.save(facultyCreateDto);

            return modelAndView;
        }

        return new ModelAndView("error");
    }
}
