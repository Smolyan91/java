package splitter.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "TwitSplit")
public class TwitSplit {

    @Id
    @GeneratedValue
    @Column(name = "ID")
    private int ID;

    @Column(name = "MESSAGE")
    private String MESSAGE;

    @Column(name = "DATE")
    private Date DATE;

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getMESSAGE() {
        return MESSAGE;
    }

    public void setMESSAGE(String MESSAGE) {
        this.MESSAGE = MESSAGE;
    }

    public Date getDATE() {
        return DATE;
    }

    public void setDATE(Date DATE) {
        this.DATE = DATE;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TwitSplit splitle = (TwitSplit) o;

        if (ID != splitle.ID) return false;
        if (MESSAGE != null ? !MESSAGE.equals(splitle.MESSAGE) : splitle.MESSAGE != null) return false;
        return DATE != null ? DATE.equals(splitle.DATE) : splitle.DATE == null;
    }

    @Override
    public int hashCode() {
        int result = ID;
        result = 31 * result + (MESSAGE != null ? MESSAGE.hashCode() : 0);
        result = 31 * result + (DATE != null ? DATE.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "TwitSplit{" +
                "ID=" + ID +
                ", MESSAGE='" + MESSAGE + '\'' +
                ", DATE=" + DATE +
                '}';
    }
}
