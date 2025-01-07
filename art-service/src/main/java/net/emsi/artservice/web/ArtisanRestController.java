package net.emsi.artservice.web;

import net.emsi.artservice.dto.NewServiceDTO;
import net.emsi.artservice.entities.Artisan;
import net.emsi.artservice.entities.Service;
import net.emsi.artservice.entities.ServiceStatus;
import net.emsi.artservice.entities.ServiceType;
import net.emsi.artservice.repository.ArtisanRepository;
import net.emsi.artservice.repository.ServiceRepository;
import net.emsi.artservice.services.ServiceService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

@RestController
public class ArtisanRestController {
    private ArtisanRepository artisanRepository;
    private ServiceRepository serviceRepository;

    private ServiceService serviceService;


    public ArtisanRestController(ArtisanRepository artisanRepository, ServiceRepository serviceRepository, ServiceService serviceService) {
        this.artisanRepository = artisanRepository;
        this.serviceRepository = serviceRepository;
        this.serviceService = serviceService;
    }

    @GetMapping(path = "/artisans")
    public List<Artisan> AllArtisans() {
        return artisanRepository.findAll();
    }
    @GetMapping("/artisans/{code}")
    public Artisan getArtisanByCode(@PathVariable String code){
        return artisanRepository.findByCode(code);
    }

    @GetMapping(path = "/artisansByProgram")
    public List<Artisan> artisansByProgram(@RequestParam String programId){return artisanRepository.findByProgramId(programId);}



    @GetMapping(path = "/services")
    public List<Service> allServices() {return serviceRepository.findAll();}

    @GetMapping("/services/{id}")
    public Service getServiceById(@PathVariable Long id){
        return serviceRepository.findById(id).get();
    }

    @GetMapping("/artisans/{code}/services")
    public List<Service> paymentsByStudentCode(@PathVariable String code){return serviceRepository.findByArtisanCode(code);}

    @GetMapping("/servicesByType")
    public List<Service> servicesByType(@RequestParam ServiceType type){return serviceRepository.findByType(type);}


    @GetMapping("/servicesByStatus")
    public List<Service> servicesByStatus(@RequestParam ServiceStatus status){return serviceRepository.findByStatus(status);}


//  --------------------------------------------------------------------------------------------------------------------------
//  --------------------------------------------------------------------------------------------------------------------------

    //Pour Modifier un status d'un Service
    @PutMapping("/services/{serviceId}/updateStatus")
    public Service updateServiceStatus(@RequestParam ServiceStatus status, @PathVariable Long serviceId){
        return serviceService.updateServiceStatus(status,serviceId);
    }

    //Add new service declare EX: "amount": 3333333, "type": "DEPANAGE", "date": "2025-01-06", "artisanCode": "112233"
    @PostMapping(path="/services", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public Service saveService(@RequestParam("file") MultipartFile file, NewServiceDTO newServiceDTO) throws IOException {
        return serviceService.saveService(file,newServiceDTO);
    }

    @GetMapping(path="services/{id}/file",produces = MediaType.APPLICATION_PDF_VALUE)
    public byte[] getServiceFile(@PathVariable Long id) throws IOException {
        return serviceService.getServiceFile(id);
    }

//    @GetMapping(path="serviceFile/{serviceId}",produces = MediaType.APPLICATION_PDF_VALUE)
//    public byte[] getServiceFile(@PathVariable Long serviceId) throws IOException {
//        Service service = serviceRepository.findById(serviceId).get();
//        return Files.readAllBytes(Path.of(URI.create(service.getFile())));
//    }


}
