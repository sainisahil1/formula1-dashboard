package io.sahil.f1dashboard.DataProcessors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemProcessor;

import io.sahil.f1dashboard.Model.Constructors;
import io.sahil.f1dashboard.data.ConstructorsInput;

public class ConstructorsProcessor implements ItemProcessor<ConstructorsInput, Constructors>{

    private final Logger logger = LoggerFactory.getLogger(ConstructorsProcessor.class);

    @Override
    public Constructors process(ConstructorsInput input) throws Exception {
        
        Constructors constructor = new Constructors();

        constructor.setConstructorId(input.getConstructorId());
        constructor.setConstructorRef(input.getConstructorRef());
        constructor.setName(input.getName());
        constructor.setNationality(input.getNationality());

        logger.info("Converting (" + input + ") into (" + constructor + ")");

        return constructor;
    }
    
}
