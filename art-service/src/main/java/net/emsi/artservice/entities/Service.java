package net.emsi.artservice.entities;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@NoArgsConstructor @AllArgsConstructor @Getter @Setter @ToString @Builder
public class Service {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDate date;
    private double amount;
    @Enumerated(EnumType.STRING)
    private ServiceType type;
    @Enumerated(EnumType.STRING)
    private ServiceStatus status;
    private String file;
    @ManyToOne
    private Artisan artisan;

}
