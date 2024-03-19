package com.solution.model;

import lombok.SneakyThrows;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class TestCollections {

    @Test
    void testPrintList() {
        list.forEach(System.out::println);
    }

    @Test
    void testChangeWeightOfFirstByOne() {
        list.get(0).setWeight(list.get(0).getWeight() + 1);
        assertEquals(new HeavyBox(1, 2, 3, 5), list.get(0));
    }


    @Test
    void testDeleteLast() {
        list.remove(list.size() - 2);
        assertEquals(6, list.size());
        assertEquals(new HeavyBox(1, 2, 3, 4), list.get(0));
        assertEquals(new HeavyBox(1, 3, 3, 4), list.get(list.size() - 2));
    }

    @Test
    void testConvertToArray() {
        HeavyBox[] arr = list.toArray(HeavyBox[]::new);
        assertArrayEquals(new HeavyBox[]{
                new HeavyBox(1, 2, 3, 4),
                new HeavyBox(3, 3, 3, 4),
                new HeavyBox(2, 6, 5, 3),
                new HeavyBox(2, 3, 4, 7),
                new HeavyBox(1, 3, 3, 4),
                new HeavyBox(1, 2, 3, 4),
                new HeavyBox(1, 1, 1, 1)
        }, arr);
    }

    @Test
    void testDeleteBoxesByWeight() {
        list.removeIf(heavyBox -> heavyBox.getWeight() == 4);
        assertEquals(3, list.size());
    }


    @Test
    void testSortBoxesByWeight() {
        list.sort(Comparator.comparingInt(HeavyBox::getWeight)
                .thenComparingDouble(HeavyBox::getVolume));

        assertEquals(new HeavyBox(1, 1, 1, 1), list.get(0));
        assertEquals(new HeavyBox(2, 3, 4, 7), list.get(6));
        assertEquals(new HeavyBox(1, 2, 3, 4), list.get(3));
        assertEquals(new HeavyBox(1, 3, 3, 4), list.get(4));
    }

    @Test
    void testClearList() {
        list.clear();
        assertTrue(list.isEmpty());
    }

    @Test
    void testReadAllLinesFromFileToList() {
        List<String> lines = reader.lines().toList();
        assertEquals(19, lines.size());
        assertEquals("", lines.get(8));
    }

    @Test
    void testReadAllWordsFromFileToList() throws IOException {
        List<String> words = readAllWordsFromFileToList();
        assertEquals(257, words.size());
    }

    @SneakyThrows
    List<String> readAllWordsFromFileToList() {
        return reader.lines()
                .filter(line -> !line.isEmpty())
                .flatMap(line -> Arrays.stream(line.split(REGEXP)))
                .toList();
    }

    @Test
    void testFindLongestWord() {
        assertEquals("conversations", findLongestWord());
    }

    private String findLongestWord() {
        String longestWord = "";
        for (String word : readAllWordsFromFileToList()) {
            if (word.length() > longestWord.length()) {
                longestWord = word;
            }
        }
        return longestWord;
    }

    @Test
    void testAllWordsByAlphabetWithoutRepeat() {
        List<String> words = readAllWordsFromFileToList();
        List<String> result = new ArrayList<>();
        for (String word : words) {
            result.add(word.toLowerCase());
        }
        result = new ArrayList<>(new TreeSet<>(result));

        assertEquals("alice", result.get(5));
        assertEquals("all", result.get(6));
        assertEquals("without", result.get(134));
        assertEquals(138, result.size());
    }

    @Test
    void testFindMostFrequentWord() {
        assertEquals("the", mostFrequentWord());
    }

    @Test
    void testFindWordsByLengthInAlphabetOrder() {
        List<String> words = new ArrayList<>(readAllWordsFromFileToList());
        words.replaceAll(String::toLowerCase);
        TreeSet<String> set = new TreeSet<>(words);
        List<String> strings = set.stream().filter(word -> word.length() <= 5).toList();
        assertEquals(94, strings.size());
        assertEquals("a", strings.get(0));
        assertEquals("alice", strings.get(2));
        assertEquals("would", strings.get(strings.size() - 1));
    }

    private String mostFrequentWord() {
        return Collections.max(readAllWordsFromFileToList()
                        .stream()
                        .collect(Collectors.toMap(word -> word, word -> 1, Integer::sum))
                        .entrySet(), Map.Entry.comparingByValue())
                .getKey();
    }

    List<HeavyBox> list;

    @BeforeEach
    void setUp() {
        list = new ArrayList<>(List.of(
                new HeavyBox(1, 2, 3, 4),
                new HeavyBox(3, 3, 3, 4),
                new HeavyBox(2, 6, 5, 3),
                new HeavyBox(2, 3, 4, 7),
                new HeavyBox(1, 3, 3, 4),
                new HeavyBox(1, 2, 3, 4),
                new HeavyBox(1, 1, 1, 1)
        ));
    }

    static final String REGEXP = "\\W+"; // for splitting into words

    private BufferedReader reader;

    @BeforeEach
    public void setUpBufferedReader() throws IOException {
        reader = Files.newBufferedReader(
                Paths.get("Text.txt"), StandardCharsets.UTF_8);
    }

    @AfterEach
    public void closeBufferedReader() throws IOException {
        reader.close();
    }
}
