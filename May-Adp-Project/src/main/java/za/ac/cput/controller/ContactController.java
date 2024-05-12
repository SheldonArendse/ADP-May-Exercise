package za.ac.cput.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.domain.Contact;
import za.ac.cput.factory.ContactFactory;
import za.ac.cput.service.ContactService;

import java.util.List;

@RestController
@RequestMapping("/contact")
public class ContactController {

    private ContactService contactService;

    @Autowired
    public ContactController(ContactService contactService) {
        this.contactService = contactService;
    }

    @PostMapping("/create")
    public Contact create(@RequestBody Contact obj) {
        Contact c1 = ContactFactory.buildContact(obj.getEmail(), obj.getMobile(), obj.getWorkTelephone());
        return contactService.create(c1);
    }

    @GetMapping("/read/{s}")
    public Contact read(@PathVariable String s) {
        return contactService.read(s);
    }

    @PostMapping("/delete/{id}")
    public void delete(@PathVariable String id) {
        Contact c1 = ContactFactory.buildContact(id);
        contactService.delete(c1);
    }

    @PostMapping("/update")
    public Contact update(Contact obj) {
        Contact c1 = ContactFactory.buildContact(obj.getEmail(), obj.getMobile(), obj.getWorkTelephone());
        return contactService.create(c1);
    }

    @GetMapping("/getAll")
    public List<Contact> getAll() {
        return contactService.getAll();
    }
}
