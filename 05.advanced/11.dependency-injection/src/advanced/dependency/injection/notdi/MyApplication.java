package advanced.dependency.injection.notdi;

public class MyApplication {

    private EmailService email = null;

    public MyApplication(EmailService service) {
        this.email = service;
    }

    public void processMessages(String message, String receiver) {
        // message のバリデーションやロジック操作などを行う
        this.email.sendEmail(message, receiver);
    }
}
