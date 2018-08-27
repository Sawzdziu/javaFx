import config.ImageEnum;
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


        primaryStage.getIcons().add(new Image(ImageEnum.APP_ICON.getPath()));
        primaryStage.setScene(scene);
        primaryStage.setMinWidth(1500);
        primaryStage.setMinHeight(900);
        primaryStage.show();

//        root.requestFocus();

    }

}
