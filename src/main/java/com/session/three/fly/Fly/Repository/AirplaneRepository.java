package com.session.three.fly.Fly.Repository;

import com.session.three.fly.Fly.Model.Entity.Airplane;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AirplaneRepository extends CrudRepository<Airplane, Integer> {

    @Query(value = "SELECT * FROM airplane WHERE name = :name", nativeQuery = true)
    Airplane getAirplaneByName(String name);
}
