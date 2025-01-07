package net.youssfi.demoensetstudents.entities;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.transaction.annotation.Transactional;

@Entity
@NoArgsConstructor @AllArgsConstructor @Getter @Setter @ToString @Builder
public class Student {
    @Id
    private String id;
    @Column(unique = true)
    private String code;
    private String firstName;
    private String lastName;
    private String programId;
    private String photo;
}
