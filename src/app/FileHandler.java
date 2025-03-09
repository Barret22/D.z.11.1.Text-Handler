package app;

import java.io.IOException;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.Path;

public class FileHandler {

    public String createFile(String path) {
        Path newFile = Path.of(path);
        try {
            Files.createFile(newFile);
            return "Created " + newFile;
        } catch (FileAlreadyExistsException e) {
            return "File already exists!";
        } catch (IOException e) {
            return "Something went wrong: " + e.getMessage();
        }
    }

    public String writeToFile(Path path, String content) {
        try {
            Files.writeString(path, content);
            return "Recorded in " + path;
        } catch (IOException e) {
            return "Error writing to file: " + e.getMessage();
        }
    }

    public String readFromFile(String path) {
        try {
            return Files.readString(Path.of(path));
        } catch (IOException e) {
            return "Error reading file: " + e.getMessage();
        }
    }
}


