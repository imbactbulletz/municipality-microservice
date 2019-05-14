package rs.edu.raf.si.lsd.dao;

import org.springframework.data.neo4j.annotation.Query;
import rs.edu.raf.si.lsd.domain.entities.License;
import rs.edu.raf.si.lsd.domain.entities.Resident;

import java.util.List;

public interface ResidentDao extends BaseDao<Resident, Long>{

    Resident findByJmbg(String jmbg);

    @Query("MATCH (res:Resident) - [r*1..] - (t:Town) WHERE t.name = {0} RETURN res")
    List<Resident> findAllInTown(String townName);

    @Query("MATCH (res:Resident) - [r*1..] - (c:City) WHERE c.name = {0} RETURN res")
    List<Resident> findAllInCity(String cityName);

    @Query("MATCH (res:Resident) - [r*1..] - (m:Municipality) WHERE m.name = {0} RETURN res")
    List<Resident> findAllInMunicipality(String municipalityName);

    @Query("MATCH (res:Resident) - [r*1..] - (c:County) WHERE c.name = {0} RETURN res")
    List<Resident> findAllInCounty(String countyName);

    @Query("MATCH (res:Resident) - [r*1..] - (reg:Region) WHERE reg.name = {0} RETURN res")
    List<Resident> findAllInRegion(String regionName);
}
