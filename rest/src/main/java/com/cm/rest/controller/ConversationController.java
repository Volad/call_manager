
/**
 * 
 */
package com.cm.rest.controller;

import javax.annotation.PostConstruct;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.cm.rest.app.ApiVersions;

/**
 * @author VladislavKondratenko (k.volad@gmail.com)
 *
 */
@RestController
@RequestMapping(value = "/rest/" + ApiVersions.VERSION + "/conversation")
public class ConversationController {

    @RequestMapping(value = "/{name}", method = RequestMethod.GET)
    @ResponseBody
    public String sayHello(@PathVariable String name) {
        return "Hello " + name;
    }
}
