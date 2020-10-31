package emailapp;

import java.util.Scanner;

public class Email {
    private String firstName;
    private String lastName;
    private String department;
    private String password;
    private String email;
    int mailboxCapacity = 500;
    int defaultPasswordLength = 8;
    private String alternateEmail;
    private String companySuffix = "google.com";

    //Constructor to receive the firstName and lastName

    public Email(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
        System.out.println("Email Generated for " + firstName + " " + lastName);

        //Call a method asking for the department and return the department
        this.department = setDepartment();
        System.out.println("Department: " + this.department);

        //Call a method that returns a random password
        this.password = randomPassword(defaultPasswordLength);
        System.out.println("Your password is: " + this.password);

        //Combine elements to generate email
        email = firstName.toLowerCase() + "." + lastName.toLowerCase() + "@" + department.toLowerCase() +
                "." + companySuffix;
        System.out.println("Your email is: " + email);

    }

    //Ask for the Department

    public String setDepartment(){
        System.out.println("DEPARTMENT CODE:\n1 for Sales\n2 for Develoment\n3 for Accounting\n4 " +
                "for none");
        System.out.println("Enter department code:");
        Scanner input = new Scanner(System.in);
        int depCode = input.nextInt();
        if (depCode==1){return "Marketing";}
        else if (depCode==2){return "Development";}
        else if (depCode==3){return "Design";}
        else return "";
    }

    //Generate a Random password
    private String randomPassword(int length){
        String passwordSet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ123456789!@#$%";
        char[] password = new char[length];
        for (int i=0; i<length; i++){
            int rand = (int) (Math.random() * passwordSet.length());
            password[i] = passwordSet.charAt(rand);
        }
        return new String (password);
    }

    //Set Mailbox Capacity
    public void setMailboxCapacity(int capacity){
        this.mailboxCapacity  = capacity;
    }
    //Set Alternate Email
    public void setAlternateEmail(String altEmail){
        this.alternateEmail = altEmail;
    }
     //Change Password
    public void changePassword(String password){
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public int getMailboxCapacity() {
        return mailboxCapacity;
    }

    public String getAlternateEmail() {
        return alternateEmail;
    }
}
