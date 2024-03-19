package com.solution;


import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.Arrays.stream;
import static java.util.Comparator.comparingInt;
import static java.util.Comparator.naturalOrder;
import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toMap;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

class Exercises {

    @Test
    void printAllWords() {
        wordList.forEach(System.out::println);
    }

    @Test
    void upperCaseWords() {
        List<String> output = wordList.stream()
                .map(String::toUpperCase)
                .toList();
        assertEquals(
                Arrays.asList(
                        "EVERY", "PROBLEM", "IN", "COMPUTER", "SCIENCE",
                        "CAN", "BE", "SOLVED", "BY", "ADDING", "ANOTHER",
                        "LEVEL", "OF", "INDIRECTION"),
                output);
    }

    @Test
    void findEvenLengthWords() {
        List<String> output = wordList
                .stream()
                .filter(w -> w.length() % 2 == 0)
                .toList();

        assertEquals(Arrays.asList("in", "computer", "be", "solved", "by", "adding", "of"), output);
    }

    @Test
    void countLinesInFile() throws IOException {
        long count = wordList.stream().count();
        assertEquals(14, count);
    }

    @Test
    void joinLineRange() throws IOException {
        String output = reader.lines()
                .skip(2)
                .limit(2)
                .collect(joining(""));
        assertEquals("But as the riper should by time decease," +
                "His tender heir might bear his memory:", output);
    }


    @Test
    void lengthOfLongestLine() throws IOException {
        int longest = reader.lines()
                .mapToInt(String::length)
                .max()
                .orElse(0);
        assertEquals(longest, 53);
    }

    @Test
    void listOfAllWords() throws IOException {
        List<String> output = reader.lines()
                .flatMap(line -> Stream.of(line.split(REGEXP)))
                .filter(word -> !word.isEmpty())
                .toList();

        assertEquals(
                Arrays.asList(
                        "From", "fairest", "creatures", "we", "desire", "increase",
                        "That", "thereby", "beauty", "s", "rose", "might", "never", "die",
                        "But", "as", "the", "riper", "should", "by", "time", "decease",
                        "His", "tender", "heir", "might", "bear", "his", "memory", "But",
                        "thou", "contracted", "to", "thine", "own", "bright", "eyes",
                        "Feed", "st", "thy", "light", "s", "flame", "with", "self",
                        "substantial", "fuel", "Making", "a", "famine", "where",
                        "abundance", "lies", "Thy", "self", "thy", "foe", "to", "thy",
                        "sweet", "self", "too", "cruel", "Thou", "that", "art", "now",
                        "the", "world", "s", "fresh", "ornament", "And", "only", "herald",
                        "to", "the", "gaudy", "spring", "Within", "thine", "own", "bud",
                        "buriest", "thy", "content", "And", "tender", "churl", "mak",
                        "st", "waste", "in", "niggarding", "Pity", "the", "world", "or",
                        "else", "this", "glutton", "be", "To", "eat", "the", "world", "s",
                        "due", "by", "the", "grave", "and", "thee"),
                output);
    }

    @Test
    void sortedLowerCase() throws IOException {
        List<String> output = reader.lines()
                .flatMap(line -> stream(line.split(REGEXP)))
                .filter(word -> !word.isEmpty())
                .map(String::toLowerCase)
                .sorted()
                .toList();
        assertEquals(
                Arrays.asList(
                        "a", "abundance", "and", "and", "and", "art", "as", "be",
                        "bear", "beauty", "bright", "bud", "buriest", "but", "but",
                        "by", "by", "churl", "content", "contracted", "creatures",
                        "cruel", "decease", "desire", "die", "due", "eat", "else",
                        "eyes", "fairest", "famine", "feed", "flame", "foe", "fresh",
                        "from", "fuel", "gaudy", "glutton", "grave", "heir", "herald",
                        "his", "his", "in", "increase", "lies", "light", "mak",
                        "making", "memory", "might", "might", "never", "niggarding",
                        "now", "only", "or", "ornament", "own", "own", "pity",
                        "riper", "rose", "s", "s", "s", "s", "self", "self", "self",
                        "should", "spring", "st", "st", "substantial", "sweet",
                        "tender", "tender", "that", "that", "the", "the", "the",
                        "the", "the", "the", "thee", "thereby", "thine", "thine",
                        "this", "thou", "thou", "thy", "thy", "thy", "thy", "thy",
                        "time", "to", "to", "to", "to", "too", "waste", "we", "where",
                        "with", "within", "world", "world", "world"),
                output);
    }

