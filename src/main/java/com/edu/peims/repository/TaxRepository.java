package com.edu.peims.repository;

import com.edu.peims.model.Tax;
import com.edu.peims.model.Wage;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public interface TaxRepository extends CrudRepository<Tax, Integer> {
    @Query("select * from tax where Tax_MoneyEnd_f < :end;")
    public Collection<Tax> findTaxByEnd(@Param("end") float end);

    @Query("select * from tax where Tax_MoneyStart_f > :start;")
    public Collection<Tax> findTaxByStart(@Param("start") float start);

    @Query("select * from tax where Tax_MoneyEnd_f < :end and Tax_MoneyStart_f > :start")
    public Collection<Tax> findTaxBy(@Param("end") float end, @Param("start") float start);

    @Query("select * from tax where Tax_MoneyEnd_f > :wage and Tax_MoneyStart_f < :wage")
    public Tax findWageTax(@Param("wage") float wage);
}
