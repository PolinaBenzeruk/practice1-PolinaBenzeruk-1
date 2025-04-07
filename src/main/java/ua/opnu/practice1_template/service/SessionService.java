package ua.opnu.practice1_template.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.opnu.practice1_template.model.Session;
import ua.opnu.practice1_template.repository.sessionRepository;

import java.util.List;

@Service
public class sessionService {

    private final sessionRepository sessionRepository;

    @Autowired
    public sessionService(sessionRepository sessionRepository) {
        this.sessionRepository = sessionRepository;
    }

    public List<Session> getAllSessions() {
        return sessionRepository.findAll();
    }

    public Session createSession(Session session) {
        return sessionRepository.save(session);
    }

    public Session getSessionById(Long id) {
        return sessionRepository.findById(id).orElseThrow(() -> new RuntimeException("Session not found"));
    }

    public Session updateSession(Long id, Session updatedSession) {
        Session existingSession = getSessionById(id);
        existingSession.setTitle(updatedSession.getTitle());
        existingSession.setStartTime(updatedSession.getStartTime());
        existingSession.setEndTime(updatedSession.getEndTime());
        return sessionRepository.save(existingSession);
    }

    public void deleteSession(Long id) {
        sessionRepository.deleteById(id);
    }
}