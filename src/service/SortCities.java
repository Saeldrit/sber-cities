package service;

import java.util.List;

public interface SortCities<K, V> {
    void sortCitiesByName(List<V> list);

    void sortingCitiesByDistrict(List<V> list);
}
