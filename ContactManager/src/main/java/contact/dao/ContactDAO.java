package contact.dao;

import contact.model.Contact;

import java.util.List;

/**
 * Created by igor on 02.07.17.
 */
public interface ContactDAO {

    void createContact(Contact contact);
    void updateContact(Contact contact);
    void deleteContact(int id);
    Contact getContactById(int id);
    List<Contact> getContacts();
}
