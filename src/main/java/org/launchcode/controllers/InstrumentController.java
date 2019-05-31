package org.launchcode.controllers;

/**
 * Created by Tracey Cannon LiftOff 0519
 */

import org.launchcode.models.Project;
import org.launchcode.models.Instrument;
import org.launchcode.models.data.InstrumentDao;
import org.launchcode.models.data.ProjectDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("instrument")
public class InstrumentController {

    @Autowired //framework will create the class, the instance, and populate it
    private InstrumentDao instrumentDao;

    @Autowired
    private ProjectDao projectDao;


    //Request path /instrument
    @RequestMapping(value = "")
    public String index(Model model) {
    //findAll will be an iterable loop-over that will find and display all of the instruments (CrudRepository)
        model.addAttribute("instruments", instrumentDao.findAll());
        model.addAttribute("title", "My Research Instruments");

        return "instrument/index";
    }
    // Request Path Instrument/add
    @RequestMapping(value = "add", method = RequestMethod.GET)
    public String displayAddInstrumentForm(Model model) {
        model.addAttribute("title", "Add Instrument");
        model.addAttribute(new Instrument());
        model.addAttribute("projects", projectDao.findAll());
        return "instrument/add";
    }
    //Request path Instrument/add
    @RequestMapping(value = "add", method = RequestMethod.POST)
    public String processAddInstrumentForm(@ModelAttribute @Valid Instrument newInstrument,
                                       Errors errors, @RequestParam int projectId, Model model) {

        if (errors.hasErrors()){
            model.addAttribute("title", "Add Instrument");
            //model.addAttribute("projects", projectDao.findAll());
            return "instrument/add";
        }
        Project pro = projectDao.findOne(projectId);
        newInstrument.setProject(pro);
        instrumentDao.save(newInstrument);
        return "redirect:";
    }
    // Request path instrument/remove
    @RequestMapping(value = "remove", method = RequestMethod.GET)
    public String displayRemoveInstrumentForm(Model model) {
        model.addAttribute("instruments", instrumentDao.findAll());
        model.addAttribute("title", "Remove Research Instrument");
        return "instrument/remove";
    }

    // Request path: instrument/remove
    @RequestMapping(value = "remove", method = RequestMethod.POST)
    public String processRemoveInstrumentForm(@RequestParam int[] instrumentIds) {

        for (int instrumentId : instrumentIds) {
            instrumentDao.delete(instrumentId);

        }
        // Redirect to instruments/
        return "redirect:";
    }

    @RequestMapping(value = "project/{projectId}", method = RequestMethod.GET)
    public String project(Model model, @RequestParam int projectId) {
        model.addAttribute("instruments", projectDao.findOne(projectId).getInstruments());
        model.addAttribute("title", "My Research Projects and Instruments");
        return "instrument/index";

    }


}