package ua.opnu.practice1_template.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.opnu.practice1_template.model.Speaker;
import ua.opnu.practice1_template.repository.speakerRepository;

@Service
public class speakerService {

    private final speakerRepository speakerRepository;

    @Autowired
    public speakerService(speakerRepository speakerRepository) {
        this.speakerRepository = speakerRepository;
    }

    public Speaker createSpeaker(Speaker speaker) {
        return speakerRepository.save(speaker);
    }

    public Speaker getSpeakerById(Long id) {
        return speakerRepository.findById(id).orElseThrow(() -> new RuntimeException("Speaker not found"));
    }

    public Speaker updateSpeaker(Long id, Speaker updatedSpeaker) {
        Speaker existingSpeaker = getSpeakerById(id);
        existingSpeaker.setName(updatedSpeaker.getName());
        existingSpeaker.setBiography(updatedSpeaker.getBiography());
        return speakerRepository.save(existingSpeaker);
    }

    public void deleteSpeaker(Long id) {
        speakerRepository.deleteById(id);
    }
}