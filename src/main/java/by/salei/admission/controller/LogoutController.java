package by.salei.admission.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@RestController
public class LogoutController {

    @GetMapping("/logout")
    public ModelAndView logout(HttpServletRequest request, ModelAndView modelAndView){

        request.getSession().invalidate();

        modelAndView.setViewName("redirect:/login");
        return modelAndView;
    }
}
