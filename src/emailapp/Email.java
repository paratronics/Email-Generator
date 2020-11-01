package emailapp;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

public class Email {
    private String firstName;
    private String lastName;
    private String department;
    private String password;
    private String email;
    private String emailchecked;
    int mailboxCapacity = 500;
    int defaultPasswordLength = 8;
    private String alternateEmail;
    private String companySuffix = "google.com";
    private Set<String> nameSet = new HashSet();


    //Constructor to receive the firstName and lastName

    public Email(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
        System.out.println("Email Generated for " + firstName + " " + lastName);
        
        //Load nameSet at instantiation
        setNameSet(); 

        //Call a method asking for the department and return the department
        this.department = setDepartment();
        System.out.println("Department: " + this.department);

        //Call a method that returns a random password
        this.password = randomPassword(defaultPasswordLength);
        System.out.println("Your password is: " + this.password);

        //validate if name currently exists
        emailchecked = validateExisting(firstName.toLowerCase() + "." + lastName.toLowerCase());
        
        //Combine elements to generate email
        email = emailchecked + "@" + department.toLowerCase() +
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
    
    public Set<String> getNameSet() {
		return nameSet;
	}

	public void setNameSet() {
		this.nameSet.add("james.belema");//To be replace with dependency injection and configuration//nameSet;
	}
	
	public String validateExisting(String namecheck) {
		
		String emailName = "";
        //check if name exists already and return the name with a '-1', if it already exists.
		for (Iterator<String> it = nameSet.iterator(); it.hasNext(); ) {
	        String namechk = it.next();
	        if (namechk.equals(namecheck)) {
	        	emailName = namecheck + "-1";
	        } else {emailName = namecheck;}
	    }		 
		return emailName;
		 
	}
    
    
}

