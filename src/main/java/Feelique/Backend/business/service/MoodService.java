package Feelique.Backend.business.service;

import Feelique.Backend.persistence.entity.MoodEntry;
import Feelique.Backend.persistence.repository.MoodEntryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

/**
 * Service-Schicht: Enthält die Business-Logik
 *
 * @Service: Markiert diese Klasse als Service-Komponente
 */
@Service
public class MoodService {

    /**
     * @Autowired: Spring injiziert automatisch das Repository
     * (Dependency Injection)
     */
    @Autowired
    private MoodEntryRepository repository;

    /**
     * Gibt alle Mood-Einträge zurück (neueste zuerst)
     */
    public List<MoodEntry> getAllMoodEntries() {
        return repository.findAllByOrderByTimestampDesc();
    }

    /**
     * Speichert einen neuen Mood-Eintrag
     */
    public MoodEntry saveMoodEntry(MoodEntry entry) {
        return repository.save(entry);
    }
}