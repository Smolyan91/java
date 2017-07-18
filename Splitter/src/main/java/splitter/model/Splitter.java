package splitter.model;

import javax.persistence.*;

@Entity
@Table(name = "SplitterInfo")
public class Splitter {

    @Id
    @GeneratedValue
    @Column(name = "ID")
    private int ID;

    @Column(name = "USERNAME")
    private String USER_NAME;

    @Column(name = "PASSWORD")
    private String PASSWORD;

    @Column(name = "FULLNAME")
    private String FULL_NAME;

    @Column(name = "EMAIL")
    private String EMAIL;

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getUSER_NAME() {
        return USER_NAME;
    }

    public void setUSER_NAME(String USER_NAME) {
        this.USER_NAME = USER_NAME;
    }

    public String getPASSWORD() {
        return PASSWORD;
    }

    public void setPASSWORD(String PASSWORD) {
        this.PASSWORD = PASSWORD;
    }

    public String getFULL_NAME() {
        return FULL_NAME;
    }

    public void setFULL_NAME(String FULL_NAME) {
        this.FULL_NAME = FULL_NAME;
    }

    public String getEMAIL() {
        return EMAIL;
    }

    public void setEMAIL(String EMAIL) {
        this.EMAIL = EMAIL;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    public String toString() {
        return "Splitter{" +
                "ID=" + ID +
                ", USER_NAME='" + USER_NAME + '\'' +
                ", PASSWORD='" + PASSWORD + '\'' +
                ", FULL_NAME='" + FULL_NAME + '\'' +
                ", EMAIL='" + EMAIL + '\'' +
                '}';
    }
}
