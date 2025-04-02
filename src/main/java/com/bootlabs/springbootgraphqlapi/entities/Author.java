package com.bootlabs.springbootgraphqlapi.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import java.util.Collection;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotBlank
    private String lastname;

    private String firstname;

    @OneToMany(mappedBy = "author", fetch = FetchType.EAGER)
    private Collection<Book> books;
}
