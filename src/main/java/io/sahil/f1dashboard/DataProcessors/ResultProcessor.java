package io.sahil.f1dashboard.DataProcessors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemProcessor;

import io.sahil.f1dashboard.Model.Result;
import io.sahil.f1dashboard.data.ResultInput;

public class ResultProcessor implements ItemProcessor<ResultInput, Result> {

    private final Logger logger = LoggerFactory.getLogger(ResultProcessor.class);

    @Override
    public Result process(ResultInput arg0) throws Exception {
        
        Result result = new Result();

        result.setResultId(arg0.getResultId());

        result.setRaceId(arg0.getRaceId());
        
        result.setDriverId(arg0.getDriverId());
        
        result.setConstructorId(arg0.getConstructorId());
        
        result.setGrid(Integer.parseInt(arg0.getGrid()));
        
        result.setPositionText(arg0.getPositionText());
        
        result.setPositionOrder(Integer.parseInt(arg0.getPositionOrder()));
        
        result.setPoints(arg0.getPoints());
        
        result.setLaps(Integer.parseInt(arg0.getLaps()));

        result.setFastestLap((arg0.getFastestLap().equalsIgnoreCase("\\N") ? "-" : arg0.getFastestLap()));
        
        result.setFastestLapTime((arg0.getFastestLapTime().equalsIgnoreCase("\\N") ? "-" : arg0.getFastestLapTime()));
        
        result.setFastestLapSpeed((arg0.getFastestLapSpeed().equalsIgnoreCase("\\N") ? "-" : arg0.getFastestLapSpeed()));
        
        result.setStatusId(arg0.getStatusId());
        
        result.setAbsoluteTime(convertToAbsoluteTime(arg0.getMilliseconds()));
        

        logger.info("Converting (" + arg0 + ") into (" + result + ")");


        return result;

    }

    private String convertToAbsoluteTime(String millis){
        if(millis.equalsIgnoreCase("\\N")){
            return "";
        } else {
            long millisLong = Long.parseLong(millis);
            long milliSec = millisLong % 1000;
            millisLong = millisLong/1000; // total in sec
            long sec = millisLong % 60;
            millisLong = millisLong/60; //total in min
            long min = millisLong % 60;
            long hr = millisLong/60; //total in hr


            return hr + ":" + min + ":" + sec + "." + milliSec;
        }
    }
    
}
