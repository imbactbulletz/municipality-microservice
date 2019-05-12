package rs.edu.raf.si.lsd.dao;

import org.springframework.data.neo4j.repository.Neo4jRepository;
import rs.edu.raf.si.lsd.domain.entities.Region;

public interface RegionDao extends BaseDao<Region, String> {

    Region findByName(String name);
}
