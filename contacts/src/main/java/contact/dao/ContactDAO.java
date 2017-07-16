package contact.dao;

import contact.model.Contact;
import java.util.List;

public interface ContactDAO {
    void addContact(Contact contact);
    List<Contact> listContact();
    void removeContact(Integer id);
}
