
/**
 * 
 */
package com.cm.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.cm.rest.app.ApiVersions;
import com.cm.rest.dto.ConversationDto;
import com.cm.rest.facade.conversation.ConversationFacade;

/**
 * @author VladislavKondratenko (k.volad@gmail.com)
 *
 */
@RestController
@RequestMapping(value = "/rest/" + ApiVersions.VERSION + "/conversation")
public class ConversationController extends BaseController {

    @Autowired
    private ConversationFacade conversationFacade;

    @RequestMapping(value = "/{name}", method = RequestMethod.GET)
    @ResponseBody
    public String sayHello(@PathVariable String name) {
        return "Hello " + name;
    }

    @RequestMapping(value = "/tree/load/{userId}", method = RequestMethod.GET)
    @ResponseBody
    public ConversationDto treeLoad(@PathVariable Long userId) {
        return conversationFacade.loadUserConversationStructure(userId);
    }
}
