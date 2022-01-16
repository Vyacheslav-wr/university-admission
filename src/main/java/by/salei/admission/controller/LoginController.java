package by.salei.admission.controller;

import by.salei.admission.dto.UserGetDto;
import by.salei.admission.service.api.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.persistence.NoResultException;
import javax.servlet.http.HttpServletRequest;

@RestController
public class LoginController {

    @Autowired
    private UserService userService;

    @GetMapping(value = "/login")
    public ModelAndView getLoginPage(HttpServletRequest request, ModelAndView modelAndView) {
        modelAndView.addObject("error", request.getSession().getAttribute("error"));
        modelAndView.setViewName("LoginPage");
        return modelAndView;
    }

    @PostMapping(value = "/entrance")
    public ModelAndView loginIntoAccount(@RequestParam(name = "username") String username,
                                         @RequestParam(name = "password") String pass, ModelAndView modelAndView,
                                         HttpServletRequest request) {

        modelAndView.setViewName("redirect:/faculty");

        try {
            UserGetDto user = userService.getByUsername(username);

            if (user.getPassword().equals(pass)) {
                request.getSession().setAttribute("user", user);
                return modelAndView;
            }
            else {
                modelAndView.setViewName("redirect:/login");
                request.getSession().setAttribute("error", "Incorrect password");
            }
        } catch (NoResultException ex) {
            modelAndView.setViewName("redirect:/login");
            request.getSession().setAttribute("error", "Incorrect login");
        }

        return modelAndView;
    }
}
