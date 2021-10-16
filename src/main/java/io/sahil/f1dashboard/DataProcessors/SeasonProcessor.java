package io.sahil.f1dashboard.DataProcessors;

import org.springframework.batch.item.ItemProcessor;

import io.sahil.f1dashboard.Model.Season;
import io.sahil.f1dashboard.data.SeasonInput;

public class SeasonProcessor implements ItemProcessor<SeasonInput, Season>{

	@Override
	public Season process(SeasonInput item) throws Exception {
		Season season = new Season();
		season.setYear(item.getYear());
		return season;
	}

}
