package com.edu.peims.repository;

import com.edu.peims.model.Wage;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.Collection;

public interface WageRepository extends CrudRepository<Wage,Integer> {

    @Query("select * from wage where PK_Wage_Date_s like :year and PK_FK_Wage_Id_nb = :id;")
    public Collection<Wage> findByYear(@Param("year") String year,@Param("id") int id);
    @Query("select * from wage where PK_Wage_Date_s = :date")
    public Collection<Wage> findMonthWage(@Param("date") String date);
    @Query("select * from wage where PK_Wage_Date_s = :date and PK_FK_Wage_Id_nb = :id;")
    public Wage findMonthWageById(@Param("date") String date,@Param("id") int id);
}
