package button.factory;

import button.action.*;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBase;
import javafx.scene.control.TableCell;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


import java.util.LinkedList;
import java.util.List;

/**
 * Created by piotrsa on 21/08/18.
 */
@Component
public class ButtonFactory {

    @Autowired
    private ActionResolver actionResolver;

    public List<ButtonBase> generateActionButtonList(TableCell tableCell, ObservableList observableList, FilteredList filteredList){
        List<ButtonBase> result = new LinkedList<>();
        for(ActionEnum actionEnum : ActionEnum.values()){
            result.add(createButton(actionEnum, tableCell, observableList, filteredList));
        }
        return result;
    }

    private ButtonBase createButton(ActionEnum actionEnum, TableCell tableCell, ObservableList observableList, FilteredList filteredList){
        ButtonBase button = new Button(actionEnum.getAction());
        actionResolver.resolveAction(button, actionEnum, tableCell, observableList, filteredList);
        return button;
    }
}
