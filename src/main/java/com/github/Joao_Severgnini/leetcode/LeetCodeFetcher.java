package com.github.Joao_Severgnini.leetcode;

import okhttp3.*;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map;

public class LeetCodeFetcher {

  // Constants
  private static final String GRAPHQL_URL = "https://leetcode.com/graphql";
  private final OkHttpClient client;
  private final ObjectMapper mapper;

  public LeetCodeFetcher(){
    this.client = new OkHttpClient();
    this.mapper = new ObjectMapper();
  }

  // Method to fetch the list of problems
  public  JsonNode getProblem(String slug) throws IOException {
    String query = """
        query getQuestionDetail($titleSlug: String!) {
            question(titleSlug: $titleSlug) {
                questionFrontendId
                title
                content
                difficulty
                likes
                dislikes
                exampleTestcases
                topicTags {
                    name
                }
                codeSnippets {
                    lang
                    code
                }
            }
        }
        """;

    // Read the GraphQL query from a file
    String jsonBody = mapper.writeValueAsString(Map.of(
        "operationName", "getQuestionDetail",
        "variables", Map.of("titleSlug", slug),
        "query", query));

    // Create the request
    Request request = new Request.Builder() 
        .url(GRAPHQL_URL)
        .post(RequestBody.create(jsonBody, MediaType.parse("application/json")))
        .build();

    // Execute the request
    try(Response response = client.newCall(request).execute()){
        if (!response.isSuccessful()) {
            throw new IOException("Error: " + response.code() + " - " + response.message());
        }

        // Parse the response
        JsonNode root = mapper.readTree(response.body().string());
        JsonNode data = root.get("data").get("question");

        // Check if the data is null or empty
        if(data == null || data.isNull()){
            throw new IOException("Error: No data found for slug " + slug);
        }
        return data;
    }
}

    public void saveProblem(JsonNode data, Path baseDir, String slug) throws IOException {
        // Print the question details
        String questionId = data.get("questionFrontendId").asText();
        String paddedId = String.format("%04d", Integer.parseInt(questionId));
        String title = data.get("title").asText();
        String content = data.get("content").asText();
        String difficulty = data.get("difficulty").asText();
        String likes = data.get("likes").asText();
        String dislikes = data.get("dislikes").asText();
        String exampleTestcases = data.get("exampleTestcases").asText();

        StringBuilder tags = new StringBuilder();
        for(JsonNode tag : data.get("topicTags")){
            tags.append(tag.get("name").asText()).append(", ");
        }
        
        if (tags.length() > 0) {
            tags.setLength(tags.length() - 2); // Remove the last comma and space
        }

        // Create the directory if it doesn't exist
        String folderName = paddedId + "-" + slug;
        Path problemDir = baseDir.resolve(folderName);
        Path descriptionDir = problemDir.resolve("description");
        Path solutionDir = problemDir.resolve("solution");

        Files.createDirectories(descriptionDir);
        Files.createDirectories(solutionDir);

        String markdown = createMarkdown(title, difficulty, tags.toString(), likes, dislikes, content, exampleTestcases);
        Files.writeString(descriptionDir.resolve("description.md"), markdown);

        String solutionCode = findJavaSolution(data.get("codeSnippets"));
        Files.writeString(solutionDir.resolve("Solution.java"), solutionCode);

        System.out.println("Problem folder created at: " + problemDir.toAbsolutePath());

    }
        // Create the .md file
       public String createMarkdown(String title, String difficulty, String tags, String likes, String dislikes, String content, String exampleTestcases) {
        return String.format("""
            # %s

            **Difficulty:** %s  
            **Tags:** %s  
            **Likes:** %s  
            **Dislikes:** %s

            ---

            ## Description

            %s

            ---

            ## Example Testcases

            ```
            %s
            ```
            """, title, difficulty, tags, likes, dislikes, content, exampleTestcases);
    }

    public String findJavaSolution(JsonNode codeSnippets) {
        if (codeSnippets != null && codeSnippets.isArray()) {
            for (JsonNode codeSnippet : codeSnippets) {
                String lang = codeSnippet.get("lang").asText();
                if (lang.equals("Java")) {
                    return codeSnippet.get("code").asText();
                }
            }
        }
        return """
            // Solution code not found
            public class Solution {
                public void main(String[] args) {
                    // Add your solution code here
                }
            }
            """;
    }

            
  
    public static void main(String[] args) {
        if (args.length == 0){
            System.out.println("Please provide a problem slug.");
            return;
        }
        String slug = args[0];
        LeetCodeFetcher fetcher = new LeetCodeFetcher();
        try {
            JsonNode problemData = fetcher.getProblem(slug);
            fetcher.saveProblem(problemData, Paths.get("problems"), slug);
        } catch (IOException e) {
            System.err.println("Error fetching problem: " + e.getMessage());
        }

    }
   
}