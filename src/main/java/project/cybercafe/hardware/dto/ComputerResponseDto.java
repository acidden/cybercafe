package team.project.cybercafe.hardware.dto;

import team.project.cybercafe.hardware.model.Computer;

public record ComputerResponseDto(
        Long id,
        Long pcNumber,
        Computer.ZoneType zoneType,
        Computer.Status status
) {}
