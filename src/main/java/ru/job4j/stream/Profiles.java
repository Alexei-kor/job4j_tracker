package ru.job4j.stream;

import java.util.Comparator;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Profiles {

    public static List<Address> collect(List<Profile> profiles) {
        return profiles.stream()
                .map((prof) -> prof.getAddress())
                .distinct()
                .sorted(new SortAdressAsc())
                .collect(Collectors.toList());
    }
}
