package model;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.nio.file.Files;
import java.nio.file.Paths;

public class CSVLogger {

    private String filePath;
    private String separator;
    private double step;
    private double start;
    private double end;

    public CSVLogger(String fileName, double start, double end, double step) {
        this.setFilePath(fileName);
        this.separator = ";";
        this.start = start;
        this.end = end;
        this.step = step;
    }

    public void setFilePath(String fileName) {
        this.filePath = "test/resources/" + fileName;
    }

    public void log(Calculable fun) {
        try {
            Files.deleteIfExists(Paths.get(this.filePath));
        } catch (IOException e) {
        }

        try (PrintStream printStream = new PrintStream(new FileOutputStream(filePath, true))) {
            for (double i = start; i < end; i += step) {
                printStream.printf("%f%s%f\n", i, separator, fun.calculate(i));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public String getSeparator() {
        return separator;
    }

    public void setSeparator(String separator) {
        this.separator = separator;
    }
}
