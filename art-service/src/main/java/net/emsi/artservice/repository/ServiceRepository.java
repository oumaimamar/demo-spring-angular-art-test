package net.emsi.artservice.repository;

import net.emsi.artservice.entities.Service;
import net.emsi.artservice.entities.ServiceStatus;
import net.emsi.artservice.entities.ServiceType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ServiceRepository extends JpaRepository<Service, Long> {
    List<Service> findByArtisanCode(String code);
    List<Service> findByStatus(ServiceStatus status);
    List<Service> findByType(ServiceType type);
}
