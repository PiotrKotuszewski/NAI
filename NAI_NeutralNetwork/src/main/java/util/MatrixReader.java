package util;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class MatrixReader {

    public MatrixReader(){}


    public static List<double[]> convert(final List<String> lines) {
        List<String> currentList = new ArrayList<>();
        List<double[]> result = new ArrayList<>();
        for (String line: lines) {
            if (line.isEmpty()) {
                result.add(mapToDouble(currentList));
                currentList.clear();
            } else {
                currentList.add(line);
            }
        }

        if (!currentList.isEmpty()) {
            result.add(mapToDouble(currentList));
        }

        return result;
    }

    public static double[] mapToDouble(final List<String> lines) {
        return lines.stream()
                .map(l -> l.split(" "))
                .flatMap(Stream::of)
                .mapToDouble(Double::valueOf)
                .toArray();
    }
}