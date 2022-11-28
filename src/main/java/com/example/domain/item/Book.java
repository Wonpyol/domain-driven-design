package com.example.domain.item;

import com.example.domain.Category;
import lombok.*;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.util.List;


@Entity
@Getter @Setter
@DiscriminatorValue("book")
public class Book extends Item {
    private String author;
    private String isbn;
}
