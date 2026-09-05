package com.genai.GEN_AI_DEMO.controller;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.client.advisor.SimpleLoggerAdvisor;
import org.springframework.ai.chat.memory.ChatMemory;
import org.springframework.ai.document.Document;
import org.springframework.ai.vectorstore.SearchRequest;
import org.springframework.ai.vectorstore.VectorStore;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.ai.chat.memory.ChatMemory.CONVERSATION_ID;

@RestController
public class QdrantController {
   private ChatClient chatClient;
    private final VectorStore vectorStore;

    @Value("classpath:prompts/rag_system_template.st")
    private Resource systemTemplate;

    public QdrantController(VectorStore vectorStore, ChatClient chatClient) {
        this.vectorStore = vectorStore;
        this.chatClient = chatClient;
    }

    @GetMapping("/qdrant/test")
    public String testQdrant() {

        Document document = new Document(
                "Spring AI and Qdrant test document."
        );

        vectorStore.add(List.of(document));

        return "Document inserted successfully";
    }



    @GetMapping("/api/rag/answer")
    public String get(@RequestParam String prompt, String username) {
        SearchRequest searchRequest = SearchRequest.builder()
                                    .query(prompt)
                                    .topK(3) // retrieve top 3 relevant document from vector store
                                    .similarityThreshold(0.5).build();
        // A Augmentation
      //  List<Document> similiarDocument = vectorStore.similaritySearch(searchRequest);
        // extract the text content from the retrieved documents
      //  List<String> similiarResult = similiarDocument.stream().map(Document::getText).toList();


        // g - generation
        String result = chatClient.prompt()
                .advisors(new SimpleLoggerAdvisor())
//                .system(promptSystemSpec -> promptSystemSpec
//                                         .text(systemTemplate)
//                                        .param("documents",similiarResult))
                .advisors(adviceSpec -> adviceSpec.param(CONVERSATION_ID, username)
                ).user(prompt)
                .call()
                .content();
        return result;

    }

    @GetMapping("/qdrant/search")
    public List<Document> search(@RequestParam String prompt) {

        return vectorStore.similaritySearch(
                SearchRequest.builder()
                        .query(prompt)
                        .topK(3)
                        .build()
        );
    }
}