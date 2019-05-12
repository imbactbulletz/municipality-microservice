package rs.edu.raf.si.lsd.dao;


import org.springframework.data.neo4j.repository.Neo4jRepository;
import rs.edu.raf.si.lsd.domain.entities.County;

public interface CountyDao extends BaseDao<County,String> {

    County findByName(String name);

}
