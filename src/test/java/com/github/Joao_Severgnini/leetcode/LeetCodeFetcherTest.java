package com.github.Joao_Severgnini.leetcode;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;

import java.nio.file.Files;
import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.*;

public class LeetCodeFetcherTest {

    private final LeetCodeFetcher fetcher = new LeetCodeFetcher();

    @Test
    void testCreateMarkdown() {
        String markdown = fetcher.createMarkdown(
            "Two Sum",
            "Easy",
            "Array, Hash Table",
            "10000",
            "500",
            "<p>Given an array of integers...</p>",
            "Input: nums = [2,7,11,15], target = 9\nOutput: [0,1]"
        );

        assertTrue(markdown.contains("# Two Sum"));
        assertTrue(markdown.contains("**Difficulty:** Easy"));
        assertTrue(markdown.contains("**Tags:** Array, Hash Table"));
        assertTrue(markdown.contains("## Description"));
        assertTrue(markdown.contains("Given an array of integers"));
        assertTrue(markdown.contains("## Example Testcases"));
    }

    @Test
    void testFindJavaSolution_WhenSolutionExists() throws Exception {
        String json = """
        [
            {"lang": "Python", "code": "print('Hello')"},
            {"lang": "Java", "code": "public class Solution {}"}
        ]
        """;

        JsonNode codeSnippets = new ObjectMapper().readTree(json);
        String javaCode = fetcher.findJavaSolution(codeSnippets);

        assertEquals("public class Solution {}", javaCode.trim());
    }

    @Test
    void testFindJavaSolution_WhenSolutionNotFound() throws Exception {
        String json = """
        [
            {"lang": "Python", "code": "print('Hello')"}
        ]
        """;

        JsonNode codeSnippets = new ObjectMapper().readTree(json);
        String javaCode = fetcher.findJavaSolution(codeSnippets);

        assertTrue(javaCode.contains("// Solution code not found"));
    }
}
