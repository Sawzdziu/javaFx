import config.JavaFXApplicationContextConfig;
import controllers.MainController;
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main extends Application {

    private ApplicationContext context;

    public static final String APP_ICON_PATH = "/images/account_balance.png";

    @FXML
    private MainController mainController;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void init() {
        this.context = new AnnotationConfigApplicationContext(JavaFXApplicationContextConfig.class);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("views/mainWindow.fxml"));
        fxmlLoader.setControllerFactory(context::getBean);
        Parent root = fxmlLoader.load();
        primaryStage.setTitle("ManClient");

        Scene scene = new Scene(root);
        scene.getStylesheets().add(Main.class.getResource("/css/styles.css").toExternalForm());


        primaryStage.getIcons().add(new Image(this.getClass().getResourceAsStream(APP_ICON_PATH)));
        primaryStage.setScene(scene);
        primaryStage.setMinWidth(1500);
        primaryStage.setMinHeight(900);
        primaryStage.show();
//        root.requestFocus();

    }

}
//import javafx.application.Application;
//import javafx.beans.property.SimpleStringProperty;
//import javafx.collections.FXCollections;
//import javafx.collections.ObservableList;
//import javafx.event.ActionEvent;
//import javafx.event.EventHandler;
//import javafx.geometry.Insets;
//import javafx.scene.Group;
//import javafx.scene.Scene;
//import javafx.scene.control.Button;
//import javafx.scene.control.Label;
//import javafx.scene.control.TableColumn;
//import javafx.scene.control.TableColumn.CellEditEvent;
//import javafx.scene.control.TableView;
//import javafx.scene.control.TextField;
//import javafx.scene.control.cell.PropertyValueFactory;
//import javafx.scene.control.cell.TextFieldTableCell;
//import javafx.scene.layout.HBox;
//import javafx.scene.layout.VBox;
//import javafx.scene.text.Font;
//import javafx.stage.Stage;
//
//public class Main extends Application {
//
//    private TableView<Person> table = new TableView<Person>();
//    private final ObservableList<Person> data =
//            FXCollections.observableArrayList(
//                    new Person("Jacob", "Smith", "jacob.smith@example.com"),
//                    new Person("Isabella", "Johnson", "isabella.johnson@example.com"),
//                    new Person("Ethan", "Williams", "ethan.williams@example.com"),
//                    new Person("Emma", "Jones", "emma.jones@example.com"),
//                    new Person("Michael", "Brown", "michael.brown@example.com"));
//    final HBox hb = new HBox();
//
//    public static void main(String[] args) {
//        launch(args);
//    }
//
//    @Override
//    public void start(Stage stage) {
//        Scene scene = new Scene(new Group());
//        stage.setTitle("Table View Sample");
//        stage.setWidth(450);
//        stage.setHeight(550);
//
//        final Label label = new Label("Address Book");
//        label.setFont(new Font("Arial", 20));
//
//        table.setEditable(true);
//
//        TableColumn firstNameCol = new TableColumn("First Name");
//        firstNameCol.setMinWidth(100);
//        firstNameCol.setCellValueFactory(
//                new PropertyValueFactory<Person, String>("firstName"));
//        firstNameCol.setCellFactory(TextFieldTableCell.forTableColumn());
//        firstNameCol.setOnEditCommit(
//                new EventHandler<CellEditEvent<Person, String>>() {
//                    @Override
//                    public void handle(CellEditEvent<Person, String> t) {
//                        ((Person) t.getTableView().getItems().get(
//                                t.getTablePosition().getRow())
//                        ).setFirstName(t.getNewValue());
//                    }
//                }
//        );
//
//
//        TableColumn lastNameCol = new TableColumn("Last Name");
//        lastNameCol.setMinWidth(100);
//        lastNameCol.setCellValueFactory(
//                new PropertyValueFactory<Person, String>("lastName"));
//        lastNameCol.setCellFactory(TextFieldTableCell.forTableColumn());
//        lastNameCol.setOnEditCommit(
//                new EventHandler<CellEditEvent<Person, String>>() {
//                    @Override
//                    public void handle(CellEditEvent<Person, String> t) {
//                        ((Person) t.getTableView().getItems().get(
//                                t.getTablePosition().getRow())
//                        ).setLastName(t.getNewValue());
//                    }
//                }
//        );
//
//        TableColumn emailCol = new TableColumn("Email");
//        emailCol.setMinWidth(200);
//        emailCol.setCellValueFactory(
//                new PropertyValueFactory<Person, String>("email"));
//        emailCol.setCellFactory(TextFieldTableCell.forTableColumn());
//        emailCol.setOnEditCommit(
//                new EventHandler<CellEditEvent<Person, String>>() {
//                    @Override
//                    public void handle(CellEditEvent<Person, String> t) {
//                        ((Person) t.getTableView().getItems().get(
//                                t.getTablePosition().getRow())
//                        ).setEmail(t.getNewValue());
//                    }
//                }
//        );
//
//        table.setItems(data);
//        table.getColumns().addAll(firstNameCol, lastNameCol, emailCol);
//
//        final TextField addFirstName = new TextField();
//        addFirstName.setPromptText("First Name");
//        addFirstName.setMaxWidth(firstNameCol.getPrefWidth());
//        final TextField addLastName = new TextField();
//        addLastName.setMaxWidth(lastNameCol.getPrefWidth());
//        addLastName.setPromptText("Last Name");
//        final TextField addEmail = new TextField();
//        addEmail.setMaxWidth(emailCol.getPrefWidth());
//        addEmail.setPromptText("Email");
//
//        final Button addButton = new Button("Add");
//        addButton.setOnAction(new EventHandler<ActionEvent>() {
//            @Override
//            public void handle(ActionEvent e) {
//                data.add(new Person(
//                        addFirstName.getText(),
//                        addLastName.getText(),
//                        addEmail.getText()));
//                addFirstName.clear();
//                addLastName.clear();
//                addEmail.clear();
//            }
//        });
//
//        hb.getChildren().addAll(addFirstName, addLastName, addEmail, addButton);
//        hb.setSpacing(3);
//
//        final VBox vbox = new VBox();
//        vbox.setSpacing(5);
//        vbox.setPadding(new Insets(10, 0, 0, 10));
//        vbox.getChildren().addAll(label, table, hb);
//
//        ((Group) scene.getRoot()).getChildren().addAll(vbox);
//
//        stage.setScene(scene);
//        stage.show();
//    }
//
//    public static class Person {
//
//        private final SimpleStringProperty firstName;
//        private final SimpleStringProperty lastName;
//        private final SimpleStringProperty email;
//
//        private Person(String fName, String lName, String email) {
//            this.firstName = new SimpleStringProperty(fName);
//            this.lastName = new SimpleStringProperty(lName);
//            this.email = new SimpleStringProperty(email);
//        }
//
//        public String getFirstName() {
//            return firstName.get();
//        }
//
//        public void setFirstName(String fName) {
//            firstName.set(fName);
//        }
//
//        public String getLastName() {
//            return lastName.get();
//        }
//
//        public void setLastName(String fName) {
//            lastName.set(fName);
//        }
//
//        public String getEmail() {
//            return email.get();
//        }
//
//        public void setEmail(String fName) {
//            email.set(fName);
//        }
//    }
//}
