package es.uniovi.noteneitor.controllers;

import es.uniovi.noteneitor.entities.User;
import es.uniovi.noteneitor.services.SecurityService;
import es.uniovi.noteneitor.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private SecurityService securityService;

    @RequestMapping("/user/list")
    public String getListado(Model model) {
        model.addAttribute("usersList", userService.getUsers());
        return "user/list";
    }

    @RequestMapping(value = "/user/add")
    public String getUser(Model model) {
        model.addAttribute("usersList", userService.getUsers());
        return "user/add";
    }

    @RequestMapping(value = "/user/add", method = RequestMethod.POST)
    public String setUser(@ModelAttribute User user) {
        userService.addUser(user);
        return "redirect:/user/list";
    }

    @RequestMapping("/user/details/{id}")
    public String getDetail(Model model, @PathVariable Long id) {
        model.addAttribute("user", userService.getUser(id));
        return "user/details";
    }

    @RequestMapping("/user/delete/{id}")
    public String delete(@PathVariable Long id) {
        userService.deleteUser(id);
        return "redirect:/user/list";
    }

    @RequestMapping(value = "/user/edit/{id}")
    public String getEdit(Model model, @PathVariable Long id) {
        User user = userService.getUser(id);
        model.addAttribute("user", user);
        return "user/edit";
    }

    @RequestMapping(value = "/user/edit/{id}", method = RequestMethod.POST)
    public String setEdit(@PathVariable Long id, @ModelAttribute User user) {
        userService.addUser(user);
        return "redirect:/user/details/" + id;
    }

    @RequestMapping(value = "/signup", method = RequestMethod.POST)
    public String signup(@ModelAttribute("user") User user, Model model) {
        userService.addUser(user);
        securityService.autoLogin(user.getDni(), user.getRepeatPassword());
        return "redirect:home";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login() {
        return "login";
    }

    @RequestMapping(value = {"/home"}, method = RequestMethod.GET)
    public String home(Model model) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String dni = auth.getName();
        User activeUser = userService.getUserByDni(dni);
        model.addAttribute("markList", activeUser.getMarks());
        return "home";
    }



}
