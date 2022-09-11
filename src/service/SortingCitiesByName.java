package service;

import model.City;

import java.util.Comparator;

public class SortingCitiesByName implements Comparator<City> {

    @Override
    public int compare(City o1, City o2) {
        return String.CASE_INSENSITIVE_ORDER.compare(o1.getName(), o2.getName());
    }
}
