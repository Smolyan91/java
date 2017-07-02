package contact.dao;

import contact.model.Contact;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ContactDaoImpl implements ContactDAO {

    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void createContact(Contact contact) {
        Session session = this.sessionFactory.getCurrentSession();
        session.persist(contact);
        //Logging
    }

    public void updateContact(Contact contact) {
        Session session = this.sessionFactory.getCurrentSession();
        session.update(contact);
        //Logging
    }

    public void deleteContact(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        Contact contact = session.load(Contact.class, new Integer(id));

        if (contact != null) session.delete(contact);
        //Logging
    }

    public Contact getContactById(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        Contact contact = session.load(Contact.class, new Integer((id)));
        if (contact != null) return contact;
        return null;
    }

    @SuppressWarnings("unchecked")
    public List<Contact> getContacts() {
        Session session = this.sessionFactory.getCurrentSession();
        List <Contact> listContacts = session.createQuery("from Coontact").list();
//        for (Contact entryContact : listContacts){
//            logger.info("Contact list: " + entryContact);
//        }
        return listContacts;
    }
}
