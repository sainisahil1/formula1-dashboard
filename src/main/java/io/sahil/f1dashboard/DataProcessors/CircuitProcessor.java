package io.sahil.f1dashboard.DataProcessors;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.sahil.f1dashboard.Model.Circuit;
import io.sahil.f1dashboard.data.CircuitInput;

public class CircuitProcessor implements org.springframework.batch.item.ItemProcessor<CircuitInput, Circuit> {

    private final Logger logger = LoggerFactory.getLogger(CircuitProcessor.class);

    @Override
    public Circuit process(CircuitInput input) throws Exception {
        
        Circuit circuit = new Circuit();
        circuit.setCircuitId(input.getCircuitId());
        circuit.setCircuitRef(input.getCircuitRef());
        circuit.setName(input.getName());
        circuit.setLocation(input.getLocation());
        circuit.setCountry(input.getCountry());
        circuit.setLat(input.getLat());
        circuit.setLng((input.getLng()));

        logger.info("Converting (" + input + ") into (" + circuit + ")");

        return circuit;
    }




    
}
