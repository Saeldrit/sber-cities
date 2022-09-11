package service;

import model.City;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class CityBuilder implements Builder<Integer, City> {

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
    public Map<Integer, City> builderMapCity(List<String> list) {
        Map<Integer, City> map = new LinkedHashMap<>();

        if (list.size() != 0) {
            for (var line : list) {
                City city = new City();

                String[] array = line.split(";");

                for (int i = 0; i < array.length; i++) {
                    builder(city, i, array);
                }

                map.put(city.getId(), city);
            }
        }

        return map;
    }

    private void builder(City city, int i, String... array) {
        switch (i) {
            case 0 -> city.setId(Integer.parseInt(array[0]));
            case 1 -> city.setName(array[1]);
            case 2 -> city.setRegion(array[2]);
            case 3 -> city.setDistrict(array[3]);
            case 4 -> city.setPopulation(Integer.parseInt(array[4]));
            case 5 -> city.setFoundation(array[5]);
        }
    }
}
