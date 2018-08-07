package controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import test.TestService;

@Controller
public class MainController {

    @FXML
    private Button test;

    @Autowired
    private TestService testService;

    public void printTest(){
        System.out.println("TEST");
        testService.test();
    }


}

