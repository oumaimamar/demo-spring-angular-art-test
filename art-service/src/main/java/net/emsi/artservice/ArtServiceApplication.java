package net.emsi.artservice;

import net.emsi.artservice.entities.*;
import net.emsi.artservice.repository.ArtisanRepository;
import net.emsi.artservice.repository.ServiceRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;
import java.util.Random;

@SpringBootApplication
public class ArtServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ArtServiceApplication.class, args);
	}

//	@Bean
//	CommandLineRunner commandLineRunner(ArtisanRepository artisanRepository, ServiceRepository serviceRepository) {
//		return args -> {
//			artisanRepository.save(Artisan.builder().code("112233").userName("Mohamed").programId("GLSID").ville(Ville.CASABLANCA).build());
//			artisanRepository.save(Artisan.builder().code("112244").userName("Imane").programId("GLSID").ville(Ville.MARRAKESH).build());
//			artisanRepository.save(Artisan.builder().code("112255").userName("Aymane").programId("BDCC").ville(Ville.CASABLANCA).build());
//			artisanRepository.save(Artisan.builder().code("112266").userName("Lobna").programId("BDCC").ville(Ville.FES).build());
//
//			ServiceType[] serviceTypes= ServiceType.values();
//			Random random = new Random();
//			artisanRepository.findAll().forEach(art -> {
//				for(int i = 0; i < 10 ; i++){
//					int index = random.nextInt(serviceTypes.length);
//					Service service = Service.builder()
//							.date(LocalDate.now())
//							.amount(1000+(int)(Math.random()*100))
//							.type(serviceTypes[index])
//							.status(ServiceStatus.EN_ARRET)
//							.artisan(art)
//							.build();
//					serviceRepository.save(service);
//				}
//			});
//
//		};
//	}
}
