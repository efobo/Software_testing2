package functions;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;
import model.Calculable;
import org.mockito.AdditionalMatchers;

import java.io.FileReader;
import java.io.IOException;
import java.util.function.Function;

import static org.mockito.Mockito.when;

public class MockCSVer {
    public static void setupFromCSV(Calculable fun, String fileName, double delta) {
        setupFromCSV(fun, fileName, delta, Double::parseDouble);
    }

    public static void setupFromCSV(
            Calculable fun,
            String fileName,
            double delta,
            Function<String, Double> inputProcessor
    ) {
        try (CSVReader reader = new CSVReader(new FileReader(fileName))) {
            reader.readAll().forEach(lineArray -> {
                double input = inputProcessor.apply(lineArray[0]);
                double output = Double.parseDouble(lineArray[1]);
                when(fun.calculate(AdditionalMatchers.eq(input, delta))).thenReturn(output);
            });
        } catch (IOException | CsvException e) {
            e.printStackTrace();
        }
    }
}

