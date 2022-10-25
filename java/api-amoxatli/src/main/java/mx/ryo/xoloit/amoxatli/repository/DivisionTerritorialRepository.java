package mx.ryo.xoloit.amoxatli.repository;

import org.springframework.data.repository.CrudRepository;

import mx.ryo.xoloit.amoxatli.beans.entity.DivisionTerritorial;
import mx.ryo.xoloit.amoxatli.beans.entity.embedable.DivisionTerritorialIdentity;

public interface DivisionTerritorialRepository extends CrudRepository<DivisionTerritorial, DivisionTerritorialIdentity> {

}
