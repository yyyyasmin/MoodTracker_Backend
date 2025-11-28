package Feelique.Backend.persistence.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

/**
 * Entity-Klasse für Mood-Einträge
 *
 * @Entity: Markiert diese Klasse als JPA-Entity (wird in Datenbank-Tabelle gemappt)
 * @Table: Definiert den Tabellennamen in der Datenbank
 */
@Entity
@Table(name = "mood_entries")
public class MoodEntry {

    /**
     * @Id: Primärschlüssel der Tabelle
     * @GeneratedValue: Automatische ID-Generierung durch die Datenbank
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * @Column: Definiert Spalten-Eigenschaften
     * nullable = false: Feld darf nicht leer sein
     */
    @Column(nullable = false)
    private String mood; // z.B. "happy", "neutral", "sad"

    @Column(length = 500)
    private String note; // Optionaler Kommentar (max. 500 Zeichen)

    @Column(nullable = false)
    private LocalDateTime timestamp; // Zeitpunkt des Eintrags

    // Konstruktoren
    public MoodEntry() {
        // Leerer Konstruktor für JPA erforderlich
    }

    public MoodEntry(String mood, String note, LocalDateTime timestamp) {
        this.mood = mood;
        this.note = note;
        this.timestamp = timestamp;
    }

    // Getter und Setter
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMood() {
        return mood;
    }

    public void setMood(String mood) {
        this.mood = mood;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }
}