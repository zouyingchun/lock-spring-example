package org.lock.spring.example.service;

import java.util.concurrent.CountDownLatch;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class LockServiceTest extends BaseTest{
	@Autowired
	private LockService lockService;
	private CountDownLatch countDownLatch= new CountDownLatch(30);
	private int pos = 0;
	
	@Test
	public void testGetLock(){
		for(int i = 0 ;i<30;i++){
			pos = i;
			new Thread(){
				@Override
				public void run() {
					try{
						if(pos%2 ==0){
							lockService.testLock();
						}else{
							lockService.testLock2();
						}
					}catch(Exception e){
						
					}finally{
						countDownLatch.countDown();
					}
				}
			}.start();
		}
		try {
			countDownLatch.await();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
