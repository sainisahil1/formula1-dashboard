package io.sahil.f1dashboard;


import javax.sql.DataSource;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.database.BeanPropertyItemSqlParameterSourceProvider;
import org.springframework.batch.item.database.JdbcBatchItemWriter;
import org.springframework.batch.item.database.builder.JdbcBatchItemWriterBuilder;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.builder.FlatFileItemReaderBuilder;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;

import io.sahil.f1dashboard.DataProcessors.CircuitProcessor;
import io.sahil.f1dashboard.DataProcessors.ConstructorsProcessor;
import io.sahil.f1dashboard.DataProcessors.DriverProcessor;
import io.sahil.f1dashboard.DataProcessors.RaceProcessor;
import io.sahil.f1dashboard.DataProcessors.ResultProcessor;
import io.sahil.f1dashboard.DataProcessors.SeasonProcessor;
import io.sahil.f1dashboard.DataProcessors.StatusProcessor;
import io.sahil.f1dashboard.Model.Circuit;
import io.sahil.f1dashboard.Model.Constructors;
import io.sahil.f1dashboard.Model.Driver;
import io.sahil.f1dashboard.Model.Race;
import io.sahil.f1dashboard.Model.Result;
import io.sahil.f1dashboard.Model.Season;
import io.sahil.f1dashboard.Model.Status;
import io.sahil.f1dashboard.data.CircuitInput;
import io.sahil.f1dashboard.data.ConstructorsInput;
import io.sahil.f1dashboard.data.DriverInput;
import io.sahil.f1dashboard.data.RaceInput;
import io.sahil.f1dashboard.data.ResultInput;
import io.sahil.f1dashboard.data.SeasonInput;
import io.sahil.f1dashboard.data.StatusInput;

@Configuration
@EnableBatchProcessing
public class BatchConfiguration {

  private final String baseFolder = "f1_data_csv/";
  private final String circuitFile = "circuits.csv";
  private final String constructorFile = "constructors.csv";
  private final String driverFile = "drivers.csv";
  private final String raceFile = "races.csv";
  private final String resultFile = "results.csv";
  private final String statusFile = "status.csv";
  private final String seasonFile = "seasons.csv";
  
  





  private final String[] CIRCUIT_FIELDS = new String[]{
    "circuit_id", "circuit_ref", "name", "location", "country", "lat", "lng", "alt", "url"
  };

  private final String[] CONSTRUCTOR_FIELDS = new String[]{
    "constructor_id", "constructor_ref", "name", "nationality", "url"
  };

  private final String[] DRIVER_FIELDS = new String[]{
    "driver_id", "driver_ref", "number", "code", "forename", "surname", "dob", "nationality", "url"
  };

  private final String[] RACE_FIELDS = new String[]{
    "race_id", "year", "round", "circuit_id", "name", "date", "time", "url"
  };
  
  private final String[] RESULT_FIELDS = new String[]{
    "result_id", "race_id", "driver_id", "constructor_id", "number", "grid", "position",
        "position_text", "position_order", "points", "laps", "time", "milliseconds", "fastest_lap", "rank",
        "fastest_lap_time", "fastest_lap_speed", "status_id"
  };
  
  private final String[] STATUS_FIELDS = new String[]{
    "status_id", "status"
  };
  
  private final String[] SEASONS_FIELD = new String[] {
		  "year", "url"
  };





    
  @Autowired
  public JobBuilderFactory jobBuilderFactory;

  @Autowired
  public StepBuilderFactory stepBuilderFactory;


  //-----Circuit-----

  @Bean
  public FlatFileItemReader<CircuitInput> circuitReader() {
    return new FlatFileItemReaderBuilder<CircuitInput>()
      .name("CircuitItemReader")
      .resource(new ClassPathResource(baseFolder+circuitFile))
      .delimited()
      .names(CIRCUIT_FIELDS)
      .fieldSetMapper(new BeanWrapperFieldSetMapper<CircuitInput>() {{
        setTargetType(CircuitInput.class);
      }})
      .build();
  }

  @Bean
  public CircuitProcessor circuitProcessor() {
    return new CircuitProcessor();
  }

  @Bean
  public JdbcBatchItemWriter<Circuit> circuitWriter(DataSource dataSource) {
    return new JdbcBatchItemWriterBuilder<Circuit>()
      .itemSqlParameterSourceProvider(new BeanPropertyItemSqlParameterSourceProvider<>())
      .sql("INSERT INTO circuit (circuit_id, circuit_ref, name, location, country, lat, lng) " +
       " VALUES (:circuitId, :circuitRef, :name, :location, :country, :lat, :lng)")
      .dataSource(dataSource)
      .build();
  }




  //-----Constructors-----

