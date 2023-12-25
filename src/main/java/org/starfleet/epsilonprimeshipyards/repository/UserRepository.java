package org.starfleet.epsilonprimeshipyards.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.starfleet.epsilonprimeshipyards.model.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
