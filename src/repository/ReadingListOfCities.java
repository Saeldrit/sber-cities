package repository;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ReadingListOfCities implements Reader {

    @Override
    public List<File> readFilesName(String directory) {
        List<File> files;

        try (Stream<Path> paths = Files.walk(Paths.get(directory + "/"))) {
            files = paths.filter(Files::isRegularFile)
                    .map(Path::toFile)
                    .collect(Collectors.toList());
        } catch (IOException e) {
            throw new IllegalArgumentException(e.getMessage() + " check path of directory");
        }

        return files;
    }

    @Override
    public List<String> readContentFromFile(String path) {
        List<String> contentOfFile = new ArrayList<>();

        try (BufferedReader csvReader = new BufferedReader(new FileReader(path))) {
            String line;
            while ((line = csvReader.readLine()) != null) {
                contentOfFile.add(line);
            }
        } catch (IOException e) {
            throw new NullPointerException(e.getMessage() + "sir, where is your file?");
        }

        return contentOfFile;
    }
}
