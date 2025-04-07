package ua.opnu.practice1_template.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.opnu.practice1_template.model.Talk;
import ua.opnu.practice1_template.repository.talkRepository;

@Service
public class talkService {

    private final talkRepository talkRepository;

    @Autowired
    public talkService(talkRepository talkRepository) {
        this.talkRepository = talkRepository;
    }

    public Talk createTalk(Talk talk) {
        return talkRepository.save(talk);
    }

    public Talk getTalkById(Long id) {
        return talkRepository.findById(id).orElseThrow(() -> new RuntimeException("Talk not found"));
    }

    public Talk updateTalk(Long id, Talk updatedTalk) {
        Talk existingTalk = getTalkById(id);
        existingTalk.setTitle(updatedTalk.getTitle());
        existingTalk.setDescription(updatedTalk.getDescription());
        return talkRepository.save(existingTalk);
    }

    public void deleteTalk(Long id) {
        talkRepository.deleteById(id);
    }
}