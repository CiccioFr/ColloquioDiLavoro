package main.java.cicciofr.colloquioDiLavoro.citazioni;

import java.util.Arrays;
import java.util.List;

public class Stream {
    public static void main(String[] args) {
        List<String> coloriList = Arrays.asList("bianco", "rosso", "giallo", "blu", "verde");

        List<String> coloriStream = coloriList.stream().filter(colore -> colore.startsWith("g")).toList();
        System.out.println(coloriStream);
    }
}
