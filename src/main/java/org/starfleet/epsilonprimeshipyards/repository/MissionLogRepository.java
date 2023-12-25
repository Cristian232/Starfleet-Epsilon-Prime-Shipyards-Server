package org.starfleet.epsilonprimeshipyards.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.starfleet.epsilonprimeshipyards.model.MissionLog;

public interface MissionLogRepository extends JpaRepository<MissionLog, Long> {

}
