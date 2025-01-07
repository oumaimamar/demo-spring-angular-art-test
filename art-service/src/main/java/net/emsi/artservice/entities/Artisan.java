package net.emsi.artservice.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@NoArgsConstructor @AllArgsConstructor @Getter @Setter @ToString @Builder
public class Artisan {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private String code;
    private String userName;
    private String email;
    private String programId;
    private String photo;
    @Enumerated(EnumType.STRING)
    private Ville ville;

}
