package br.com.hidarisoft.ftdb.configs;

import org.springframework.batch.core.*;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.batch.core.repository.JobRestartException;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ImportLauncher {
    SimpleDateFormat sdf = null;

    private JobLauncher jobLauncher;
    private Job job;
    private String dateFormat;

    public void launch(){
        sdf = new SimpleDateFormat(getDateFormat());

        long ct = System.currentTimeMillis();

        System.out.println("Launch Basic() --- DateFormat: " + getDateFormat() + " ct: " + sdf.format(ct));

        JobParametersBuilder parametersBuilder = new JobParametersBuilder();
        parametersBuilder.addString("jobName", "basicJob");
        parametersBuilder.addDate("date", new Date());
        parametersBuilder.addLong("time", ct);
        JobParameters jobParameters = parametersBuilder.toJobParameters();

        try {
            JobExecution execution = jobLauncher.run(job, jobParameters);
            System.out.println("Exit Status Basic: " + execution.getStatus());

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Unable Execute Job");
        }
    }


    public SimpleDateFormat getSdf() {
        return sdf;
    }

    public void setSdf(SimpleDateFormat sdf) {
        this.sdf = sdf;
    }

    public JobLauncher getJobLauncher() {
        return jobLauncher;
    }

    public void setJobLauncher(JobLauncher jobLauncher) {
        this.jobLauncher = jobLauncher;
    }

    public Job getJob() {
        return job;
    }

    public void setJob(Job job) {
        this.job = job;
    }

    public String getDateFormat() {
        return dateFormat;
    }

    public void setDateFormat(String dateFormat) {
        this.dateFormat = dateFormat;
    }
}
