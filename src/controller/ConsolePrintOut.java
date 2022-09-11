package controller;

import factory.Manager;
import model.City;
import repository.Reader;
import service.data_interface.AbstractBuilder;

import java.io.File;
import java.util.List;
import java.util.Map;

public class ConsolePrintOut {
    private final Reader reader;
    private final AbstractBuilder builder;
    private final List<String> content;
    private final List<City> citiesList;
    private final List<File> files;
    private final Map<Integer, City> citiesMap;

    public ConsolePrintOut(int numberOfFile, String directory) {
        this.reader = Manager.getReadingListOfCities();
        this.builder = Manager.getCityBuilder();
        this.files = reader.readFilesName(directory);
        this.content = reader.readContentFromFile(files.get(numberOfFile).getPath());
        this.citiesList = builder.builderListCities(content);
        this.citiesMap = builder.builderMapCity(content);
    }

    public void printCities() {
        if (!citiesMap.isEmpty()) {
            for (var pair : citiesMap.entrySet()) {
                System.out.println(pair.getKey() + " " + pair.getValue());
            }
        }
    }

    public void printSortCitiesByName() {
        List<City> cities = builder.sortingCitiesByName(citiesList);

        if (!cities.isEmpty()) {
            cities.forEach(System.out::println);
        }
    }

    public void printSortCitiesByDistrictAndName() {
        List<City> cities = builder.sortingCitiesByDistrictAndName(citiesList);

        if (!cities.isEmpty()) {
            cities.forEach(System.out::println);
        }
    }

    public void printCityOfMaximumPopulation() {
        City city = builder.getCityOfMaximumPopulation(citiesList);
        System.out.format("%d Город %s с самым большим населением %d\n",
                city.getId(),
                city.getName(),
                city.getPopulation());
    }

    public void printCountCitiesByRegion() {
        Map<String, Integer> map = builder.getCountCitiesByRegion(citiesList);

        for (var pair : map.entrySet()) {
            System.out.format("Region: %s -- %d cities\n",
                    pair.getKey(),
                    pair.getValue());
        }
    }
}
