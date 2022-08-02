package es.mikostrategy.withcombinatorpattern.normal;

import java.time.LocalDate;

public record Customer(String name, String email, String phoneNumber, LocalDate dateOfBirth) {
}
