package com.ar.mikellbobadilla.app.genre;

import jakarta.persistence.*;
import lombok.*;

import static jakarta.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "genres")

@AllArgsConstructor @NoArgsConstructor
@Getter @Setter @Builder
@ToString @EqualsAndHashCode
public class Genre {
    @Id @GeneratedValue(strategy = IDENTITY)
    private Long id;
    @Column(length = 50, nullable = false, unique = true)
    private String name;
}
