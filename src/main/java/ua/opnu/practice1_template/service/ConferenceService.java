package ua.opnu.practice1_template.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.opnu.practice1_template.model.Conference;
import ua.opnu.practice1_template.repository.conferenceRepository;

import java.util.List;

@Service
public class conferenceService {

    private final conferenceRepository conferenceRepository;

    @Autowired
    public conferenceService(conferenceRepository conferenceRepository) {
        this.conferenceRepository = conferenceRepository;
    }

    public List<Conference> getAllConferences() {
        return conferenceRepository.findAll();
    }

    public Conference createConference(Conference conference) {
        return conferenceRepository.save(conference);
    }

    public Conference getConferenceById(Long id) {
        return conferenceRepository.findById(id).orElseThrow(() -> new RuntimeException("Conference not found"));
    }

    public Conference updateConference(Long id, Conference updatedConference) {
        Conference existingConference = getConferenceById(id);
        existingConference.setName(updatedConference.getName());
        existingConference.setLocation(updatedConference.getLocation());
        existingConference.setDescription(updatedConference.getDescription());
        return conferenceRepository.save(existingConference);
    }

    public void deleteConference(Long id) {
        conferenceRepository.deleteById(id);
    }
}