  @Bean
  public FlatFileItemReader<ConstructorsInput> constructorReader() {
    return new FlatFileItemReaderBuilder<ConstructorsInput>()
      .name("ConstructorItemReader")
      .resource(new ClassPathResource(baseFolder+constructorFile))
      .delimited()
      .names(CONSTRUCTOR_FIELDS)
      .fieldSetMapper(new BeanWrapperFieldSetMapper<ConstructorsInput>() {{
        setTargetType(ConstructorsInput.class);
      }})
      .build();
  }

  @Bean
  public ConstructorsProcessor constructorProcessor() {
    return new ConstructorsProcessor();
  }

  @Bean
  public JdbcBatchItemWriter<Constructors> constructorWriter(DataSource dataSource) {
    return new JdbcBatchItemWriterBuilder<Constructors>()
      .itemSqlParameterSourceProvider(new BeanPropertyItemSqlParameterSourceProvider<>())
      .sql("INSERT INTO constructors (constructor_id, constructor_ref, name, nationality) " +
       " VALUES (:constructorId, :constructorRef, :name, :nationality)")
      .dataSource(dataSource)
      .build();
  }


  
  //-----Driver-----
  @Bean
  public FlatFileItemReader<DriverInput> driverReader() {
    return new FlatFileItemReaderBuilder<DriverInput>()
      .name("DriverItemReader")
      .resource(new ClassPathResource(baseFolder+driverFile))
      .delimited()
      .names(DRIVER_FIELDS)
      .fieldSetMapper(new BeanWrapperFieldSetMapper<DriverInput>() {{
        setTargetType(DriverInput.class);
      }})
      .build();
  }

  @Bean
  public DriverProcessor driverProcessor() {
    return new DriverProcessor();
  }

  @Bean
  public JdbcBatchItemWriter<Driver> driverWriter(DataSource dataSource) {
    return new JdbcBatchItemWriterBuilder<Driver>()
      .itemSqlParameterSourceProvider(new BeanPropertyItemSqlParameterSourceProvider<>())
      .sql("INSERT INTO driver (driver_id, driver_ref, number, code, forename, surname, dob, nationality) " +
       " VALUES (:driverId, :driverRef, :number, :code, :forename, :surname, :dob, :nationality)")
      .dataSource(dataSource)
      .build();
  }





  //-----Race-----
  @Bean
  public FlatFileItemReader<RaceInput> raceReader() {
    return new FlatFileItemReaderBuilder<RaceInput>()
      .name("RaceItemReader")
      .resource(new ClassPathResource(baseFolder+raceFile))
      .delimited()
      .names(RACE_FIELDS)
      .fieldSetMapper(new BeanWrapperFieldSetMapper<RaceInput>() {{
        setTargetType(RaceInput.class);
      }})
      .build();
  }

  @Bean
  public RaceProcessor raceProcessor() {
    return new RaceProcessor();
  }

  @Bean
  public JdbcBatchItemWriter<Race> raceWriter(DataSource dataSource) {
    return new JdbcBatchItemWriterBuilder<Race>()
      .itemSqlParameterSourceProvider(new BeanPropertyItemSqlParameterSourceProvider<>())
      .sql("INSERT INTO race (race_id, year, round, circuit_id, name, date) " +
       " VALUES (:raceId, :year, :round, :circuitId, :name, :date)")
      .dataSource(dataSource)
      .build();
  }





  //-----Result-----
  @Bean
  public FlatFileItemReader<ResultInput> resultReader() {
    return new FlatFileItemReaderBuilder<ResultInput>()
      .name("ResultItemReader")
      .resource(new ClassPathResource(baseFolder+resultFile))
      .delimited()
      .names(RESULT_FIELDS)
      .fieldSetMapper(new BeanWrapperFieldSetMapper<ResultInput>() {{
        setTargetType(ResultInput.class);
      }})
      .build();
  }

  @Bean
  public ResultProcessor resultProcessor() {
    return new ResultProcessor();
  }

  @Bean
  public JdbcBatchItemWriter<Result> resultWriter(DataSource dataSource) {
    return new JdbcBatchItemWriterBuilder<Result>()
      .itemSqlParameterSourceProvider(new BeanPropertyItemSqlParameterSourceProvider<>())
      .sql("INSERT INTO result (result_id, race_id, driver_id, constructor_id, grid, position_text, position_order, points, laps, fastest_lap, fastest_lap_time, fastest_lap_speed, status_id, absolute_time) " +
       " VALUES (:resultId, :raceId, :driverId, :constructorId, :grid, :positionText, :positionOrder, :points, :laps, :fastestLap, :fastestLapTime, :fastestLapSpeed, :statusId, :absoluteTime)")
      .dataSource(dataSource)
      .build();
  }


  



