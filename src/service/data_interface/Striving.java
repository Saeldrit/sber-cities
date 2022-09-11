package service.data_interface;

import model.City;

import java.util.List;

public interface Striving {
    City getCityOfMaximumPopulation(List<City> cities);
}
