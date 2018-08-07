import config.JavaFXApplicationContextConfig;
import controller.MainController;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import test.TestService;

public class Main extends Application {

    private ApplicationContext context;

    @Autowired
    private TestService testService;

    @FXML
    private MainController mainController;

    @Override
    public void init() {
        this.context = new AnnotationConfigApplicationContext(JavaFXApplicationContextConfig.class);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("sample.fxml"));
        fxmlLoader.setControllerFactory(context::getBean);
        Parent root = fxmlLoader.load();
        primaryStage.setTitle("Hello World");

//        TreeView<String> a = new TreeView<String>();
        BorderPane b = new BorderPane();
        Button c = new Button("Load Folder");
        c.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                testService.test();
            }
        });
        b.setTop(c);

        primaryStage.setScene(new Scene(root, 600, 400));
        primaryStage.show();
    }
}
