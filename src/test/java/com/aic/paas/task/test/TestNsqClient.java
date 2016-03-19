package com.aic.paas.task.test;

import com.github.brainlag.nsq.NSQConsumer;
import com.github.brainlag.nsq.NSQMessage;
import com.github.brainlag.nsq.callbacks.NSQMessageCallback;
import com.github.brainlag.nsq.lookup.DefaultNSQLookup;
import com.github.brainlag.nsq.lookup.NSQLookup;

public class TestNsqClient {
	public static void main(String[] args) {
		NSQLookup lookup = new DefaultNSQLookup();
		lookup.addLookupAddress("10.1.245.138", 4161);
		NSQConsumer consumer = new NSQConsumer(lookup, "helloworld", "aaa", new NSQMessageCallback() {
			@Override
			public void message(NSQMessage message) {
				System.out.println("received: " + new String(message.getMessage()));            
		        //now mark the message as finished.
				message.finished();
			}
		});

		consumer.start();
	}
}
