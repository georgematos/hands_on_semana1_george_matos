package com.eldorado.handson.utils;

import java.awt.image.AreaAveragingScaleFilter;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class ReadFileUtil {
    private BufferedReader reader;
    private final Logger LOGGER = Logger.getLogger(ReadFileUtil.class.getName());
    private List<String> lines = new ArrayList<>();
    public List<String> readFile(String fileName) {

        try {
            reader = new BufferedReader(new FileReader(fileName));
            String line = reader.readLine();

            while(line != null) {
                lines.add(line);
                line = reader.readLine();
            }
            reader.close();
        } catch (FileNotFoundException e) {
            LOGGER.info(String.format("Error: %s", e));
        } catch (IOException e) {
            LOGGER.info(String.format("Error: %s", e));
        }
        lines.remove(0);
        return lines;
    }

}
