package javastart28zadaniezajecia.demo.repository;

import javastart28zadaniezajecia.demo.model.building.Building;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BuildingRepository extends JpaRepository<Building, Long> {

}
