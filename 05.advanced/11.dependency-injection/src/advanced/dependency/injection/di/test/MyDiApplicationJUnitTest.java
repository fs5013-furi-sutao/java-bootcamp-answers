package advanced.dependency.injection.di.test;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import advanced.dependency.injection.di.consumer.IConsumer;
import advanced.dependency.injection.di.consumer.MyDiApplication;
import advanced.dependency.injection.di.injector.IMessageServiceInjector;
import advanced.dependency.injection.di.service.IMessageService;

public class MyDiApplicationJUnitTest {

    private IMessageServiceInjector injector;

    @Before
    public void setUp() {
        // 匿名クラスで Injector をモックする
		injector = new IMessageServiceInjector() {
			
			@Override
			public IConsumer getConsumer() {
				// メッセージ Service をモックする
				return new MyDiApplication(new IMessageService() {
					
					@Override
					public void sendMessage(String message, String receiver) {
						System.out.format(
							    "[モック] 送信先: %s, メッセージ: %s %n",
								receiver, message 
							);
						
					}
				});
			}
		};
    }

    @Test
	public void test() {
		IConsumer consumer = injector.getConsumer();
		consumer.processMessages(
				"こんにちは、山本一郎さん！", 
				"i_yamamoto@abc.com"
			);
	}
	
	@After
	public void tear(){
		injector = null;
	}
}