package br.com.mystudies.quartz;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

import java.util.Date;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

public class HelloJobTest {


	@InjectMocks
	private HelloJob helloJob;


	@Mock
	private JobExecutionContext jobExecutionContext;


	@Before
	public void setUp() throws Exception {
		helloJob = new HelloJob();
		initMocks(this);
	}



	@Test
	public void test() throws JobExecutionException {

		when(jobExecutionContext.getFireTime()).thenReturn(new Date());

		helloJob.execute(jobExecutionContext);

		verify(jobExecutionContext).getFireTime();
	}


}
