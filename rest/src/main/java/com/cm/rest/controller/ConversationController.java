
/**
 * 
 */
package com.cm.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.cm.entity.CallerPhrase;
import com.cm.entity.CustomerPhrase;
import com.cm.rest.app.ApiVersions;
import com.cm.rest.dto.CallDto;
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

    @RequestMapping(value = "/tree/{userId}", method = RequestMethod.GET)
    @ResponseBody
    public ConversationDto treeLoad(@PathVariable Long userId) {
        return conversationFacade.loadUserConversationStructure(userId);
    }

    @RequestMapping(value = "/customer/phrase/update", method = RequestMethod.PUT)
    @ResponseBody
    public void updateCustomerPhrase(@RequestBody CustomerPhrase customerPhrase) {
        conversationFacade.updateCustomerPhrase(customerPhrase);
    }

    @RequestMapping(value = "/call", method = RequestMethod.PUT)
    @ResponseBody
    public void saveCall(@RequestBody CallDto callDto) {
        conversationFacade.saveCall(callDto);
    }

    @RequestMapping(value = "/customer/phrase/create/{callerPhraseId}", method = RequestMethod.POST)
    @ResponseBody
    public CustomerPhrase customerPhrase(@PathVariable Long callerPhraseId,
            @RequestBody CustomerPhrase customerPhrase) {
        return conversationFacade.createCustomerPhrase(callerPhraseId, customerPhrase);
    }

    @RequestMapping(value = "/caller/phrase/create", method = RequestMethod.POST)
    @ResponseBody
    public CallerPhrase callerPhrase(@RequestBody CallerPhrase callerPhrase) {
        return conversationFacade.createCallerPhrase(callerPhrase);
    }

    @RequestMapping(value = "/customer/answer/update/{customerPhraseId}/{callerPhraseId}", method = RequestMethod.POST)
    @ResponseBody
    public void updateCustomerAnsweVariants(@PathVariable Long customerPhraseId, @PathVariable Long callerPhraseId) {
        conversationFacade.updateCustomerAnsweVariants(customerPhraseId, callerPhraseId);
    }

    @RequestMapping(value = "/customer/phrase/delete/{customerPhraseId}/{callerPhraseId}", method = RequestMethod.DELETE)
    @ResponseBody
    public void deleteCustomerPhrase(@PathVariable Long customerPhraseId, @PathVariable Long callerPhraseId) {
        conversationFacade.deleteCustomerPhrase(callerPhraseId, customerPhraseId);
    }

}
