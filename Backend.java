package ru.nntu.Git.backend;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

@Component
public class Backend {
    private static final String file = "I:\\IntelliJ\\projects\\Git\\src\\main\\java\\ru\\nntu\\Git\\data.txt";
    private final File f;

    @Autowired
    public Backend() throws IOException {
        this.f = new File(file);
    }

    public void write(String line) {
        try {
            FileWriter fw = new FileWriter(f, true);
            fw.write(line + "\n");
            fw.close();
        }
        catch (IOException e) {
            System.out.println("Error");
        }
    }
}
