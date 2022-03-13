package com.session.three.fly.Fly.Repository;

import com.session.three.fly.Fly.Model.Entity.Fly;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FlyRepository extends CrudRepository<Fly, Integer> {

    @Query(value = "SELECT * FROM fly WHERE Fly_code = :flyCode", nativeQuery = true)
    Fly getFlyByCode(String flyCode);

}
