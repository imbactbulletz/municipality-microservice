package rs.edu.raf.si.lsd.dao;

import org.springframework.data.neo4j.annotation.Query;
import rs.edu.raf.si.lsd.domain.entities.Parcel;
import rs.edu.raf.si.lsd.domain.entities.Resident;

import java.util.List;

public interface ParcelDao extends BaseDao<Parcel, String> {

    Parcel findByParcelNumber(String name);


    @Query("MATCH (p:Parcel) - [r*1..] - (t:Town) WHERE t.name = {0} RETURN p")
    List<Parcel> findAllInTown(String townName);

    @Query("MATCH (p:Parcel) - [r*1..] - (c:City) WHERE c.name = {0} RETURN p")
    List<Parcel> findAllInCity(String cityName);

    @Query("MATCH (p:Parcel) - [r*1..] - (m:Municipality) WHERE m.name = {0} RETURN p")
    List<Parcel> findAllInMunicipality(String municipalityName);

    @Query("MATCH (p:Parcel) - [r*1..] - (c:County) WHERE c.name = {0} RETURN p")
    List<Parcel> findAllInCounty(String countyName);

    @Query("MATCH (p:Parcel) - [r*1..] - (reg:Region) WHERE reg.name = {0} RETURN p")
    List<Parcel> findAllInRegion(String regionName);

    @Query("MATCH (parcel:Parcel) - [r] - (license: License {ownerId: {0}}) RETURN parcel, r, license")
    List<Parcel> findAllForOwner(String jmbg);
}
