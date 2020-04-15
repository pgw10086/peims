package com.edu.peims.repository;

import com.edu.peims.model.Position;
import com.edu.peims.model.Wage;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public interface PositionRepository extends CrudRepository<Position,Integer> {
    @Query("select * from position where Position_Name_s like :name")
    public Collection<Position> findPositionByName(@Param("name") String name);
    @Query("select * from position where PK_Position_Id_nb = :id")
    public Collection<Position> findPositionById(@Param("id") int id);
}
