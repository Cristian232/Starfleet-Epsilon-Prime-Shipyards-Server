package org.starfleet.epsilonprimeshipyards.service;

import org.springframework.stereotype.Service;
import org.starfleet.epsilonprimeshipyards.dto.MissionDTO;
import org.starfleet.epsilonprimeshipyards.mapper.MissionMapper;
import org.starfleet.epsilonprimeshipyards.model.Mission;
import org.starfleet.epsilonprimeshipyards.repository.MissionRepository;

import java.util.List;
import java.util.Optional;

@Service
public class MissionService {
    private final MissionRepository missionRepository;
    private final MissionMapper missionMapper;

    public MissionService(MissionRepository missionRepository, MissionMapper missionMapper) {
        this.missionRepository = missionRepository;
        this.missionMapper = missionMapper;
    }

    public MissionDTO getMissionById(Long missionId) {
        Optional<Mission> missionOptional = missionRepository.findById(missionId);
        return missionOptional.map(missionMapper::missionToMissionDTO).orElse(null);
    }

    public List<MissionDTO> getAllMissions() {
        List<Mission> missions = missionRepository.findAll();
        return missionMapper.missionsToMissionDTOs(missions);
    }

}
