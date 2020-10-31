package emailapp;

public class EmailApp {
    public static void main(String[] args) {
        Email email = new Email("James","Belema");

        email.setAlternateEmail("androidteam@google.com");
        System.out.println("Your alternate email is: " + email.getAlternateEmail());
    }
}
