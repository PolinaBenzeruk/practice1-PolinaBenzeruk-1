package ua.opnu.practice1_template.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ua.opnu.practice1_template.model.Speaker;
import ua.opnu.practice1_template.service.speakerService;

import java.util.List;

@RestController
@RequestMapping("/api/speakers")
public class speakerController {

    private final speakerService speakerService;

    @Autowired
    public speakerController(speakerService speakerService) {
        this.speakerService = speakerService;
    }

    @GetMapping
    public List<Speaker> getAllSpeakers() {
        return speakerService.getAllSpeakers();
    }

    @PostMapping
    public Speaker createSpeaker(@RequestBody Speaker speaker) {
        return speakerService.createSpeaker(speaker);
    }

    @GetMapping("/{id}")
    public Speaker getSpeakerById(@PathVariable Long id) {
        return speakerService.getSpeakerById(id);
    }

    @PutMapping("/{id}")
    public Speaker updateSpeaker(@PathVariable Long id, @RequestBody Speaker speaker) {
        return speakerService.updateSpeaker(id, speaker);
    }

    @DeleteMapping("/{id}")
    public void deleteSpeaker(@PathVariable Long id) {
        speakerService.deleteSpeaker(id);
    }
}