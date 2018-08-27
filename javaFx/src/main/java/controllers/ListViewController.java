package controllers;

import button.action.ActionTreeCell;
import button.factory.ButtonFactory;
import entity.Person;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import row.ContextMenuFactory;
import row.PriorityEnum;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by piotrsa on 14/08/18.
 */
@Controller
public class ListViewController implements Initializable {

    @FXML
    @Getter
    private TableView<Person> table;

    @Autowired
    private ButtonFactory buttonFactory;

    private static final String COMPUTER_DEPARTMENT = "Computer Department";
    private static final String IT_DEPARTMENT = "IT Department";
    private static final String HR_DEPARTMENT = "HR Department";

    private ObservableList<Person> masterData;
    private FilteredList<Person> filteredList;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        set();
        System.out.println("ListView initialize");
    }

    public void set() {

        TableColumn firstNameCol = new TableColumn("First Name");
        firstNameCol.setSortable(false);
        firstNameCol.setCellValueFactory(
                new PropertyValueFactory<Person, String>("firstName"));
        firstNameCol.setCellFactory(TextFieldTableCell.forTableColumn());
        firstNameCol.setOnEditCommit(
                new EventHandler<TableColumn.CellEditEvent<Person, String>>() {
                    @Override
                    public void handle(TableColumn.CellEditEvent<Person, String> t) {
                        ((Person) t.getTableView().getItems().get(
                                t.getTablePosition().getRow())
                        ).setFirstName(t.getNewValue());
//                        table.requestFocus();
                    }
                }
        );


        TableColumn lastNameCol = new TableColumn("Last Name");
        lastNameCol.setSortable(false);
        lastNameCol.setCellValueFactory(
                new PropertyValueFactory<Person, String>("lastName"));
        lastNameCol.setCellFactory(TextFieldTableCell.forTableColumn());
        lastNameCol.setOnEditCommit(
                new EventHandler<TableColumn.CellEditEvent<Person, String>>() {
                    @Override
                    public void handle(TableColumn.CellEditEvent<Person, String> t) {
                        ((Person) t.getTableView().getItems().get(
                                t.getTablePosition().getRow())
                        ).setLastName(t.getNewValue());
//                        table.requestFocus();
                    }
                }
        );

        TableColumn emailCol = new TableColumn("Email");
        emailCol.setSortable(false);
        emailCol.setCellValueFactory(
                new PropertyValueFactory<Person, String>("email"));
        emailCol.setCellFactory(TextFieldTableCell.forTableColumn());
        emailCol.setOnEditCommit(
                new EventHandler<TableColumn.CellEditEvent<Person, String>>() {
                    @Override
                    public void handle(TableColumn.CellEditEvent<Person, String> t) {
                        ((Person) t.getTableView().getItems().get(
                                t.getTablePosition().getRow())
                        ).setEmail(t.getNewValue());
                    }
                }
        );


        TableColumn actionCol = new TableColumn("Action");
        actionCol.setSortable(false);
        actionCol.setCellFactory(param -> new ActionTreeCell(buttonFactory, masterData, filteredList));


        table.setRowFactory(param -> new ContextMenuFactory(masterData, filteredList, this));

//        //ROW FACTORY
//        table.setRowFactory(new Callback<TableView<Person>, TableRow<Person>>() {
//            @Override
//            public TableRow<Person> call(TableView<Person> tableView) {
//                final TableRow<Person> row = new TableRow<>();
//                final ContextMenuFactory contextMenu = new ContextMenuFactory();
//                final MenuItem removeMenuItem = new MenuItem("Remove");
//                removeMenuItem.setOnAction(new EventHandler<ActionEvent>() {
//                    @Override
//                    public void handle(ActionEvent event) {
//                        table.getItems().remove(row.getItem());
//                    }
//                });
//                contextMenu.getItems().add(removeMenuItem);
//                // Set context menu on row, but use a binding to make it only show for non-empty rows:
//                row.contextMenuProperty().bind(
//                        Bindings.when(row.emptyProperty())
//                                .then((ContextMenuFactory)null)
//                                .otherwise(contextMenu)
//                );
//                return row ;
//            }
//        });

        // masterData
        this.masterData = FXCollections.observableArrayList(
                new Person("Jacob", "Smith", "jacob.smith@example.com", PriorityEnum.HIGH),
                new Person("Isabella", "Johnson", "isabella.johnson@example.com", PriorityEnum.HIGH),
                new Person("Ethan", "Williams", "ethan.williams@example.com", PriorityEnum.HIGH),
                new Person("Emma", "Jones", "emma.jones@example.com"),
                new Person("Michael", "Brown", "michael.brown@example.com"),
                new Person("Test1", "Test1", "test1@example.com", PriorityEnum.HIGH),
                new Person("test3", "test3", "test3@example.com"),
                new Person("test4", "test4", "test4@example.com"));

        for (int i = 0; i < 40000; i++) {
            masterData.add(new Person(HR_DEPARTMENT, Integer.toString(i % 10), "HR 3" + i));
        }

        for (int i = 0; i < 40000; i++) {
            masterData.add(new Person(COMPUTER_DEPARTMENT, Integer.toString(i % 20), "CD 2" + i));
        }

        for (int i = 0; i < 40000; i++) {
            masterData.add(new Person(IT_DEPARTMENT, Integer.toString(i % 5), "HR 4" + i));
        }

        this.filteredList = new FilteredList<>(masterData);


        // build tree
        table.setItems(filteredList);
        table.getColumns().addAll(firstNameCol, lastNameCol, emailCol, actionCol);

        table.setEditable(true);
        table.setTableMenuButtonVisible(true);


        table.setColumnResizePolicy(TableView.UNCONSTRAINED_RESIZE_POLICY);

    }

    public void filter(String text) {
        if (!text.isEmpty()) {
            filteredList.setPredicate(user -> user.getEmail().toLowerCase()
                    .contains(text) || user.getFirstName().toLowerCase()
                    .contains(
                            text) || user.getLastName().toLowerCase().contains(text));
        } else {
            filteredList.setPredicate(x -> true);
        }
    }

    public void refreshTable() {
        this.table.getColumns().get(0).setVisible(false);
        this.table.getColumns().get(0).setVisible(true);
    }

}
