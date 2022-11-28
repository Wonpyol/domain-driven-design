package com.example.domain.item;

import lombok.*;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Getter
@DiscriminatorValue("album")
public class Album extends Item {
    private String artist;
    private String etc;
}
