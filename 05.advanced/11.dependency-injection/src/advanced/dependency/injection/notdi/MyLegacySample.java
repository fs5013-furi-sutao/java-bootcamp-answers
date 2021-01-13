package advanced.dependency.injection.notdi;

public class MyLegacySample {
    public static void main(String[] args) {
        
    EmailService service = new EmailService();
		MyApplication app = new MyApplication(service);
		app.processMessages(
                "こんにちは、山本一郎さん！", 
                "i_yamamoto@abc.com"
            );
	}
}
