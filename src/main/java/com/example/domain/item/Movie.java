package com.example.domain.item;

import lombok.*;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Getter
@DiscriminatorValue("movie")
public class Movie extends Item{
    private String director;
    private String actor;
}
