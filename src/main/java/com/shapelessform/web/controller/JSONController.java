package com.shapelessform.web.controller;

import com.shapelessform.jettison.model.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/environments")
public class JSONController {

    @RequestMapping(value = "{name}", method = RequestMethod.GET)
    public @ResponseBody Environment
    getEnvironments(@PathVariable String name){
        Environment environment = new Environment();
        environment.setName(name);
        environment.setOwner("Andrew");
        return environment;
    }
}
