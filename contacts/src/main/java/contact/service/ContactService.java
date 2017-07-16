package contact.service;

import contact.model.Contact;

import java.util.List;


public interface ContactService {
    void addContact(Contact contact);
    List<Contact> listContact();
    void removeContact(Integer id);
}
