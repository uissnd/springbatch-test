package com.uis.kaiylee.job;

import org.springframework.batch.core.ExitStatus;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j // log 사용을 위한 lombok 어노테이션
@RequiredArgsConstructor // 생성자 DI를 위한 lombok 어노테이션
@Configuration
public class StepNextConditionalJobConfiguration {

	private final JobBuilderFactory jobBuilderFactory; // 생성자 DI 받음
    private final StepBuilderFactory stepBuilderFactory; // 생성자 DI 받음
    
    @Bean
    public Job stepNextConditionJob() {
    	return jobBuilderFactory.get("stepNextConditionJob")
    			.start(conditionalJobStep1())
    				.on("FAILED")
    				.to(conditionalJobStep3())
    				.on("*")
    				.end()
    			.from(conditionalJobStep1())
    				.on("*")
    				.to(conditionalJobStep2())
    				.next(conditionalJobStep3())
    				.on("*")
    				.end()
    			.end()
    			.build();
    }
    
    @Bean
    public Step conditionalJobStep1() {
    	return stepBuilderFactory.get("conditionalJobStep1")
    			.tasklet((contribution, chunkContext) -> {
    				log.info("##### This is conditionalJobStep1");
    				//contribution.setExitStatus(ExitStatus.FAILED);
    				return RepeatStatus.FINISHED;
    			})
    			.build();
    }
    
    @Bean
    public Step conditionalJobStep2() {
    	return stepBuilderFactory.get("conditionalJobStep2")
    			.tasklet((contribution, chunkContext) -> {
    				log.info("##### This is conditionalJobStep2");
    				return RepeatStatus.FINISHED;
    			})
    			.build();
    }
    
    @Bean
    public Step conditionalJobStep3() {
    	return stepBuilderFactory.get("conditionalJobStep3")
    			.tasklet((contribution, chunkContext) -> {
    				log.info("##### This is conditionalJobStep3");
    				return RepeatStatus.FINISHED;
    			})
    			.build();
    }
    
}
