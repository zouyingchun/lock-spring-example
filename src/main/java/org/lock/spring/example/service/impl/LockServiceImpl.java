package org.lock.spring.example.service.impl;


import org.lock.spring.annotation.Lock;
import org.lock.spring.example.service.LockService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service("lockService")
public class LockServiceImpl implements LockService{
	private Logger logger = LoggerFactory.getLogger(LockServiceImpl.class);
	
	@Override
	@Lock(name="test",lockTime=60000)
	public void testLock() {
		logger.debug("start to test lock");
		
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			logger.info(e.getMessage(),e);
		}
		logger.debug("end to test lock");
	}

	@Override
	@Lock(name="test",lockTime=60000)
	public void testLock2() {
		logger.debug("start to test lock"+2);
		
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			logger.info(e.getMessage(),e);
		}
		logger.debug("end to test lock"+2);
		
	}
	
}
