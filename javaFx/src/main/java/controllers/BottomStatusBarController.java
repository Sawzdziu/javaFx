package controllers;

import javafx.fxml.FXML;
import org.springframework.stereotype.Controller;

/**
 * Created by piotrsa on 14/08/18.
 */
@Controller
public class BottomStatusBarController {

    @FXML
    public void initialize() {
        System.out.println("BOTTOM initialize");
    }
}
