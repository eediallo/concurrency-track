package userservice;

public class EmailService {
    public void sendEmailAsync(String userEmail){

        Thread emailThread = new Thread(() -> {
            try{
                System.out.println("[ " + Thread.currentThread().getName() + "] connecting to the mail server");
                Thread.sleep(2000);
                System.out.println("[ " + Thread.currentThread().getName() + "] Email Successfully sent to " + userEmail);
            }catch(InterruptedException e){
                Thread.currentThread().interrupt();
            }
        });

        emailThread.start();
    }
}
