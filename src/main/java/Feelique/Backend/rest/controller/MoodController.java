package Feelique.Backend.rest.controller;

import Feelique.Backend.business.service.MoodService;
import Feelique.Backend.persistence.entity.MoodEntry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/moods")
@CrossOrigin(origins = {
        "http://localhost:5173",
        "https://moodtracker-frontend-wcho.onrender.com"
})
public class MoodController {

    @Autowired
    private MoodService moodService;

    @GetMapping
    public ResponseEntity<List<MoodEntry>> getAllMoods() {
        List<MoodEntry> moods = moodService.getAllMoodEntries();
        return ResponseEntity.ok(moods);
    }

    @PostMapping
    public ResponseEntity<MoodEntry> createMood(@RequestBody MoodEntry moodEntry) {
        moodEntry.setTimestamp(LocalDateTime.now());
        MoodEntry saved = moodService.saveMoodEntry(moodEntry);
        return ResponseEntity.ok(saved);
    }
}