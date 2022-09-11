package controller;

import factory.Manager;
import model.City;
import repository.Reader;
import service.AbstractBuilder;
import service.Builder;

import java.io.File;
import java.util.List;
import java.util.Map;

public class ConsoleController {
    private final Reader reader;
    private final AbstractBuilder<Integer, City> builder;
    private final List<File> files;
    private final List<String> content;
    private List<City> citiesList;
    private Map<Integer, City> citiesMap;

    public ConsoleController(int numberOfFile, String directory) {
        this.reader = Manager.getReadingListOfCities();
        this.builder = Manager.getCityBuilder();
        this.files = reader.readFilesName(directory);
        this.content = reader.readContentFromFile(files.get(numberOfFile).getPath());
    }

    public Map<Integer, City> getCitiesMap() {
        return citiesMap;
    }

    public Reader getReader() {
        return reader;
    }

    public Builder<Integer, City> getBuilder() {
        return builder;
    }

    public List<File> getFiles() {
        return files;
    }

    public List<String> getContent() {
        return content;
    }

    public void printContent() {
        if (!citiesMap.isEmpty()) {
            for (var pair : citiesMap.entrySet()) {
                System.out.println(pair.getKey() + " " + pair.getValue());
            }
        } else {
            this.citiesMap = builder.builderMapCity(content);
        }
    }

    public void printSortContentByName() {
        builder.sortCitiesByName(citiesList);

        if (!citiesList.isEmpty()) {
            citiesList.forEach(System.out::println);
        } else {
            this.citiesList = builder.builderListCities(content);
        }
    }

    public void printSortContentByDistrictAndName() {
        builder.sortingCitiesByDistrict(citiesList);

        if (!citiesList.isEmpty()) {
            citiesList.forEach(System.out::println);
        } else {
            this.citiesList = builder.builderListCities(content);
        }
    }
}
