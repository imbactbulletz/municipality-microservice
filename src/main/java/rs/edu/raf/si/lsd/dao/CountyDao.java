package rs.edu.raf.si.lsd.dao;


import org.springframework.data.neo4j.repository.Neo4jRepository;
import rs.edu.raf.si.lsd.domain.County;

public interface CountyDao extends Neo4jRepository<County, String> {

    County findByName(String name);
}
