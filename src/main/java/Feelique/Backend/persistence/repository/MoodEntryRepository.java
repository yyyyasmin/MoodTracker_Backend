package Feelique.Backend.persistence.repository;

import Feelique.Backend.persistence.entity.MoodEntry;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

/**
 * Repository-Interface für Datenbankzugriffe
 *
 * JpaRepository bietet automatisch CRUD-Methoden:
 * - save(), findAll(), findById(), delete() etc.
 */
@Repository
public interface MoodEntryRepository extends JpaRepository<MoodEntry, Long> {

    /**
     * Spring Data JPA erstellt automatisch die Implementierung
     * basierend auf dem Methodennamen
     *
     * Findet alle Einträge, sortiert nach Timestamp absteigend (neueste zuerst)
     */
    List<MoodEntry> findAllByOrderByTimestampDesc();
}