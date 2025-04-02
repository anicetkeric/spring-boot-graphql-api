package com.bootlabs.springbootgraphqlapi.web;

import com.bootlabs.springbootgraphqlapi.entities.Author;
import com.bootlabs.springbootgraphqlapi.repositories.AuthorRepository;
import com.bootlabs.springbootgraphqlapi.repositories.BookRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.graphql.tester.AutoConfigureGraphQlTester;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.graphql.test.tester.GraphQlTester;
import org.springframework.test.context.jdbc.Sql;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;


@SpringBootTest
@AutoConfigureGraphQlTester
class BookGraphQLControllerTest {

    @Autowired
    private GraphQlTester graphQlTester;

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private AuthorRepository authorRepository;


    @Sql("classpath:/sql/data.sql")
    @Test
    void shouldGetFirstBook() {
        graphQlTester
                .documentName("bookDetails")
                .variable("id", 1)
                .execute()
                .path("getBook")
                .matchesJson("""
                            {
                                "id": "1",
                                "title": "Demo Spring boot graphQL",
                                "page": 416,
                                "isbn": "X4J-5H8",
                                "description": "This book covers the basics of Spring Boot and graphQL",
                                "author": {
                                 "id": "1",
                                  "firstname": "Bree",
                                  "lastname": "Nasim"
                                }
                            }
                        """);
    }


    @Test
    void shouldCreateNewAuthor() {
         int authorCount = authorRepository.findAll().size();
        String document = """
                      mutation {
                                           addAuthor(authorInput: {
                                               lastname: "Pilot Pen",
                                               firstname: "Gel-based ball point pen"
                                           }) {
                                               id
                                               lastname
                                               firstname
                                           }
                                       }
                """;

        graphQlTester.document(document)
                .execute()
                .path("addAuthor")
                .entity(Author.class)
                .satisfies(author -> {
                    assertNotNull(author.getId());
                    assertEquals("Gel-based ball point pen", author.getFirstname());
                });

          assertEquals(authorCount + 1, authorRepository.findAll().size());
    }
}
