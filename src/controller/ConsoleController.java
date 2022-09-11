package controller;

import factory.Manager;
import model.City;
import repository.Reader;
import service.Builder;

import java.io.File;
import java.util.List;
import java.util.Map;

public class ConsoleController {
    private final Reader reader;
    private final Builder<Integer, City> builder;
    private final List<File> files;
    private final List<String> content;
    private final Map<Integer, City> cities;

    public ConsoleController(int numberOfFile, String directory) {
        this.reader = Manager.getReadingListOfCities();
        this.builder = Manager.getCityBuilder();
        this.files = reader.readFilesName(directory);
        this.content = reader.readContentFromFile(files.get(numberOfFile).getPath());
        this.cities = builder.builderMapCity(content);
    }

    public Map<Integer, City> getCities() {
        return cities;
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
        if (!cities.isEmpty()) {
            for (var pair : cities.entrySet()) {
                System.out.println(pair.getKey() + " " + pair.getValue());
            }
        }
    }
}
