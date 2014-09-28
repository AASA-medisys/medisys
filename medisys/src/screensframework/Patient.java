/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package screensframework;

/**
 *
 * @author mew
 */
public class Patient {

    private String firstName;
    private String lastName;
    private String address;

    /**
     * Constructs an Employee with the given details.
     */
    public Patient(String firstName, String lastName, String address) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
    }
    
    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getAddress() {
        return address;
    }
}
