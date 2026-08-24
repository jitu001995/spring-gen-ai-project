package com.genai.GEN_AI_DEMO.model;

import jakarta.annotation.PostConstruct;
import org.springframework.ai.document.Document;
import org.springframework.ai.vectorstore.VectorStore;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class RagSampleDataLoader {

    private final VectorStore vectorStore;

    public RagSampleDataLoader(VectorStore vectorStore) {
        this.vectorStore = vectorStore;
    }

   // @PostConstruct
    public void loadSampleData() {

        List<Document> documents = List.of(

                // =====================================================
                // SPRING BOOT
                // =====================================================

                new Document("""
                        Spring Boot is a Java framework used to create
                        production-ready backend applications. It provides
                        auto-configuration, dependency injection, embedded
                        servers, REST API support, database integrations,
                        security, and many other features.
                        """),

                new Document("""
                        Spring Boot applications commonly use dependency
                        injection to manage objects and their dependencies.
                        Beans can be created using annotations such as
                        @Component, @Service, @Repository, and @Controller.
                        """),

                new Document("""
                        Spring Boot provides an embedded web server such as
                        Tomcat. This allows developers to run a web application
                        without deploying the application manually to an
                        external application server.
                        """),

                // =====================================================
                // SPRING AI
                // =====================================================

                new Document("""
                        Spring AI is a framework that provides abstractions
                        for integrating artificial intelligence models with
                        Spring Boot applications. It supports chat models,
                        embedding models, vector stores, document readers,
                        advisors, and Retrieval Augmented Generation.
                        """),

                new Document("""
                        A VectorStore in Spring AI provides a common abstraction
                        for storing documents and their vector embeddings and
                        performing similarity searches against those documents.
                        """),

                new Document("""
                        An embedding is a numerical representation of text.
                        Text with similar meanings generally produces vectors
                        that are close together in vector space. Embeddings are
                        commonly used for semantic search and RAG applications.
                        """),

                // =====================================================
                // QDRANT
                // =====================================================

                new Document("""
                        Qdrant is a vector database designed for storing and
                        searching high-dimensional vectors. It is commonly used
                        in artificial intelligence applications for semantic
                        search and Retrieval Augmented Generation.
                        """),

                new Document("""
                        A Qdrant collection contains vectors and associated
                        payload data. Applications can search the collection
                        using vector similarity to find information that is
                        semantically related to a query.
                        """),

                // =====================================================
                // RAG
                // =====================================================

                new Document("""
                        Retrieval Augmented Generation, commonly called RAG,
                        combines information retrieval with a large language
                        model. Documents are converted into embeddings and
                        stored in a vector database. When a user asks a question,
                        relevant documents are retrieved and provided as context
                        to the language model.
                        """),

                new Document("""
                        A typical RAG pipeline consists of document ingestion,
                        document splitting, embedding generation, vector storage,
                        similarity search, context retrieval, and generation of
                        the final answer using a language model.
                        """),

                new Document("""
                        Semantic search finds information based on meaning
                        rather than requiring an exact keyword match. Vector
                        embeddings make semantic search possible by representing
                        text as numerical vectors.
                        """),

                // =====================================================
                // ECONOMICS
                // =====================================================

                new Document("""
                        Gross Domestic Product, or GDP, measures the monetary
                        value of final goods and services produced within a
                        country during a specific period. GDP is commonly used
                        to measure the size and growth of an economy.
                        """),

                new Document("""
                        GDP growth represents the change in the economic output
                        of a country over time. Positive GDP growth generally
                        indicates that economic production is increasing, while
                        negative growth indicates that economic activity is
                        declining.
                        """),

                new Document("""
                        Inflation is the sustained increase in the general price
                        level of goods and services in an economy. When inflation
                        increases, the purchasing power of money generally
                        decreases.
                        """),

                new Document("""
                        The Consumer Price Index, or CPI, measures changes in the
                        prices paid by consumers for a basket of goods and services.
                        CPI is commonly used as an indicator of consumer inflation.
                        """),

                new Document("""
                        The unemployment rate represents the percentage of people
                        in the labor force who are actively looking for work but
                        do not currently have a job. It is an important indicator
                        of labor market conditions.
                        """),

                new Document("""
                        Interest rates influence borrowing, saving, investment,
                        and consumption. When interest rates increase, borrowing
                        generally becomes more expensive, which can reduce spending
                        and investment.
                        """),

                new Document("""
                        Monetary policy refers to actions taken by a central bank
                        to influence interest rates, money supply, credit conditions,
                        and economic activity. Central banks may adjust monetary
                        policy to control inflation and support economic stability.
                        """),

                new Document("""
                        Fiscal policy refers to government decisions about taxation
                        and public spending. Governments can increase spending or
                        reduce taxes to stimulate economic activity, while reducing
                        spending or increasing taxes can help control demand.
                        """),

                new Document("""
                        Supply and demand are fundamental economic concepts.
                        Demand represents the quantity of a good or service consumers
                        are willing to purchase, while supply represents the quantity
                        producers are willing to sell. Prices are influenced by the
                        interaction between supply and demand.
                        """),

                new Document("""
                        The central bank can use interest rates as a tool to
                        influence economic activity. Higher interest rates can
                        discourage borrowing and spending, while lower interest
                        rates can encourage borrowing, investment, and consumption.
                        """),

                // =====================================================
                // CRICKET
                // =====================================================

                new Document("""
                        Cricket is a bat-and-ball sport played between two teams.
                        Each team normally has eleven players. Major formats of
                        cricket include Test cricket, One Day Internationals,
                        and Twenty20 cricket.
                        """),

                new Document("""
                        A run is scored in cricket when batters successfully
                        change ends after hitting the ball, or when boundary
                        rules award runs. A four is scored when the ball reaches
                        the boundary after touching the ground, while a six is
                        scored when the ball reaches the boundary without
                        touching the ground.
                        """),

                new Document("""
                        An economy rate in cricket measures how many runs a
                        bowler concedes per over. It is calculated by dividing
                        the runs conceded by the number of overs bowled.
                        A lower economy rate generally indicates that a bowler
                        has conceded fewer runs.
                        """),

                new Document("""
                        If a bowler concedes 24 runs in 4 overs, the bowling
                        economy rate is 6.00 runs per over. Economy rate is an
                        important bowling statistic, especially in limited-overs
                        cricket.
                        """),

                new Document("""
                        A bowler's strike rate is the average number of balls
                        required to take one wicket. It can be calculated by
                        dividing the number of balls bowled by the number of
                        wickets taken. A lower bowling strike rate generally
                        indicates that a bowler takes wickets more frequently.
                        """),

                new Document("""
                        A batter's strike rate in limited-overs cricket represents
                        the number of runs scored per 100 balls faced. It is
                        calculated by dividing runs scored by balls faced and
                        multiplying the result by 100.
                        """),

                new Document("""
                        In Twenty20 cricket, each team normally has a maximum
                        of 20 overs to bat. T20 cricket emphasizes fast scoring,
                        aggressive batting, strategic bowling changes, and
                        effective fielding.
                        """),

                new Document("""
                        In One Day International cricket, each team normally has
                        a maximum of 50 overs to bat. ODI cricket combines elements
                        of aggressive limited-overs batting with longer tactical
                        phases than Twenty20 cricket.
                        """),

                new Document("""
                        Test cricket is the longest traditional format of cricket.
                        A Test match can last up to five days and each team normally
                        has two innings. Test cricket places significant importance
                        on batting technique, bowling endurance, partnerships,
                        pitch conditions, and tactical decision-making.
                        """),

                new Document("""
                        The Duckworth-Lewis-Stern method, commonly called DLS,
                        is used in limited-overs cricket matches affected by
                        rain or other interruptions. It adjusts targets based
                        on the resources available to each team, including
                        overs remaining and wickets available.
                        """),

                new Document("""
                        A cricket all-rounder is a player who contributes
                        significantly with both batting and bowling. All-rounders
                        provide teams with additional tactical flexibility because
                        they can contribute in multiple disciplines.
                        """),

                new Document("""
                        A cricket partnership refers to the runs scored by two
                        batters while they are batting together. Partnerships are
                        important because they can stabilize an innings and help
                        a team build a large total.
                        """),

                // =====================================================
                // INDIA / ECONOMY + CRICKET
                // =====================================================

                new Document("""
                        India has one of the world's largest economies and cricket
                        is one of the country's most popular sports. Both economics
                        and cricket have significant cultural and commercial
                        importance in India.
                        """),

                new Document("""
                        The Indian Premier League, commonly known as the IPL,
                        is a professional Twenty20 cricket league. It uses a
                        franchise-based structure and attracts players from
                        different cricket-playing countries.
                        """),

                new Document("""
                        Cricket leagues can generate economic activity through
                        broadcasting rights, sponsorships, ticket sales,
                        merchandise, advertising, tourism, and employment.
                        Large sporting events can therefore have significant
                        commercial effects.
                        """),

                new Document("""
                        The relationship between sports and economics can be
                        studied through areas such as player salaries, sponsorship
                        revenue, broadcasting rights, stadium investment, ticket
                        prices, advertising revenue, and the economic impact of
                        sporting events on local businesses.
                        """),

        new Document("""
        Virat Kohli is an Indian international cricketer, widely regarded
        as one of the greatest batters of his generation. He has played
        for the Indian national team across Test, ODI, and T20 formats,
        and has captained the Indian Premier League team Royal Challengers
        Bengaluru.
        """)

        );

        vectorStore.add(documents);

        System.out.println(
                "=============================================="
        );
        System.out.println(
                "Sample RAG data loaded successfully!"
        );
        System.out.println(
                "Total documents: " + documents.size()
        );
        System.out.println(
                "=============================================="
        );
    }
}