package ua.opnu.practice1_template.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "talks")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Talk {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title; // Назва доповіді
    private String description; // Опис доповіді

    @ManyToOne
    @JoinColumn(name = "session_id")
    private Session session; // Доповідь належить сесії

    @ManyToOne
    @JoinColumn(name = "speaker_id")
    private Speaker speaker; // Доповідь має одного спікера
}