  //-----Status-----
  @Bean
  public FlatFileItemReader<StatusInput> statusReader() {
    return new FlatFileItemReaderBuilder<StatusInput>()
      .name("StatusItemReader")
      .resource(new ClassPathResource(baseFolder+statusFile))
      .delimited()
      .names(STATUS_FIELDS)
      .fieldSetMapper(new BeanWrapperFieldSetMapper<StatusInput>() {{
        setTargetType(StatusInput.class);
      }})
      .build();
  }

  @Bean
  public StatusProcessor statusProcessor() {
    return new StatusProcessor();
  }

  @Bean
  public JdbcBatchItemWriter<Status> statusWriter(DataSource dataSource) {
    return new JdbcBatchItemWriterBuilder<Status>()
      .itemSqlParameterSourceProvider(new BeanPropertyItemSqlParameterSourceProvider<>())
      .sql("INSERT INTO status (status_id, status) " +
       " VALUES (:statusId, :status)")
      .dataSource(dataSource)
      .build();
  }
  
  
  
  
  //Season
  @Bean
  public FlatFileItemReader<SeasonInput> seasonReader() {
    return new FlatFileItemReaderBuilder<SeasonInput>()
      .name("SeasonItemReader")
      .resource(new ClassPathResource(baseFolder+seasonFile))
      .delimited()
      .names(SEASONS_FIELD)
      .fieldSetMapper(new BeanWrapperFieldSetMapper<SeasonInput>() {{
        setTargetType(SeasonInput.class);
      }})
      .build();
  }

  @Bean
  public SeasonProcessor seasonProcessor() {
    return new SeasonProcessor();
  }

  @Bean
  public JdbcBatchItemWriter<Season> seasonWriter(DataSource dataSource) {
    return new JdbcBatchItemWriterBuilder<Season>()
      .itemSqlParameterSourceProvider(new BeanPropertyItemSqlParameterSourceProvider<>())
      .sql("INSERT INTO season (year) " +
       " VALUES (:year)")
      .dataSource(dataSource)
      .build();
  }




//-----Job-----

@Bean
public Job importUserJob(
  JobCompletionNotificationListener listener,
  Step circuitStep,
  Step constructorStep,
  Step driverStep,
  Step raceStep,
  Step resultStep,
  Step statusStep,
  Step seasonStep
 ) {
  return jobBuilderFactory.get("importUserJob")
    .incrementer(new RunIdIncrementer())
    .listener(listener)
    .start(circuitStep)
    .next(constructorStep)
    .next(driverStep)
    .next(raceStep)
    .next(resultStep)
    .next(statusStep)
    .next(seasonStep)
    .build();
}


//circuit step
@Bean
public Step circuitStep(JdbcBatchItemWriter<Circuit> circuitWriter) {
  return stepBuilderFactory.get("circuitStep")
    .<CircuitInput, Circuit> chunk(10)
    .reader(circuitReader())
    .processor(circuitProcessor())
    .writer(circuitWriter)
    .build();
}



//constructor step
@Bean
public Step constructorStep(JdbcBatchItemWriter<Constructors> constructorWriter) {
  return stepBuilderFactory.get("constructorStep")
    .<ConstructorsInput, Constructors> chunk(10)
    .reader(constructorReader())
    .processor(constructorProcessor())
    .writer(constructorWriter)
    .build();
}


//driver step
@Bean
public Step driverStep(JdbcBatchItemWriter<Driver> driverWriter) {
  return stepBuilderFactory.get("driverStep")
    .<DriverInput, Driver> chunk(10)
    .reader(driverReader())
    .processor(driverProcessor())
    .writer(driverWriter)
    .build();
}


//race step
@Bean
public Step raceStep(JdbcBatchItemWriter<Race> raceWriter) {
  return stepBuilderFactory.get("raceStep")
    .<RaceInput, Race> chunk(10)
    .reader(raceReader())
    .processor(raceProcessor())
    .writer(raceWriter)
    .build();
}



//result step
@Bean
public Step resultStep(JdbcBatchItemWriter<Result> resultWriter) {
  return stepBuilderFactory.get("resultStep")
    .<ResultInput, Result> chunk(10)
    .reader(resultReader())
    .processor(resultProcessor())
    .writer(resultWriter)
    .build();
}


//status step
@Bean
public Step statusStep(JdbcBatchItemWriter<Status> statusWriter) {
  return stepBuilderFactory.get("statusStep")
    .<StatusInput, Status> chunk(10)
    .reader(statusReader())
    .processor(statusProcessor())
    .writer(statusWriter)
    .build();
}


//season step
@Bean
public Step seasonStep(JdbcBatchItemWriter<Season> seasonWriter) {
  return stepBuilderFactory.get("seasonStep")
    .<SeasonInput, Season> chunk(10)
    .reader(seasonReader())
    .processor(seasonProcessor())
    .writer(seasonWriter)
    .build();
}







}
