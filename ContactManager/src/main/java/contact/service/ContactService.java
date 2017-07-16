package contact.service;

import contact.model.Contact;

import java.util.List;


public interface ContactService {
    void createContact(Contact contact);
    void updateContact(Contact contact);
    void deleteContact(int id);
    Contact getContactById(int id);
    List<Contact> getContacts();
}
