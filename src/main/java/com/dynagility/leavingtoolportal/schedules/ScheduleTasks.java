package com.dynagility.leavingtoolportal.schedules;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class ScheduleTasks {

	private static final SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
//
//	@Scheduled(initialDelay = 1000, fixedRate = 10000)
//	public void performTask() {
//
//		System.out.println("Run Schedule at " + dateFormat.format(new Date()));
//
//	}

	@Scheduled(cron = "1 * * * * ?")
	public void scheduleTasks() {

		System.out.println("Run Schedule at " + dateFormat.format(new Date()));
	}

}
