package advanced.dependency.injection.di.service;

public class EmailServiceImpl implements IMessageService {
    
    @Override
    public void sendMessage(String message, String reciever) {
        // メール送信のビジネスロジック
        System.out.format(
                "Email sent to %s with Message= %s %n",
                reciever, message 
            );
    }
 }
