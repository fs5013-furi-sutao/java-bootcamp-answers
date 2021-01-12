package advanced.dependency.injection.di;

import advanced.dependency.injection.di.consumer.IConsumer;
import advanced.dependency.injection.di.injector.EmailServiceInjector;
import advanced.dependency.injection.di.injector.IMessageServiceInjector;
import advanced.dependency.injection.di.injector.SMSServiceInjector;

public class MyMessageDiTest {
    public static void main(String[] args) {
        String message  = "Hi Pankaj";
        String email = "panka@abc.com";
        String phone = "";

        IMessageServiceInjector injector = null;
        IConsumer app = null;

        injector = new EmailServiceInjector();
        app = injector.getConsumer();
        app.processMessages(message, email);

        injector = new SMSServiceInjector();
        app = injector.getConsumer();
        app.processMessages(message, phone);

    }
}
