package factory;

import model.City;
import repository.Reader;
import repository.ReadingListOfCities;
import service.AbstractBuilder;
import service.Builder;
import service.CityBuilder;

public class Manager {
    public static Reader getReadingListOfCities() {
        return new ReadingListOfCities();
    }

    public static AbstractBuilder<Integer, City> getCityBuilder() {
        return new CityBuilder();
    }
}
