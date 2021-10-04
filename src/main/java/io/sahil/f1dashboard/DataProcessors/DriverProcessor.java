package io.sahil.f1dashboard.DataProcessors;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemProcessor;

import io.sahil.f1dashboard.Model.Driver;
import io.sahil.f1dashboard.data.DriverInput;

public class DriverProcessor implements ItemProcessor<DriverInput, Driver> {

    private final Logger logger = LoggerFactory.getLogger(CircuitProcessor.class);

    @Override
    public Driver process(DriverInput arg0) throws Exception {
        
        Driver driver = new Driver();
        driver.setDriverId(arg0.getDriverId());
        driver.setDriverRef(arg0.getDriverRef());
        driver.setNumber((arg0.getNumber().equalsIgnoreCase("\\N")) ? "-" : arg0.getNumber());
        driver.setCode((arg0.getCode().equalsIgnoreCase("\\N")) ? "-" : arg0.getCode());
        driver.setForename(arg0.getForename());
        driver.setSurname(arg0.getSurname());
        driver.setDob(getDateTime(arg0.getDob()));
        driver.setNationality(arg0.getNationality());

        logger.info("Converting (" + arg0 + ") into (" + driver + ")");

        return driver;
    }

    private LocalDate getDateTime(String date){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate localDate = LocalDate.parse(date, formatter);
        return localDate;
    }
    
}
