package PO52.Myhytdinov.wdad.learn.xml;

/**
 * Created by myhytdinov on 25.09.2017.
 */
public class Reader {
    private String firstName;
    private String secondName;

    public Reader(String firstName, String secondName) {
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

