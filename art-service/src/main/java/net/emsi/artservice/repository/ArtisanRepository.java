package net.emsi.artservice.repository;

import net.emsi.artservice.entities.Artisan;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ArtisanRepository extends JpaRepository<Artisan, Long> {
    Artisan findByCode(String code);
    List<Artisan> findByProgramId(String programId);
}
