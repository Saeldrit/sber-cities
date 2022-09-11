package service.data_interface;

import model.City;

import java.util.List;
import java.util.Map;

public abstract class AbstractBuilder implements BuilderService, Organization, Striving {
    public abstract Map<String, Integer> getCountCitiesByRegion(List<City> cities);
}
