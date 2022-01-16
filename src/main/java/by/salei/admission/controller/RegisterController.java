package by.salei.admission.controller;

import by.salei.admission.dto.EnrolleeCreateDto;
import by.salei.admission.dto.UserCreateDto;
import by.salei.admission.dto.UserGetDto;
import by.salei.admission.service.api.EnrolleeService;
import by.salei.admission.service.api.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.persistence.NoResultException;
import javax.servlet.http.HttpServletRequest;

@RestController
public class RegisterController {

    @Autowired
    EnrolleeService enrolleeService;

    @Autowired
    UserService userService;

    @GetMapping(value = "/register")
    public ModelAndView register(ModelAndView modelAndView, HttpServletRequest request){
        modelAndView.setViewName("RegisterPage");
        modelAndView.addObject("error1", request.getSession().getAttribute("error1"));
        return modelAndView;
    }

    @PostMapping(value = "/validity")
    public ModelAndView validate(@ModelAttribute UserCreateDto user,
                                 @ModelAttribute EnrolleeCreateDto enrollee,
                                 ModelAndView modelAndView,
                                 HttpServletRequest request){

        try{
            userService.getByUsername(user.getUsername());
        }
        catch (NoResultException ex){
            if(enrollee.getScore() > 100 || enrollee.getScore() < 0){
                modelAndView.setViewName("RegisterPage");
                modelAndView.addObject("error1", "Invalid score: " + enrollee.getScore());
                return modelAndView;
            }

            userService.save(user);

            UserGetDto userGetDto = userService.getByUsername(user.getUsername());

            enrollee.setUser(userGetDto.getId());
            enrolleeService.save(enrollee);

            request.getSession().setAttribute("user", userGetDto);
            modelAndView.setViewName("redirect:/faculty");
            return modelAndView;
        }

        modelAndView.setViewName("RegisterPage");
        modelAndView.addObject("error", "User with username: " + user.getUsername()
                + " already exist");
        return modelAndView;
    }
}
