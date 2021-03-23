package hu.nive.ujratervezes.zarovizsga.people;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.stream.Stream;

public class People {

    public int getNumberOfMales(String path) {
        Path file = Path.of(path);
        try (Stream<String> lines = Files.lines(file)) {
            return (int)lines
                    .skip(1)
                    .map(s -> s.split(","))
                    .filter(s -> "Male".equals(s[4]))
                    .count();

        } catch (IOException ioe) {
            throw new IllegalStateException("Can not read file. ", ioe);
        }
    }

}
