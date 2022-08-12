package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import web.model.User;
import web.service.UserService;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/")
    public String showAllUser(Model model) {
        model.addAttribute("allUsers", userService.getAllUsers());
        return "all-users";
    }

    @GetMapping("/new")
    public String addUser(@ModelAttribute("user") User user) {
        return "new-user";
    }

    @PostMapping("/new")
    public String add(@ModelAttribute("user") User user) {
        userService.add(user);
        return "redirect:/";
    }
    @GetMapping("/edit/{id}")
    public String update(@PathVariable("id") int id, Model model){
        model.addAttribute(userService.getUserById(id));
        return "edit";
    }

    @PatchMapping("/{id}")
    public String updateUser(User user, @PathVariable("id") int id) {
        userService.update(id, user);
        return "redirect:/";
    }

    @RequestMapping("/user/{id}")
    public String showUser(@PathVariable("id") int id, Model model) {
        model.addAttribute("showUser", userService.getUserById(id));
        return "show-user";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") int id){
        userService.delete(id);
        return "redirect:/";
    }
}
