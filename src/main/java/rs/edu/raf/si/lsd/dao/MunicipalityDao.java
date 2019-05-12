package rs.edu.raf.si.lsd.dao;

import org.springframework.data.neo4j.repository.Neo4jRepository;
import rs.edu.raf.si.lsd.domain.entities.Municipality;

public interface MunicipalityDao extends BaseDao<Municipality, String> {

    Municipality findByName(String name);
}
