package sample;

public class Client {
    private EmailService emailService;

    /**
     * Constructor for client
     * @param emailService
     */
    public Client(EmailService emailService) {
        this.emailService = emailService;
    }

    public void printEmails() {
        emailService.print();
    }
}
