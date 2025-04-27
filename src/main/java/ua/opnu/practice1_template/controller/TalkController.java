package ua.opnu.practice1_template.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ua.opnu.practice1_template.model.Talk;
import ua.opnu.practice1_template.service.talkService;

import java.util.List;

@RestController
@RequestMapping("/api/talks")
public class talkController {

    private final talkService talkService;

    @Autowired
    public talkController(talkService talkService) {
        this.talkService = talkService;
    }

    @GetMapping
    public List<Talk> getAllTalks() {
        return talkService.getAllTalks();
    }

    @PostMapping
    public Talk createTalk(@RequestBody Talk talk) {
        return talkService.createTalk(talk);
    }

    @GetMapping("/{id}")
    public Talk getTalkById(@PathVariable Long id) {
        return talkService.getTalkById(id);
    }

    @PutMapping("/{id}")
    public Talk updateTalk(@PathVariable Long id, @RequestBody Talk talk) {
        return talkService.updateTalk(id, talk);
    }

    @DeleteMapping("/{id}")
    public void deleteTalk(@PathVariable Long id) {
        talkService.deleteTalk(id);
    }
}


