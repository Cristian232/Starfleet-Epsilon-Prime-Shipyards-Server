package org.starfleet.epsilonprimeshipyards.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.starfleet.epsilonprimeshipyards.model.Mission;

public interface MissionRepository extends JpaRepository<Mission, Long> {

}
