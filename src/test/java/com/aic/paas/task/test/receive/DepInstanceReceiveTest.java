package com.aic.paas.task.test.receive;

import org.walkmod.nsq.Message;
import org.walkmod.nsq.example.PrintReader;
import org.walkmod.nsq.exceptions.NSQException;
import org.walkmod.nsq.lookupd.BasicLookupd;
import org.walkmod.nsq.syncresponse.SyncResponseHandler;
import org.walkmod.nsq.syncresponse.SyncResponseReader;

public class DepInstanceReceiveTest {
	
	
	
//	public static void main(String[] args) throws IOException {
//		System.out.println("=====================");
//		
//		NSQLookup lookup = new DefaultNSQLookup();
//		lookup.addLookupAddress("10.1.245.138", 4161);
//		
//		System.out.println("=====================");
//		
//		NSQConsumer consumer = new NSQConsumer(lookup,"test","aaa",new NSQMessageCallback() {
//			
//			@Override
//			public void message(NSQMessage message) {
//				// TODO Auto-generated method stub
//				System.out.println("message:"+new String(message.getMessage()));
//				 System.out.println("received: " + message); 
//				 message.finished();
//			}
//		});
//				
//		consumer.start();
//		
//	}

	
	
	
	public boolean handleMessage(Message msg) throws NSQException {
		System.out.println("Received: " + new String(msg.getBody()));
		return true;
	}

	public static void main(String... args){
		System.out.println("=================");
		SyncResponseHandler sh = new PrintReader();
		SyncResponseReader reader = new SyncResponseReader("test", "aaa", sh);
//		try {
//			reader.connectToNsqd("bitly.org", 4150);
//		} catch (NSQException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		System.out.println("=================1111111111111");
		reader.addLookupd(new BasicLookupd("http://10.1.245.138:4161"));
		System.out.println("=================222222222222222");
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("=================3333333333333333333");
	}
}
