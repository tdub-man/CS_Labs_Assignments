package bankAccount;

/**
 * Created by Ben on 8/24/2015.
 */
public class Person {

    private String personId;  // cannot be changed
    private String name;
    private String email;

    public Person(String personId) {
        this.personId = personId;
    }

    public Person(String personId, String name, String email) {
        this.personId = personId;
        this.name = name;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPersonId() {
        return personId;
    }
}
