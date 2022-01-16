package by.salei.admission.controller;

import by.salei.admission.dto.EnrolleeSubjectCreateDto;
import by.salei.admission.dto.FacultyGetDto;
import by.salei.admission.dto.SubjectGetDto;
import by.salei.admission.dto.UserGetDto;
import by.salei.admission.service.api.EnrolleeService;
import by.salei.admission.service.api.EnrolleeSubjectService;
import by.salei.admission.service.api.FacultyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@RestController
public class EnrolleeSubjectController {

    @Autowired
    FacultyService facultyService;

    @Autowired
    EnrolleeService enrolleeService;

    @Autowired
    EnrolleeSubjectService enrolleeSubjectService;

    @PostMapping(value = "/{id}/subjects/new")
    public ModelAndView createUserSubject(@RequestParam(name = "score1") Integer score1,
                                          @RequestParam(name = "score2") Integer score2,
                                          @RequestParam(name = "score3") Integer score3,
                                          @PathVariable(name = "id") Long id,
                                          ModelAndView modelAndView,
                                          HttpServletRequest request) {

        UserGetDto user = (UserGetDto) request.getSession().getAttribute("user");
        FacultyGetDto faculty = facultyService.getById(id);
        Long enrollee_id = enrolleeService.findByUserId(user.getId()).getId();

        if(!enrolleeService.isAlreadyRegistered(enrollee_id)){

            List<Integer> list = new ArrayList<>();
            list.add(score1);
            list.add(score2);
            list.add(score3);

            List<SubjectGetDto> subjects = faculty.getSubjects();

            for (int i = 0; i < 3; i++) {

                EnrolleeSubjectCreateDto enrolleeSubjectCreateDto = new EnrolleeSubjectCreateDto();

                enrolleeService.setFaculty(faculty.getId(), enrollee_id);
                enrolleeSubjectCreateDto.setSubject_type_id(subjects.get(i).getId());
                enrolleeSubjectCreateDto.setEnrollee_id(enrollee_id);
                enrolleeSubjectCreateDto.setScore(list.get(i));

                enrolleeSubjectService.save(enrolleeSubjectCreateDto);
            }

            modelAndView.setViewName("redirect:/faculty");
            return modelAndView;
        }

        modelAndView.setViewName("redirect:/faculty/" + faculty.getId() + "/subjects");
        request.getSession().setAttribute("registered", "You already registered on faculty");
        return modelAndView;
    }
}
