package button.action;


import button.factory.ButtonFactory;
import entity.Person;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.scene.control.ButtonBase;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableRow;
import javafx.scene.layout.HBox;
import row.ContextMenuFactory;


import java.util.List;

/**
 * Created by piotrsa on 21/08/18.
 */
public class ActionTreeCell extends TableCell<Person, Person> {

    private HBox pane;
    private List<ButtonBase> buttonBaseList;
    private ObservableList<Person> masterData;
    private FilteredList<Person> filteredList;

    public ActionTreeCell(ButtonFactory buttonFactory, ObservableList observableList, FilteredList filteredList) {
        this.masterData = observableList;
        this.filteredList = filteredList;
        this.buttonBaseList = buttonFactory.generateActionButtonList(this, masterData, filteredList);
    }

    /**
     * Places an add button's in the row only if the row is not empty.
     */
    @Override
    protected void updateItem(Person item, boolean empty) {
        super.updateItem(item, empty);
        if (!empty || item != null) {
            pane = new HBox(5);
            pane.getChildren().addAll(buttonBaseList);
            setContentDisplay(ContentDisplay.GRAPHIC_ONLY);
            setGraphic(pane);
        } else {
            pane = null;
            setContentDisplay(null);
            setGraphic(null);
        }
    }

}
