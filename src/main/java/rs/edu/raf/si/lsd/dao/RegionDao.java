package rs.edu.raf.si.lsd.dao;

import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import rs.edu.raf.si.lsd.domain.County;
import rs.edu.raf.si.lsd.domain.Region;

public interface RegionDao extends Neo4jRepository <Region, String> {

}
