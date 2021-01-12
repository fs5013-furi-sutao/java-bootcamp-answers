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
        //mock the injector with anonymous class
		injector = new IMessageServiceInjector() {
			
			@Override
			public IConsumer getConsumer() {
				//mock the message service
				return new MyDiApplication(new IMessageService() {
					
					@Override
					public void sendMessage(String msg, String rec) {
						System.out.println("Mock Message Service implementation");
						
					}
				});
			}
		};
    }

    @Test
	public void test() {
		IConsumer consumer = injector.getConsumer();
		consumer.processMessages("Hi Pankaj", "pankaj@abc.com");
	}
	
	@After
	public void tear(){
		injector = null;
	}
}