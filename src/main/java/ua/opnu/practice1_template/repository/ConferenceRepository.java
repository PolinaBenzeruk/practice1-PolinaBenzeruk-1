package ua.opnu.practice1_template.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.opnu.practice1_template.model.Conference;

public interface ConferenceRepository extends JpaRepository<Conference, Long> {
}