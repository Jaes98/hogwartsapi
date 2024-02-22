package kea.exercise.hogwartsapi.repositories;

import kea.exercise.hogwartsapi.models.House;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HouseRepository extends JpaRepository<House, Integer> {
}
