package contact.model;


import javax.persistence.*;

@Entity
@Table(name = "Contact")
public class Contact {

    @Id
    @Column(name = "ID")
    @GeneratedValue
    private int ID;

    @Column(name = "NAME")
    private String NAME;

    @Column(name = "SNAME")
    private String SNAME;

    @Column(name = "PHONE")
    private String PHONE;

    @Column(name = "EMAIL")
    private String EMAIL;

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getNAME() {
        return NAME;
    }

    public void setNAME(String NAME) {
        this.NAME = NAME;
    }

    public String getSNAME() {
        return SNAME;
    }

    public void setSNAME(String SNAME) {
        this.SNAME = SNAME;
    }

    public String getPHONE() {
        return PHONE;
    }

    public void setPHONE(String PHONE) {
        this.PHONE = PHONE;
    }

    public String getEMAIL() {
        return EMAIL;
    }

    public void setEMAIL(String EMAIL) {
        this.EMAIL = EMAIL;
    }

    @Override
    public String toString() {
        return "Contact{" +
                "ID=" + ID +
                ", NAME='" + NAME + '\'' +
                ", SNAME='" + SNAME + '\'' +
                ", PHONE='" + PHONE + '\'' +
                ", EMAIL='" + EMAIL + '\'' +
                '}';
    }
}
