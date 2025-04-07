package ua.opnu.practice1_template.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.opnu.practice1_template.model.Attendee;
import ua.opnu.practice1_template.repository.attendeeRepository;

@Service
public class attendeeService {

    private final attendeeRepository attendeeRepository;

    @Autowired
    public attendeeService(attendeeRepository attendeeRepository) {
        this.attendeeRepository = attendeeRepository;
    }

    public Attendee createAttendee(Attendee attendee) {
        return attendeeRepository.save(attendee);
    }

    public Attendee getAttendeeById(Long id) {
        return attendeeRepository.findById(id).orElseThrow(() -> new RuntimeException("Attendee not found"));
    }

    public Attendee updateAttendee(Long id, Attendee updatedAttendee) {
        Attendee existingAttendee = getAttendeeById(id);
        existingAttendee.setName(updatedAttendee.getName());
        existingAttendee.setEmail(updatedAttendee.getEmail());
        return attendeeRepository.save(existingAttendee);
    }

    public void deleteAttendee(Long id) {
        attendeeRepository.deleteById(id);
    }
}