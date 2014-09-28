// Clinical Measures Page
// INFS3605 AASA Technology


package screensframework;

import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.DatePicker;

public class Screen5Controller implements Initializable , ControlledScreen {

    ScreensController myController;
 
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // to do
    }
    
    public void setScreenParent(ScreensController screenParent){
        myController = screenParent;
    }

    @FXML
    public void selectDate () {
        // Create the DatePicker.
        DatePicker datePicker = new DatePicker();

        // Add some action (in Java 8 lambda syntax style).
        //datePicker.setOnAction(event -> {
        LocalDate date = datePicker.getValue();
        System.out.println("Selected date: " + date);
        //} 
    }
    
    @FXML
    private void goToScreen1(ActionEvent event){
       myController.setScreen(ScreensFramework.screen1ID);
    }

    @FXML
    private void goToScreen2(ActionEvent event){
       myController.setScreen(ScreensFramework.screen3ID);
    }
    
    @FXML
    private void goToScreen3(ActionEvent event){
       myController.setScreen(ScreensFramework.screen3ID);
    }

    @FXML
    private void goToScreen4(ActionEvent event){
       myController.setScreen(ScreensFramework.screen4ID);
    }

    @FXML
    private void goToScreen5(ActionEvent event){
       myController.setScreen(ScreensFramework.screen5ID);
    }

}

