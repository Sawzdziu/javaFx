package button.factory;

import button.action.ActionEnum;
import button.image.ImageService;
import config.ImageEnum;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonBase;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableCell;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import org.springframework.stereotype.Component;

/**
 * Created by piotrsa on 21/08/18.
 */
@Component
public class ActionResolver {

    public void resolveAction(ButtonBase buttonBase, ActionEnum actionEnum, TableCell tableCell, ObservableList observableList, FilteredList filteredList) {
        switch (actionEnum) {
            case EDIT:
                setEditAction(buttonBase);
                setStyle(buttonBase, ImageEnum.EDIT,"sm", "success", "logButton");
                break;
            case REMOVE:
                setRemoveAction(buttonBase, tableCell, observableList, filteredList);
                setStyle(buttonBase, ImageEnum.REMOVE,"sm", "warning", "logButton");
                break;
            case HISTORY:
                setHistoryAction(buttonBase);
                setStyle(buttonBase, ImageEnum.UPDATE,"sm", "info", "logButton");
                break;
        }
    }

    private void setEditAction(ButtonBase buttonBase) {
        buttonBase.setOnAction(event -> {
            System.out.println("Edit cilcked");
        });
    }

    /**
     * Function removes specified client from database.
     *
     * @param buttonBase
     * @param tableCell
     * @param observableList
     * @param filteredList
     */
    //TODO Write service to connect with database and remove specified client (Person person = observableList.get(tableCell.getIndex()); -> service.deletePerson(Person))
    private void setRemoveAction(ButtonBase buttonBase, TableCell tableCell, ObservableList observableList, FilteredList filteredList) {
        buttonBase.setOnAction(event -> {
            if (createAlert("Are you sure to delete this client?", Alert.AlertType.WARNING)) {
                if (filteredList.getPredicate() == null) {
                    observableList.remove(tableCell.getIndex());
                } else {
                    observableList.remove(filteredList.getSourceIndex(tableCell.getIndex()));
                }
            }
            System.out.println("Delete");
        });
    }

    private void setHistoryAction(ButtonBase buttonBase) {
        buttonBase.setOnAction(event -> {
            System.out.println("History cilcked");
        });
    }

    private boolean createAlert(String text, Alert.AlertType alertType) {
        Alert alert = new Alert(alertType, text, ButtonType.YES, ButtonType.NO, ButtonType.CANCEL);
        alert.showAndWait();
        return alert.getResult() == ButtonType.YES ? true : false;
    }

    private void setStyle(ButtonBase buttonBase, ImageEnum imageEnum, String... styles) {
        buttonBase.setGraphic(ImageService.prepareImage(imageEnum));
//        buttonBase.getStyleClass().addAll(styles);
    }

}
