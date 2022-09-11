package service.realization;

import model.City;
import service.data_interface.Striving;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class SearchEngine implements Striving {

    @Override
    public City getCityOfMaximumPopulation(List<City> cities) {
        List<City> list = new ArrayList<>(cities);
        list.sort(Comparator.comparing(City::getPopulation));

        return list.get(list.size() - 1);
    }
}
