// Landing page
// Landing Page
// INFS 3605 AASA Technology

package screensframework;

import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class Screen2Controller implements Initializable , ControlledScreen  {

    ScreensController myController;
    
    // Screen1Controller stage2 = new Screen1Controller();

    @FXML
    public TextField nameTextField;
    public String firstName;
    public javafx.scene.control.Button closeButton;

    
    PreparedStatement insertPatient = null;
    
    // declare variables
    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet results = null;
    String url = "jdbc:oracle:thin:z3417581/w8uhawAs@sage.business.unsw.edu.au:1521:orcl01";

        // open connection to database method
        public void openConnection() {
            try {
                conn = DriverManager.getConnection(url);
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    
        // close connection to database method
        public void closeConnection() {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        }

    public void insertPatient() {
        
    firstName = nameTextField.getText();
        
        openConnection();
        System.out.println("TEST");
        try {
            insertPatient = conn.prepareStatement("insert into patients (FIRST_NAME) values (?)");
            insertPatient.setString(1, firstName);
            //insertPatient.setString(2, toInsert.getLastName());
            //insertPatient.setString(3, toInsert.getAddress());
            insertPatient.executeUpdate();

        } catch (SQLException ex) {
                ex.printStackTrace();
        }
        closeConnection();
    }     
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }
    
    public void setScreenParent(ScreensController screenParent){
        myController = screenParent;
    }

    @FXML
    private void closeButtonAction(){
        // get a handle to the stage
        Stage stage = (Stage) closeButton.getScene().getWindow();
        // do what you have to do
        stage.close();
    }

    @FXML
    private void goToScreen1(ActionEvent event){
       myController.setScreen(ScreensFramework.screen1ID);
    }

    @FXML
    private void goToScreen2(ActionEvent event){
       myController.setScreen(ScreensFramework.screen2ID);
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
