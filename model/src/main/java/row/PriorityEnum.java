package row;

import lombok.Getter;

/**
 * Created by piotrsa on 23/08/18.
 */
public enum PriorityEnum {

    HIGH("High"),
    NORMAL("Normal"),
    LOW("Low");

    @Getter
    private String priority;

    PriorityEnum(String priority) {
        this.priority = priority;
    }
}
