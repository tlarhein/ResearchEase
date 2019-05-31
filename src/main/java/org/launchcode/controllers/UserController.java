package org.launchcode.controllers;


//import org.apache.tomcat.jni.User;
import org.launchcode.models.User;
import org.launchcode.models.Project;
import org.launchcode.models.data.ProjectDao;
import org.launchcode.models.data.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserDao userDao;

    @Autowired
    private ProjectDao projectDao;


    //public UserController(UserDao userDao) {
        //this.userDao = userDao;

    //Request path /user
    @RequestMapping(value = "")
    public String index(Model model) {

        model.addAttribute("users", userDao.findAll());
        model.addAttribute("title", "User");
        return "user/index";
    }
    // Request Path user/add
    @RequestMapping(value = "add", method = RequestMethod.GET)
    public String displayAddUserForm(Model model) {
        model.addAttribute("title", "Add User");
        model.addAttribute(new User());
        model.addAttribute("projects", projectDao.findAll());
        return "user/add";
    }
    //Request path user/add
    @RequestMapping(value = "add", method = RequestMethod.POST)
    public String processAddUserForm(@ModelAttribute @Valid User newUser,
                                     Errors errors, @RequestParam int projectId, Model model) {

        if (errors.hasErrors()){
            model.addAttribute("title", "Add User");
            return "user/add";
        }
        Project pro = projectDao.findOne(projectId);
        newUser.setProject(pro);
        userDao.save(newUser);
        return "redirect:" + newUser.toString();
    }

    @RequestMapping(value = "view/{id}", method = RequestMethod.GET)
    public String viewUser(Model model, @PathVariable int id){
        User user = userDao.findOne(id);
        model.addAttribute("user", user);
        model.addAttribute("title", user.getName());
        return "user/view";
        }

    // Request path user/remove
    @RequestMapping(value = "remove", method = RequestMethod.GET)
    public String displayRemoveUserForm(Model model) {
        model.addAttribute("users", userDao.findAll());
        model.addAttribute("title", "Remove User Account");
        return "user/remove";
    }

    // Request path: cheese/remove
    @RequestMapping(value = "remove", method = RequestMethod.POST)
    public String processRemoveUserForm(@RequestParam int[] userIds) {
        for (int userId : userIds) {
            userDao.delete(userId);
        }
        // Redirect to user/
        return "redirect:";
    }

}

