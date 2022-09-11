package factory;

import model.City;
import repository.Reader;
import repository.ReadingListOfCities;
import service.Builder;
import service.CityBuilder;

public class Manager {
    public static Reader getReadingListOfCities() {
        return new ReadingListOfCities();
    }

    public static Builder<Integer, City> getCityBuilder() {
        return new CityBuilder();
    }
}
