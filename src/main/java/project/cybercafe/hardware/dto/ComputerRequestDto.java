package team.project.cybercafe.hardware.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import team.project.cybercafe.hardware.model.Computer;

public record ComputerRequestDto(
        @NotNull @Positive
        Long pcNumber,

        @NotNull
        Computer.ZoneType zoneType
) {}
