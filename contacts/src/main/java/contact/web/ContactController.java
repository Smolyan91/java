package contact.web;

import contact.model.Contact;
import contact.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * Created by igor on 15.07.17.
 */
@Controller
public class ContactController {


    private ContactService contactService;

    @Autowired
    @Qualifier(value = "contactService")
    public void setContactService(ContactService contactService){
        this.contactService = contactService;
    }


    @RequestMapping(value = "/contact", method = RequestMethod.GET)
    public String listContacts(Map<String, Object> map){
        map.put("contact", new Contact());
        map.put("contactList", contactService.listContact());
        return "contact";
    }

    @RequestMapping("/")
    public String home(){
        return "redirect:/contact";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String addContact(@ModelAttribute("contact") Contact contact, BindingResult result){
        contactService.addContact(contact);
        return "redirect:/contact";
    }

    @RequestMapping("/delete/{contactId}")
    public String deleteContact(@PathVariable("contactId") Integer contactId){
        contactService.removeContact(contactId);
        return "redirect:/contact";
    }
}
