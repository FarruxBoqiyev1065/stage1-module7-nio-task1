package com.epam.mjc.nio;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;


public class FileReader {

    public Profile getDataFromFile(File file) {
        Profile profile = new Profile();
        try(FileInputStream fileInputStream = new FileInputStream(file)){
            StringBuilder stringBuilder = new StringBuilder();
            int c;
            while ((c = fileInputStream.read()) != -1){
                stringBuilder.append((char)c);
            }
            String[] split = stringBuilder.toString().split("\n");
            profile.setName(split[0].split(": ")[1]);
            profile.setAge(Integer.valueOf(split[1].split(": ")[1]));
            profile.setEmail(split[2].split(": ")[1]);
            profile.setPhone(Long.valueOf(split[3].split(": ")[1]));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return profile;
    }
}
