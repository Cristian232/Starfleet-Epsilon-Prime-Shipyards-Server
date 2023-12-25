package org.starfleet.epsilonprimeshipyards.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class MissionLogDTO {
    private Long id;
    private UserDTO user;
    private MissionDTO mission;
    private LocalDateTime completionTime;

}
