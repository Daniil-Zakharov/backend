package ru.nntu.Git.backend;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

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

    public String read() {
        StringBuilder content = new StringBuilder();

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                content.append(line).append(System.lineSeparator());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return content.toString();
    }
}
