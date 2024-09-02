package za.ac.cput.factory;

/*
Aphelele Zimkhita Joka
 */

import za.ac.cput.domain.Contact;
import za.ac.cput.domain.Employee;
import za.ac.cput.util.Helper;

public class EmployeeFactory {
    public static Employee buildEmployee(String employeeID, String firstName, String lastName, String userName
                                         ,String jobPosition,String password, String email, String mobileNumber, String workTelephone) {
        if (Helper.isNullOrEmpty(employeeID) || Helper.isNullOrEmpty(firstName)
                || Helper.isNullOrEmpty(lastName) || Helper.isNullOrEmpty(userName)
                || Helper.isNullOrEmpty(jobPosition) || Helper.isNullOrEmpty(password)) {
            return null;
        }

        Contact contact = ContactFactory.buildContact(email, mobileNumber, workTelephone);

        if (contact == null) {
            return null;
        }

        return new Employee.Builder().setEmployeeID(employeeID)
                .setFirstName(firstName)
                .setLastName(lastName)
                .setUserName(userName)
                .setJobPosition(jobPosition)
                .setPassword(password)
                .setContact(contact)
                .build();
    }
}

