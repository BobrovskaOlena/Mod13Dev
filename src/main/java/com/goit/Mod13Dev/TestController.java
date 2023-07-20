package com.goit.Mod13Dev;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class TestController {
    @RequestMapping(value = "/test", method = {RequestMethod.GET})
    public ModelAndView showTestPage (){
    ModelAndView result = new ModelAndView();
    result.addObject("message", "Hello, world!");
    return result;
    }
}
