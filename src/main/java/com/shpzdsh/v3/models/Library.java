package com.shpzdsh.v3.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.io.Serializable;

@Getter
@Setter
@Accessors(chain = true)
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "library")
public class Library implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_book")
    private int id_book;

    @Column(name = "name_book")
    private String name_book;

    @Column(name = "author_book")
    private String author_book;

    @Column(name = "year_book")
    private int year_book;

    @Column(name = "quantity")
    private int quantity;


}
