package org.starfleet.epsilonprimeshipyards.mapper;

import org.springframework.stereotype.Component;
import org.starfleet.epsilonprimeshipyards.dto.MissionDTO;
import org.starfleet.epsilonprimeshipyards.model.Mission;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class MissionMapper {

    public MissionDTO missionToMissionDTO(Mission mission) {
        if (mission != null) {
            MissionDTO missionDTO = new MissionDTO();

            return missionDTO;
        }
        return null;
    }

    public Mission missionDTOToMission(MissionDTO missionDTO) {
        if (missionDTO != null) {
            Mission mission = new Mission();

            return mission;
        }
        return null;
    }

    public List<MissionDTO> missionsToMissionDTOs(List<Mission> missions) {
        return missions.stream()
                .map(this::missionToMissionDTO)
                .collect(Collectors.toList());
    }
}