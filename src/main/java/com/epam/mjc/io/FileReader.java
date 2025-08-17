package com.epam.mjc.io;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;


public class FileReader {

    public Profile getDataFromFile(File file) {
        try (BufferedReader br = new BufferedReader(new java.io.FileReader(file))) {
            Profile profile = new Profile();
            String line;
            while ((line = br.readLine()) != null) {
                if (line.startsWith("Name: ")) {
                    profile.setName(line.replace("Name: ", ""));
                } else if (line.startsWith("Age: ")) {
                    profile.setAge(Integer.parseInt(line.replace("Age: ", "")));
                } else if (line.startsWith("Email: ")) {
                    profile.setEmail(line.replace("Email: ", ""));
                } else if (line.startsWith("Phone: ")) {
                    profile.setPhone(Long.parseLong(line.replace("Phone: ", "")));
                }
            }
            return profile;
        } catch (IOException e) {
            throw new RuntimeException("Error reading file: " + file.getName(), e);
        }
    }
}