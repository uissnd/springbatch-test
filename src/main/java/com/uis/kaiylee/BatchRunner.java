package com.uis.kaiylee;

import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import com.uis.kaiylee.db.JdbcBatchItemWriterJobConfiguration;

@EnableScheduling
@EnableBatchProcessing
@SpringBootApplication
public class BatchRunner {
	
	/*
	 * @Scheduled(cron = "0 0/1 * * * *") public void runJob() {
	 * SpringApplication.run(BatchRunner.class); }
	 */
}
