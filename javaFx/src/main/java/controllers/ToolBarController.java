package controllers;

import button.image.ImageService;
import config.ImageEnum;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ButtonBase;
import javafx.scene.control.TextField;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by piotrsa on 17/08/18.
 */
@Controller
public class ToolBarController implements Initializable{

    @Autowired
    private ListViewController listViewController;

    @FXML
    private TextField search;

    @FXML
    private ButtonBase addButton;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        onSearch();
        addPerson();
    }

    private void onSearch() {
        search.textProperty().addListener((o, oldVal, newVal) -> {
            listViewController.filter(newVal.toLowerCase());
        });
    }

    private void addPerson(){
        addButton.setGraphic(ImageService.prepareImage(ImageEnum.PERSON_ADD));
        addButton.setOnAction(event -> {
            System.out.println("Add person clicked!");
        });

    }
}
