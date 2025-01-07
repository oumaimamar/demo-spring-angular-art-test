package net.youssfi.demoensetstudents.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import net.youssfi.demoensetstudents.entities.PaymentType;

import java.time.LocalDate;

@Getter @Setter @AllArgsConstructor @NoArgsConstructor
public class NewPaymentDTO {
    private double amount;
    private PaymentType type;
    private LocalDate date;
    private String studentCode;
}
