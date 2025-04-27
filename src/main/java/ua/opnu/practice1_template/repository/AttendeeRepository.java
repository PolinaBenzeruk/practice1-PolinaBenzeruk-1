package ua.opnu.practice1_template.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.opnu.practice1_template.model.Attendee;

public interface AttendeeRepository extends JpaRepository<Attendee, Long> {
}