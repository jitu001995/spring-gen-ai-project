package com.genai.GEN_AI_DEMO.model;

import jakarta.annotation.PostConstruct;
import org.springframework.ai.reader.tika.TikaDocumentReader;
import org.springframework.ai.transformer.splitter.TextSplitter;
import org.springframework.ai.transformer.splitter.TokenTextSplitter;
import org.springframework.ai.vectorstore.VectorStore;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.ai.document.Document;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class RAGPdfDataLoader {

    private final VectorStore vectorStore;
    @Value("classpath:AcmeNova_Employee_Handbook_RAG.pdf")
    Resource pdfResource;

    public RAGPdfDataLoader(VectorStore vectorStore){
        this.vectorStore = vectorStore;
    }

    @PostConstruct
    public void loadPdfDataLoader(){
        TikaDocumentReader documentReader = new TikaDocumentReader(pdfResource);
       List<Document> documents = documentReader.get();
       TextSplitter textsplitter = TokenTextSplitter.builder()
                        .withChunkSize(50)
                         .withMaxNumChunks(200)
                                .build();

       List<Document> documentChuncks = textsplitter.split(documents);
       vectorStore.add(documentChuncks);
       System.out.println("Added chunk data");
    }
}
