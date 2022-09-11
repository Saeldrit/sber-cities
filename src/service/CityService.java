package service;

import model.City;
import service.data_interface.AbstractBuilder;
import service.realization.CityBuilder;
import service.realization.SearchEngine;
import service.realization.SorterCities;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class CityService extends AbstractBuilder {
    private final CityBuilder cityBuilder;
    private final SearchEngine searchEngine;
    private final SorterCities sorterCities;

    public CityService() {
        this.cityBuilder = new CityBuilder();
        this.searchEngine = new SearchEngine();
        this.sorterCities = new SorterCities();
    }

    @Override
    public Map<String, Integer> getCountCitiesByRegion(List<City> cities) {
        Map<String, Integer> citiesMap = new LinkedHashMap<>();

        for (var city : cities) {
            citiesMap.put(city.getRegion(),
                    citiesMap.getOrDefault(city.getRegion(), 0) + 1);
        }

        return citiesMap;
    }

    @Override
    public City builderObjectCity(String line) {
        return cityBuilder.builderObjectCity(line);
    }

    @Override
    public Map<Integer, City> builderMapCity(List<String> content) {
        return cityBuilder.builderMapCity(content);
    }

    @Override
    public List<City> builderListCities(List<String> content) {
        return cityBuilder.builderListCities(content);
    }

    @Override
    public List<City> sortingCitiesByName(List<City> list) {
        return sorterCities.sortingCitiesByName(list);
    }

    @Override
    public List<City> sortingCitiesByDistrictAndName(List<City> list) {
        return sorterCities.sortingCitiesByDistrictAndName(list);
    }

    @Override
    public City getCityOfMaximumPopulation(List<City> cities) {
        return searchEngine.getCityOfMaximumPopulation(cities);
    }
}
