package advanced.dependency.injection.di.service;

public class SMSServiceImpl implements IMessageService {

    @Override
    public void sendMessage(String message, String reciever) {
        // SMS 送信のビジネスロジック
        System.out.format(
                "SMS sent to %s with Message= %s %n",
                reciever, message 
            );
    }
}
