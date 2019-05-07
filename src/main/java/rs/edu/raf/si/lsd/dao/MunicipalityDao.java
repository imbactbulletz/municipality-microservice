package rs.edu.raf.si.lsd.dao;

import org.springframework.data.neo4j.repository.Neo4jRepository;
import rs.edu.raf.si.lsd.domain.Municipality;

public interface MunicipalityDao extends Neo4jRepository <Municipality, Long> {

    Municipality findByName(String name);
}
