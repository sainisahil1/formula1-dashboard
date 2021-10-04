package io.sahil.f1dashboard.DataProcessors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemProcessor;

import io.sahil.f1dashboard.Model.Status;
import io.sahil.f1dashboard.data.StatusInput;

public class StatusProcessor implements ItemProcessor<StatusInput, Status> {

    private final Logger logger = LoggerFactory.getLogger(StatusProcessor.class);

    @Override
    public Status process(StatusInput arg0) throws Exception {
        Status status = new Status();
        status.setStatus(arg0.getStatus());
        status.setStatusId(arg0.getStatusId());

        logger.info("Converting (" + arg0 + ") into (" + status + ")");

        return status;
    }
    



}
