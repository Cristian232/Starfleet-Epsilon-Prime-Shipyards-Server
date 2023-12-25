package org.starfleet.epsilonprimeshipyards.service;

import org.springframework.stereotype.Service;
import org.starfleet.epsilonprimeshipyards.dto.MissionLogDTO;
import org.starfleet.epsilonprimeshipyards.mapper.MissionLogMapper;
import org.starfleet.epsilonprimeshipyards.model.MissionLog;
import org.starfleet.epsilonprimeshipyards.repository.MissionLogRepository;

import java.util.List;
import java.util.Optional;

@Service
public class MissionLogService {
    private final MissionLogRepository missionLogRepository;
    private final MissionLogMapper missionLogMapper;

    public MissionLogService(MissionLogRepository missionLogRepository, MissionLogMapper missionLogMapper) {
        this.missionLogRepository = missionLogRepository;
        this.missionLogMapper = missionLogMapper;
    }

    public MissionLogDTO getMissionLogById(Long missionLogId) {
        Optional<MissionLog> missionLogOptional = missionLogRepository.findById(missionLogId);
        return missionLogOptional.map(missionLogMapper::missionLogToMissionLogDTO).orElse(null);
    }

    public List<MissionLogDTO> getAllMissionLogs() {
        List<MissionLog> missionLogs = missionLogRepository.findAll();
        return missionLogMapper.missionLogsToMissionLogDTOs(missionLogs);
    }

}
