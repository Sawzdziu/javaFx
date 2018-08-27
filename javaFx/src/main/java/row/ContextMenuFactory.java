package row;

import controllers.ListViewController;
import entity.Person;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.scene.control.*;
import javafx.util.Callback;

import java.util.stream.Stream;

import static row.PriorityEnum.*;


/**
 * Created by piotrsa on 23/08/18.
 */
public class ContextMenuFactory extends TableRow<Person> implements Callback<TableView<Person>, TableRow<Person>>{

    private ObservableList<Person> masterData;
    private FilteredList<Person> filteredList;
    ListViewController listViewController;

    public ContextMenuFactory(ObservableList<Person> masterData, FilteredList<Person> filteredList, ListViewController listViewController) {
        this.masterData = masterData;
        this.filteredList = filteredList;
        this.listViewController = listViewController;
    }

    @Override
    public TableRow<Person> call(TableView<Person> param) {
//        return final TableRow<Person> row = new TableRow<Person>(){{u}};
        return null;
    }

    @Override
    protected void updateItem(Person item, boolean empty) {
        super.updateItem(item, empty);

        if (!empty && item != null) {;
            this.setContextMenu(createMenu());
            switch (item.getPriority()) {
                case HIGH:
                    this.setStyle("-fx-background-color: lightsalmon;");
                    break;
                case NORMAL:
                    this.setStyle("");
                    break;
                case LOW:
                    this.setStyle("");
                    break;
            }
        } else {
            this.setContextMenu(null);
            this.setStyle(null);
        }

    }

    private ContextMenu createMenu() {
        return new ContextMenu(createListOfMenuItem());
    }

    private MenuItem[] createListOfMenuItem() {
        return Stream.of(values()).map(priorityEnum -> prepareMenuItem(priorityEnum)).toArray(MenuItem[]::new);
    }

    private MenuItem prepareMenuItem(PriorityEnum priorityEnum) {
        MenuItem menuItem = new MenuItem(priorityEnum.getPriority());
        menuItem.setOnAction(event -> {
            if (filteredList.getPredicate() == null) {
                masterData.get(this.getIndex()).setPriority(priorityEnum);

            } else {
                masterData.get(filteredList.getSourceIndex(this.getIndex())).setPriority(priorityEnum);
            }
            listViewController.refreshTable();
            System.out.println("Action on:" + priorityEnum.getPriority());
        });
        return menuItem;
    }

}
