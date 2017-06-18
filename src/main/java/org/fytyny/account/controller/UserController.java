package org.fytyny.account.controller;

import org.fytyny.account.forms.dto.UserRegistrationDto;
import org.fytyny.account.model.User;
import org.fytyny.account.sevices.EmailExistsException;
import org.fytyny.account.sevices.UserService;
import org.fytyny.account.sevices.UsernameExistsException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.validation.Valid;

@Controller
@RequestMapping("/")
public class UserController{
    @Resource
    UserService service;

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String register(WebRequest request, Model model){
        UserRegistrationDto userRegistrationDto = new UserRegistrationDto();
        model.addAttribute("user", userRegistrationDto);
        return "registration";
    }
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public ModelAndView registerUserAccount
            (@ModelAttribute("user") @Valid UserRegistrationDto accountDto,
             BindingResult result, WebRequest request, Errors errors) {
        User registered = null;
        if (!result.hasErrors()) {
            try{
                registered = createUserAccount(accountDto, result);
                return new ModelAndView("successRegister", "user", accountDto);
            }catch (UsernameExistsException f){
                result.rejectValue("login", "message.regError");
            }catch (EmailExistsException e){
                result.rejectValue("email", "message.regError");
            }

        }else {
           // result.getAllErrors().get(0).

        }
        return new ModelAndView("registration", "user", accountDto);
    }

    private User createUserAccount(UserRegistrationDto accountDto, BindingResult result) throws EmailExistsException, UsernameExistsException {
        User registered = service.registerNew(accountDto);
        return registered;
    }
}
