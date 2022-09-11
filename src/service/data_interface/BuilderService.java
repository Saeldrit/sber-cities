package service.data_interface;

import model.City;

import java.util.List;
import java.util.Map;

public interface BuilderService {
    City builderObjectCity(String line);

    Map<Integer, City> builderMapCity(List<String> content);

    List<City> builderListCities(List<String> content);
}
