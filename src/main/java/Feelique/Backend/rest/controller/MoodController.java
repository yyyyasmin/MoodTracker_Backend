package Feelique.Backend.rest.controller;

import Feelique.Backend.business.service.MoodService;
import Feelique.Backend.persistence.entity.MoodEntry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

/**
 * REST-Controller: Definiert API-Endpunkte
 *
 * @RestController: Kombiniert @Controller + @ResponseBody
 * @RequestMapping: Basis-URL für alle Endpunkte in diesem Controller
 * @CrossOrigin: Erlaubt Anfragen vom Frontend (CORS)
 */
@RestController
@RequestMapping("/api/moods")
@CrossOrigin(origins = "*") // Später auf Frontend-URL einschränken
public class MoodController {

    @Autowired
    private MoodService moodService;

    /**
     * GET /api/moods
     * Gibt alle Mood-Einträge zurück
     *
     * @GetMapping: Definiert HTTP GET-Endpunkt
     */
    @GetMapping
    public ResponseEntity<List<MoodEntry>> getAllMoods() {
        List<MoodEntry> moods = moodService.getAllMoodEntries();
        return ResponseEntity.ok(moods);
    }

    /**
     * POST /api/moods
     * Erstellt einen neuen Mood-Eintrag
     *
     * @PostMapping: Definiert HTTP POST-Endpunkt
     * @RequestBody: JSON aus Request wird in MoodEntry umgewandelt
     */
    @PostMapping
    public ResponseEntity<MoodEntry> createMood(@RequestBody MoodEntry moodEntry) {
        // Setze Timestamp automatisch
        moodEntry.setTimestamp(LocalDateTime.now());

        MoodEntry saved = moodService.saveMoodEntry(moodEntry);
        return ResponseEntity.ok(saved);
    }
}