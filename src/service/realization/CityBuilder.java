package service.realization;

import model.City;
import service.data_interface.BuilderService;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class CityBuilder implements BuilderService {

    @Override
    public City builderObjectCity(String line) {
        City city = new City();

        if (line != null) {
            String[] array = line.split(";");
            for (int i = 0; i < array.length; i++) {
                builder(city, i, array);
            }
        }

        return city;
    }

    @Override
    public Map<Integer, City> builderMapCity(List<String> content) {
        Map<Integer, City> citiesMap = new LinkedHashMap<>();

        if (!content.isEmpty()) {
            for (var line : content) {
                City city = new City();

                String[] array = line.split(";");

                for (int i = 0; i < array.length; i++) {
                    builder(city, i, array);
                }

                citiesMap.put(city.getId(), city);
            }
        }

        return citiesMap;
    }

    @Override
    public List<City> builderListCities(List<String> content) {
        List<City> cities = new ArrayList<>();

        if (!content.isEmpty()) {
            for (var line : content) {
                City city = new City();

                String[] array = line.split(";");

                for (int i = 0; i < array.length; i++) {
                    builder(city, i, array);
                }

                cities.add(city);
            }
        }

        return cities;
    }

    private void builder(City city, int i, String... array) {
        switch (i) {
            case 0 -> city.setId(checkParseInt(array[0]));
            case 1 -> city.setName(array[1]);
            case 2 -> city.setRegion(array[2]);
            case 3 -> city.setDistrict(array[3]);
            case 4 -> city.setPopulation(checkParseInt(array[4]));
            case 5 -> city.setFoundation(array[5]);
        }
    }

    private int checkParseInt(String str) {
        int number = -1;
        try {
            number = Integer.parseInt(str);
        } catch (NumberFormatException exception) {
            System.out.println(str + " - it is not Integer");
        }
        return number;
    }
}
