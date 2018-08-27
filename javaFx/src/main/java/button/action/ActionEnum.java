package button.action;


import lombok.Getter;

/**
 * Created by piotrsa on 20/08/18.
 */
public enum ActionEnum {

    HISTORY("History"),
    EDIT("Edit user"),
    ACTION("Action"),
    REMOVE("Remove user");

    @Getter
    private String action;

    ActionEnum(String action) {
        this.action = action;
    }
}
