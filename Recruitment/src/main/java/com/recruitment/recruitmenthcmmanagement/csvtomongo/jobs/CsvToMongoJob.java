package com.recruitment.recruitmenthcmmanagement.csvtomongo.jobs;

import com.recruitment.recruitmenthcmmanagement.entities.Application;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.data.MongoItemWriter;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.data.mongodb.core.MongoTemplate;


@EnableBatchProcessing
@Configuration
public class CsvToMongoJob {


    @Autowired
    JobBuilderFactory jobBuilderFactory;


    @Autowired
    StepBuilderFactory stepBuilderFactory;


    @Autowired
    MongoTemplate mongoTemplate;

    @Value("file:D:/VMINE/pfe/Manzello - HR/Development/Sprints/Sprint2/src/main/resources/Classeur1.csv")
    private Resource[] inputResources;

    public CsvToMongoJob(JobBuilderFactory jobBuilderFactory, StepBuilderFactory stepBuilderFactory) {
        this.jobBuilderFactory = jobBuilderFactory;
        this.stepBuilderFactory = stepBuilderFactory;
    }


    @Bean
    public Job readCSVFile()  {

        System.out.println("readCSVFile");
        return jobBuilderFactory.get("readCSVFile").incrementer(new RunIdIncrementer()).start(step1()).next(step2())
                .build();
    }

    @Bean
    public Step step1() {
        System.out.println("step1");

        return stepBuilderFactory.get("step1").<Application, Application>chunk(10).reader(reader())
                .writer(writer()).build();
    }

    @Bean
    public Step step2() {
        FileDeletingTasklet task = new FileDeletingTasklet();
        task.setResources(inputResources);
        return stepBuilderFactory.get("step2")
                .tasklet(task)
                .build();
    }


    @Bean
    @StepScope
    public FlatFileItemReader<Application> reader()  {

        System.out.println("reader");
        FlatFileItemReader<Application> reader = new FlatFileItemReader<>();
        reader.setResource(new ClassPathResource("Classeur1.csv"));
        reader.setLinesToSkip(1);
        reader.setLineMapper(new DefaultLineMapper<>() {{
            setLineTokenizer(new DelimitedLineTokenizer() {{

                setNames("quality","cin", "firstName","lastName","date","gender","city","email","phoneNumber","diploma","university","domain","obtainedDate","seniority","curriculumVitae","status");
               // setNames(new String[]{"quality","cin", "firstName","lastName","date","gender","city","email","phoneNumber","diploma","university","domain","obtainedDate","seniority","curriculumVitae","status"});
            }});
            setFieldSetMapper(new BeanWrapperFieldSetMapper<>() {{
                setTargetType(Application.class);
            }});
        }});
       // logger.info(reader);
        return reader;
    }

    @Bean
    public MongoItemWriter<Application> writer() {
        System.out.println("writer");
        MongoItemWriter<Application> writer = new MongoItemWriter<>();
        System.out.println("writer"+writer);
        writer.setTemplate(mongoTemplate);
        writer.setCollection("application_hr");
        return writer;
    }

}
