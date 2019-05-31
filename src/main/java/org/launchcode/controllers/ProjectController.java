package org.launchcode.controllers;



import org.launchcode.models.Project;
import org.launchcode.models.data.ProjectDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import javax.validation.Valid;


/**
* Created by Tracey Cannon, Liftoff 0519
 */


//Controller at Root Path
@Controller
@RequestMapping("project")
public class ProjectController {

    @Autowired //will eliminate the need to create a class to pass this dao into, it will instead be a dependency injection, created by the framework with along with an instance
    private ProjectDao projectDao;

    @RequestMapping(value="")
    public String index(Model model) {

        model.addAttribute("title", "Projects");
        model.addAttribute("projects", projectDao.findAll()); //returns an iterable, that loops over all the projects

        return "project/index";
    }

    @RequestMapping(value = "add", method = RequestMethod.GET)
    public String add(Model model) {

        model.addAttribute(new Project());
        model.addAttribute("title", "Add Project");

        return "project/add";
    }

    @RequestMapping(value = "add", method = RequestMethod.POST)
    public String add(Model model, @ModelAttribute @Valid Project
            project, Errors errors) {

        if (errors.hasErrors()) {
            //model.addAttribute("title", "Add Research Project");
            return "project/add";
        }
        else{


            projectDao.save(project);
            return "redirect:/project";
        }

    }}