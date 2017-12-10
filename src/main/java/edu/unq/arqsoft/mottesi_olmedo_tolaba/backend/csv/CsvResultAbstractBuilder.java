package edu.unq.arqsoft.mottesi_olmedo_tolaba.backend.csv;

import java.util.List;

public abstract class CsvResultAbstractBuilder<BuildingType> {

	public abstract BuildingType build(List<String> csvParserResult);

}
