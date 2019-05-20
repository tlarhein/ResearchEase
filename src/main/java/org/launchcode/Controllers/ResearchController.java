package org.launchcode.Controllers;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by Tracey Cannon
 */

//Controller at Root Path
@Controller
public class ResearchController {

    @RequestMapping(value = "")
    @ResponseBody
    public String index(){
        return "Hello, welcome to Research Ease!";
    }

 //Controller NOT at Root Path
    @RequestMapping(value = "setup")
    @ResponseBody
    public String setup() {
        return "Please register to setup a research account";
    }
}