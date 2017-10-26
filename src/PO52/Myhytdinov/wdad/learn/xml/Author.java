package PO52.Myhytdinov.wdad.learn.xml;

import java.io.Serializable;

/**
 * Created by myhytdinov on 25.09.2017.
 */
public class Author implements Serializable {
    private String firstName;
    private String secondName;

    public Author(String firstName, String secondName) {
        this.firstName = firstName;
        this.secondName = secondName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getSecondName() {
        return secondName;
    }


    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }
}
