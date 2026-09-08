package userservice;

public class UserRegistration {
    private EmailService emailService = new EmailService();

    public void registerUser(String userName, String userEmail){
        System.out.println("[" + Thread.currentThread().getName() + "] saving " + userName + " to the database");
        emailService.sendEmailAsync(userEmail);
        System.out.println("[" + Thread.currentThread().getName() + "] Registration complete. Redirecting to the dashboard");
    }

}
