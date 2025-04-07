package ua.opnu.practice1_template.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.opnu.practice1_template.model.Talk;

public interface talkRepository extends JpaRepository<Talk, Long> {
}