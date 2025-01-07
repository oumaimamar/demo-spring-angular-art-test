package net.emsi.artservice.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import net.emsi.artservice.entities.ServiceType;

import java.time.LocalDate;

@Getter @Setter @AllArgsConstructor @NoArgsConstructor
public class NewServiceDTO {
    private double amount;
    private ServiceType type;
    private LocalDate date;
    private String artisanCode;
}
