package org.starfleet.epsilonprimeshipyards.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.starfleet.epsilonprimeshipyards.model.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
