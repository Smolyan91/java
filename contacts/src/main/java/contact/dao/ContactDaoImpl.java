package contact.dao;

import contact.model.Contact;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ContactDaoImpl implements ContactDAO{

    @Autowired
    private SessionFactory sessionFactory;


    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void addContact(Contact contact) {
        sessionFactory.getCurrentSession().save(contact);
    }

    @SuppressWarnings("unchecked")
    public List<Contact> listContact() {
        return sessionFactory.getCurrentSession().createQuery("FROM Contact").list();
    }

    public void removeContact(Integer id) {
        Contact contact = (Contact) sessionFactory.getCurrentSession()
                .load(Contact.class, id);
        if (contact != null){
            sessionFactory.getCurrentSession().delete(contact);
        }
    }
}
