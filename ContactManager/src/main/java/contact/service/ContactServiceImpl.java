package contact.service;

import contact.dao.ContactDAO;
import contact.model.Contact;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ContactServiceImpl implements ContactService {

    ContactDAO contactDAO;

    public void setContactDAO(ContactDAO contactDAO) {
        this.contactDAO = contactDAO;
    }

    @Transactional
    public void createContact(Contact contact) {
        this.contactDAO.createContact(contact);
    }

    @Transactional
    public void updateContact(Contact contact) {
        this.contactDAO.updateContact(contact);
    }

    @Transactional
    public void deleteContact(int id) {
        this.contactDAO.deleteContact(id);
    }

    @Transactional
    public Contact getContactById(int id) {
        Contact contact = this.contactDAO.getContactById(id);
        return contact;
    }

    @Transactional
    public List<Contact> getContacts() {

        List<Contact> contactList = this.contactDAO.getContacts();
        return contactList;
    }
}
