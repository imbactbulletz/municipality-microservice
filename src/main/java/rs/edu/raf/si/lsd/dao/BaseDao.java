package rs.edu.raf.si.lsd.dao;

import org.neo4j.ogm.annotation.NodeEntity;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import rs.edu.raf.si.lsd.domain.entities.City;
import rs.edu.raf.si.lsd.domain.entities.TerritorialUnit;

import java.io.Serializable;

public interface BaseDao<T extends TerritorialUnit,ID extends Serializable> extends Neo4jRepository<T,ID> {

}
