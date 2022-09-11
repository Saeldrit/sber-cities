package service.data_interface;

import model.City;

import java.util.List;

public interface Organization {
    List<City> sortingCitiesByName(List<City> list);

    List<City> sortingCitiesByDistrictAndName(List<City> list);
}
