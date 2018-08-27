package config;

import lombok.Getter;

/**
 * Created by piotrsa on 22/08/18.
 */
public enum ImageEnum {

    APP_ICON("/images/account_balance.png"),
    EDIT("/images/edit.png"),
    PERSON_ADD("/images/person_add.png"),
    REMOVE("/images/remove.png"),
    UPDATE("/images/update.png");

    @Getter
    private String path;

    ImageEnum(String path) {
        this.path = path;
    }

}
