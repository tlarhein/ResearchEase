package org.launchcode.controllers;

import org.launchcode.models.Instrument;
import org.launchcode.models.Response;
import org.launchcode.models.data.InstrumentDao;
import org.launchcode.models.data.ResponseDao;
import org.launchcode.models.forms.AddInstrumentItemForm;
import org.launchcode.models.forms.AddResponseItemForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
/**
 * Created by Tracey Cannon LiftOff 0519
 */
@Controller
@RequestMapping(value = "response")
public class ResponseController {

    @Autowired
    private ResponseDao responseDao;

    @Autowired
    private InstrumentDao instrumentDao;

    //public ResponseController(ResponseDao responseDao, InstrumentDao instrumentDao) {
        //this.responseDao = responseDao;
        //this.instrumentDao = instrumentDao;

    @RequestMapping(value = "")
    public String index(Model model){
        model.addAttribute("title", "Research Instrument Responses");
        model.addAttribute("responses", responseDao.findAll());
        return "response/index";
    }
    //Request Path response/add
    @RequestMapping(value = "add", method = RequestMethod.GET)
    public String add(Model model) {
        model.addAttribute("title", "Add Research Instrument Response");
        model.addAttribute(new Response());
        //model.addAttribute("menus", responseDao.findAll());
        return "response/add";
    }

    @RequestMapping(value = "add", method = RequestMethod.POST)
    public String add(Model model, @ModelAttribute @Valid Response
            response, Errors errors) {

        if (errors.hasErrors()){
            //model.addAttribute("title", "Add Response");
            //model.addAttribute(new Error());
            //model.addAttribute("responses", responseDao.findAll());
            return "response/add";
        }

        responseDao.save(response);
        return "redirect:/response/view/" + response.getId();
    }

    @RequestMapping(value = "view/{id}", method = RequestMethod.GET)
    public String viewResponse(Model model, @PathVariable int id){
        //model.addAttribute("response", responseDao.findOne(id));
        Response response = responseDao.findOne(id);
        model.addAttribute("title", response.getName());
        model.addAttribute("instruments", response.getInstruments());
        model.addAttribute("responseId", response.getId());
        //model.addAttribute("title", response.getName());
        //model.addAttribute("instrument", response.getInstrument());
        //model.addAttribute("id", response.getId());
        //code above replaced with code below
        //Response response = responseDao.findOne(id);
        //model.addAttribute("response", response);

        //model.addAttribute("response", responseDao.findOne(id));
        return "response/view";

    }

    @RequestMapping(value = "add-item/{id}", method = RequestMethod.GET)
    public String addItem(Model model, @PathVariable int id){
        Response response = responseDao.findOne(id);
        AddResponseItemForm form = new AddResponseItemForm(response, instrumentDao.findAll());
        model.addAttribute("form", form);
        model.addAttribute("title", "Add new item to responses: " + response.getName());
        return "response/add-item";

    }

    @RequestMapping(value = "add-item", method = RequestMethod.POST)
    //public String addItem(Model model, @ModelAttribute @Valid AddInstrumentItemForm form, Errors errors, @RequestParam int id){
    //public String addItem(Model model, @ModelAttribute @Valid AddInstrumentItemForm form, Errors errors){
    public String addItem(Model model, @ModelAttribute @Valid AddInstrumentItemForm form, Errors errors, @RequestParam int responseId, @RequestParam int instrumentId) {
        if (errors.hasErrors()){
            //model.addAttribute("form", form);
            //model.addAttribute("title", "Add item to menu: " + form.getMenuId());
            return "response/add-item";
        }

        Instrument aInstrument = instrumentDao.findOne(form.getInstrumentId());
        Response aResponse = responseDao.findOne(form.getResponseId());
        aResponse.addItem(aInstrument);
        responseDao.save(aResponse);

        return "redirect:/response/view/" + aResponse.getId();
    }
}
