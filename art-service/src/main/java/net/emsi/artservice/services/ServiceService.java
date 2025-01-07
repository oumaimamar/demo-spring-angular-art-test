package net.emsi.artservice.services;

import net.emsi.artservice.dto.NewServiceDTO;
import net.emsi.artservice.entities.Artisan;
import net.emsi.artservice.entities.ServiceStatus;
import net.emsi.artservice.repository.ArtisanRepository;
import net.emsi.artservice.repository.ServiceRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;

@Service
@Transactional
public class ServiceService {

    private ServiceRepository serviceRepository;
    private ArtisanRepository artisanRepository;

    public ServiceService(ServiceRepository serviceRepository, ArtisanRepository artisanRepository) {
        this.serviceRepository = serviceRepository;
        this.artisanRepository = artisanRepository;
    }

//Create New Service
    public net.emsi.artservice.entities.Service saveService(MultipartFile file, NewServiceDTO newServiceDTO) throws IOException {
        Path folderPath = Paths.get(System.getProperty("user.home"),"emsi-artisans","services");
        if(!Files.exists(folderPath)){
            Files.createDirectories(folderPath);
        }
        String fileName = UUID.randomUUID().toString();
        Path filePath = Paths.get(System.getProperty("user.home"),"emsi-artisans","services",fileName+".pdf");
        Files.copy(file.getInputStream(), filePath);
        Artisan artisan = artisanRepository.findByCode(newServiceDTO.getArtisanCode());
        net.emsi.artservice.entities.Service service= net.emsi.artservice.entities.Service.builder()
                .type(newServiceDTO.getType())
                .status(ServiceStatus.EN_ARRET)
                .date(newServiceDTO.getDate())
                .artisan(artisan)
                .amount(newServiceDTO.getAmount())
                .file(filePath.toUri().toString())
                .build();
        return serviceRepository.save(service);
    }

    public byte[] getServiceFile(Long id) throws IOException {
        net.emsi.artservice.entities.Service service = serviceRepository.findById(id).get();
        return Files.readAllBytes(Path.of(URI.create(service.getFile())));
    }

    public net.emsi.artservice.entities.Service updateServiceStatus(ServiceStatus status, Long serviceId){
        net.emsi.artservice.entities.Service service = serviceRepository.findById(serviceId).get();
        service.setStatus(status);
        return serviceRepository.save(service);
    }

}
