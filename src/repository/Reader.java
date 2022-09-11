package repository;

import java.io.File;
import java.util.List;

public interface Reader {
    List<File> readFilesName(String directory);

    List<String> readContentFromFile(String path);
}
