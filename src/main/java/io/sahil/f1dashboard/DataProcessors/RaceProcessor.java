package io.sahil.f1dashboard.DataProcessors;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemProcessor;

import io.sahil.f1dashboard.Model.Race;
import io.sahil.f1dashboard.data.RaceInput;

public class RaceProcessor implements ItemProcessor<RaceInput, Race> {

    private final Logger logger = LoggerFactory.getLogger(RaceProcessor.class);

    @Override
    public Race process(RaceInput arg0) throws Exception {
        
        Race race = new Race();
        race.setRaceId(arg0.getRaceId());
        race.setYear(arg0.getYear());
        race.setRound(Integer.parseInt(arg0.getRound()));
        race.setCircuitId(arg0.getCircuitId());
        race.setName(arg0.getName());
        race.setDate(getDateTime(arg0.getDate()));

        logger.info("Converting (" + arg0 + ") into (" + race + ")");

        return race;

    }

    private LocalDate getDateTime(String date){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate localDate = LocalDate.parse(date, formatter);
        return localDate;
    }
    
}