    @Test
    void sortedLowerCaseDistinctByLengthThenAlphabetically() throws IOException {
        List<String> output = reader.lines()
                .flatMap(line -> stream(line.split(REGEXP)))
                .filter(word -> !word.isEmpty())
                .map(String::toLowerCase)
                .distinct()
                .sorted(comparingInt(String::length).thenComparing(naturalOrder()))
                .collect(Collectors.toList());

        assertEquals(
                Arrays.asList(
                        "a", "s", "as", "be", "by", "in", "or", "st", "to", "we",
                        "and", "art", "bud", "but", "die", "due", "eat", "foe", "his",
                        "mak", "now", "own", "the", "thy", "too", "bear", "else",
                        "eyes", "feed", "from", "fuel", "heir", "lies", "only",
                        "pity", "rose", "self", "that", "thee", "this", "thou",
                        "time", "with", "churl", "cruel", "flame", "fresh", "gaudy",
                        "grave", "light", "might", "never", "riper", "sweet", "thine",
                        "waste", "where", "world", "beauty", "bright", "desire",
                        "famine", "herald", "making", "memory", "should", "spring",
                        "tender", "within", "buriest", "content", "decease",
                        "fairest", "glutton", "thereby", "increase", "ornament",
                        "abundance", "creatures", "contracted", "niggarding",
                        "substantial"),
                output);
    }

    @Test
    void mapLengthToWordList() throws IOException {
        Map<Integer, List<String>> map = reader.lines()
                .flatMap(line -> Arrays.stream(line.split(REGEXP)))
                .filter(word -> !word.isEmpty())
                .collect(groupingBy(String::length));

        assertEquals(6, map.get(7).size());
        assertEquals(Arrays.asList("increase", "ornament"), map.get(8));
        assertEquals(Arrays.asList("creatures", "abundance"), map.get(9));
        assertEquals(Arrays.asList("contracted", "niggarding"), map.get(10));
        assertEquals(Arrays.asList("substantial"), map.get(11));
        assertFalse(map.containsKey(12));
    }

    @Test
    void wordFrequencies() throws IOException {
//        Map<String, Long> map = reader.lines()
//                .flatMap(line -> Arrays.stream(line.split(REGEXP)))
//                .filter(word -> !word.isEmpty())
//                .collect(toMap(word -> word, word -> 1L, Long::sum));

        Map<String, Long> map = reader.lines()
                .flatMap(line -> Arrays.stream(line.split(REGEXP)))
                .collect(groupingBy(String::toLowerCase, counting()));

        assertEquals(2L, (long) map.get("tender"));
        assertEquals(6L, (long) map.get("the"));
        assertEquals(1L, (long) map.get("churl"));
        assertEquals(2L, (long) map.get("thine"));
        assertEquals(3L, (long) map.get("world"));
        assertFalse(map.containsKey("lambda"));
    }

    @Test
    void nestedMaps() throws IOException {
        Map<String, Map<Integer, List<String>>> map = reader.lines()
                .flatMap(line -> Arrays.stream(line.split(REGEXP)))
                .filter(w -> !w.isEmpty())
                .collect(groupingBy(w -> w.substring(0, 1),
                        groupingBy(String::length)));
        assertEquals("[From, Feed]", map.get("F").get(4).toString());
        assertEquals("[by, be, by]", map.get("b").get(2).toString());
        assertEquals("[the, thy, thy, thy, too, the, the, thy, the, the, the]",
                map.get("t").get(3).toString());
        assertEquals("[beauty, bright]", map.get("b").get(6).toString());
    }

// ===== TEST INFRASTRUCTURE ==================================================

    static List<String> wordList = Arrays.asList(
            "every", "problem", "in", "computer", "science",
            "can", "be", "solved", "by", "adding", "another",
            "level", "of", "indirection");
    // Butler Lampson

    static final String REGEXP = "\\W+"; // for splitting into words

    private BufferedReader reader;

    @BeforeEach
    void setUpBufferedReader() throws IOException {
        reader = Files.newBufferedReader(
                Paths.get("SonnetI.txt"), StandardCharsets.UTF_8);
    }

    @AfterEach
    void closeBufferedReader() throws IOException {
        reader.close();
    }
}
