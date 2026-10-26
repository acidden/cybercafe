package team.project.cybercafe.hardware.dto;

import java.time.LocalDateTime;

public record BookingResponseDto(
        Long id,
        Long computerId,
        Long userId,
        Long tariffId,
        LocalDateTime startTime,
        LocalDateTime endTime
) {}
