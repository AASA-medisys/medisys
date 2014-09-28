// Login Page Screen

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
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class Screen1Controller implements Initializable, ControlledScreen {

    ScreensController myController;
    
    @FXML
    private Label label;
    public TextField username;
    public PasswordField password;
    public String usernametext;
    public String passwordtext;
    
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

    // Login method
    public void LoginUser() throws SQLException {
        System.out.println("Login User Invoked");
        username.getText();
        passwordtext = password.getText();
        
        System.out.println(usernametext+" "+passwordtext);
        
        openConnection();
        
        String queryString = "SELECT username, password FROM USERS WHERE username='" + usernametext +"'" ;

        ps = conn.prepareStatement(queryString);

        results = ps.executeQuery();

        // check if user exist
        if (results.next()) {
            System.out.println("user exist");
            String pass = results.getString("password");

            if (pass.equals(passwordtext)) {
                
               System.out.println("Password correct");
               label.setText("Login Successful!");
               myController.setScreen(ScreensFramework.screen2ID);
               
            }
            
            if (!pass.equals(passwordtext)) {
                label.setText("Incorrect Password");
            }
            
        }else{
            System.out.println("user does not exist");
            label.setText("Incorrect Username");
        } 
    results.close();
    conn.close();
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
    
}
