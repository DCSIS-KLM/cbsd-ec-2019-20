package org.amdatu.tutorial.todo.reminders;

import java.util.Dictionary;

import org.amdatu.scheduling.annotations.Cron;
import org.amdatu.scheduling.annotations.RepeatForever;
import org.apache.felix.dm.annotation.api.Component;
import org.apache.felix.dm.annotation.api.ConfigurationDependency;
import org.osgi.service.cm.ConfigurationException;
import org.osgi.service.cm.ManagedService;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

@Component
@RepeatForever
@Cron("0/5 * * * * ?")
public class Reminder implements Job, ManagedService {
	private String m_email;
	
	@Override
	public void execute(JobExecutionContext arg0) throws JobExecutionException {
		System.out.println("Sending reminders to test: " + m_email);
	}

	@Override
	@ConfigurationDependency(pid="org.amdatu.tutorial.todo.reminder")
	public void updated(Dictionary<String, ?> properties) throws ConfigurationException {
		if(properties != null) {
			String email = (String)properties.get("email");
			if(email != null) {
				m_email = email;
			} else{
				throw new ConfigurationException("email", "Required");
			}
		}
	}	
}