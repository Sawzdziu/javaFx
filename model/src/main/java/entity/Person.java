package entity;

/**
 * Created by piotrsa on 20/08/18.
 */

import javafx.beans.property.SimpleStringProperty;
import lombok.Data;
import row.PriorityEnum;

@Data
public class Person {

    private final SimpleStringProperty firstName;
    private final SimpleStringProperty lastName;
    private final SimpleStringProperty email;
    private PriorityEnum priority;

    public Person(String fName, String lName, String email, PriorityEnum priority) {
        this.firstName = new SimpleStringProperty(fName);
        this.lastName = new SimpleStringProperty(lName);
        this.email = new SimpleStringProperty(email);
        this.priority = priority;
    }

    public Person(String fName, String lName, String email) {
        this(fName, lName, email, PriorityEnum.NORMAL);
    }

//        private List<ButtonBase> createButtons() {
//            List<ButtonBase> buttonBases = new LinkedList<>();
//            for (ActionEnum button.action : ActionEnum.values()) {
//                buttonBases.add(new Button(button.action.name()));
//            }
//            return buttonBases;
//        }

    public String getFirstName() {
        return firstName.get();
    }

    public void setFirstName(String fName) {
        firstName.set(fName);
    }

    public String getLastName() {
        return lastName.get();
    }

    public void setLastName(String fName) {
        lastName.set(fName);
    }

    public String getEmail() {
        return email.get();
    }

    public void setEmail(String fName) {
        email.set(fName);
    }

}
