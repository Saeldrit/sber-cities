package service.realization;

import model.City;
import service.comparator.SortingCitiesByName;
import service.data_interface.Organization;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class SorterCities implements Organization {

    @Override
    public List<City> sortingCitiesByName(List<City> cities) {
        SortingCitiesByName sortingCitiesByName = new SortingCitiesByName();
        cities.sort(sortingCitiesByName);

        return new ArrayList<>(cities);
    }

    @Override
    public List<City> sortingCitiesByDistrictAndName(List<City> cities) {
        cities.sort(Comparator.comparing(City::getDistrict));

        return new ArrayList<>(cities);
    }
}
