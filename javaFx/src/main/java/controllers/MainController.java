package controllers;

import javafx.fxml.FXML;
import javafx.scene.layout.VBox;
import lombok.Getter;
import org.springframework.stereotype.Controller;

@Controller
public class MainController {

    @FXML
    @Getter
    private ListViewController listViewController;

    @FXML
    @Getter
    private ToolBarController toolBarController;

    @FXML
    @Getter
    private VBox mainVBox;

}

