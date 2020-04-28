package viettel.vtcc.reputa.orm.api.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import viettel.vtcc.reputa.orm.api.model.Contact;

@RestController
@RequestMapping("/contacts")
public class ContactsController {

    @GetMapping("")
    public Object getContact() {
        return new ResponseEntity<>(Contact.builder().name("ahihi").build(), HttpStatus.OK);
    }
}
