package es.mikostrategy.withcombinatorpattern.combining;

import java.time.LocalDate;

public record Customer(String name, String email, String phoneNumber, LocalDate dateOfBirth) {
}
