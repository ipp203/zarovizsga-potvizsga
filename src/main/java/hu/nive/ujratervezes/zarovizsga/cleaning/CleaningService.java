package hu.nive.ujratervezes.zarovizsga.cleaning;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CleaningService {
    private final List<Cleanable> cleanables = new ArrayList<>();

    public List<Cleanable> getCleanables() {
        return new ArrayList<>(cleanables);
    }

    public void add(Cleanable cleanable) {
        cleanables.add(cleanable);
    }

    public int cleanAll() {
        int result = cleanables.stream()
                .map(Cleanable::clean)
                .reduce(Integer::sum)
                .orElse(0);
        cleanables.clear();
        return result;
    }

    public int cleanOnlyOffices() {
        int result = cleanables.stream()
                .filter(c -> c instanceof Office)
                .map(Cleanable::clean)
                .reduce(Integer::sum)
                .orElse(0);
        cleanables.removeIf(c -> c instanceof Office);
        return result;
    }

    public List<Cleanable> findByAddressPart(String address) {
        return cleanables.stream()
                .filter(c -> c.getAddress().contains(address))
                .collect(Collectors.toList());
    }

    public String getAddresses() {
        return cleanables.stream()
                .map(Cleanable::getAddress)
                .reduce((s1, s2) -> s1 + ", " + s2).orElse("");
    }
}
