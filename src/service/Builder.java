package service;

import java.util.List;
import java.util.Map;

public interface Builder<K, V> {
    V builderObjectCity(String line);

    Map<K, V> builderMapCity(List<String> list);

    List<V> builderListCities(List<String> content);
}
