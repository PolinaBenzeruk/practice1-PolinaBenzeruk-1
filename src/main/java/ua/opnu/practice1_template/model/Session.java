package ua.opnu.practice1_template.model;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "sessions")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Session {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title; // Назва сесії
    private LocalDateTime startTime; // Час початку
    private LocalDateTime endTime; // Час закінчення

    @ManyToOne
    @JoinColumn(name = "conference_id")
    private Conference conference; // Сесія належить одній конференції

    @OneToMany(mappedBy = "session", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Talk> talks; // Сесія має багато доповідей
}