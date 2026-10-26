package team.project.cybercafe.hardware.dto;

import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import team.project.cybercafe.hardware.model.Booking;

import java.time.LocalDateTime;

public record BookingRequestDto(
        @NotNull @Positive
        Long computerId,

        @NotNull @Positive
        Long userId,

        @NotNull @Positive
        Long tariffId,

        @NotNull @FutureOrPresent
        LocalDateTime startTime,

        @NotNull @FutureOrPresent
        LocalDateTime endTime,

        @NotNull
        Booking.PaymentStatus paymentStatus
) {}
