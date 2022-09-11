package factory;

import model.City;
import repository.Reader;
import repository.ReadingListOfCities;
import service.CityService;
import service.data_interface.AbstractBuilder;
import service.realization.CityBuilder;

public class Manager {
    public static Reader getReadingListOfCities() {
        return new ReadingListOfCities();
    }

    public static AbstractBuilder getCityBuilder() {
        return new CityService();
    }
}
