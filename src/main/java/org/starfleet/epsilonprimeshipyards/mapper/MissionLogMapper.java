package org.starfleet.epsilonprimeshipyards.mapper;

import org.springframework.stereotype.Component;
import org.starfleet.epsilonprimeshipyards.dto.MissionLogDTO;
import org.starfleet.epsilonprimeshipyards.model.MissionLog;

import java.util.ArrayList;
import java.util.List;

@Component
public class MissionLogMapper {
    public MissionLogDTO missionLogToMissionLogDTO(MissionLog missionLog) {
        if (missionLog == null) {
            return null;
        }

        MissionLogDTO missionLogDTO = new MissionLogDTO();

        return missionLogDTO;
    }

    public MissionLog missionLogDTOToMissionLog(MissionLogDTO missionLogDTO) {
        if (missionLogDTO == null) {
            return null;
        }

        MissionLog missionLog = new MissionLog();

        return missionLog;
    }

    public List<MissionLogDTO> missionLogsToMissionLogDTOs(List<MissionLog> missionLogs) {
        if (missionLogs == null) {
            return null;
        }

        List<MissionLogDTO> missionLogDTOs = new ArrayList<>();

        for (MissionLog missionLog : missionLogs) {
            missionLogDTOs.add(missionLogToMissionLogDTO(missionLog));
        }

        return missionLogDTOs;
    }
}