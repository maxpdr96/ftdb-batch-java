package br.com.hidarisoft.ftdb.listeners;

import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobExecutionListener;

public class LogFileJobListener implements JobExecutionListener {
    @Override
    public void beforeJob(JobExecution jobExecution) {
        System.out.println("=========== BEFORE JOB EXECUTION ===========");
    }

    @Override
    public void afterJob(JobExecution jobExecution) {
        System.out.println("AFTER JOB EXECUTION ====== ID: "+ jobExecution.getId() + " STATUS: " + jobExecution.getStatus());
    }
}
