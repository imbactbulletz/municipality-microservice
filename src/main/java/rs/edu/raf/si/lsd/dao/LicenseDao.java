package rs.edu.raf.si.lsd.dao;

import org.springframework.data.neo4j.annotation.Query;
import rs.edu.raf.si.lsd.domain.entities.License;

import java.util.List;

public interface LicenseDao extends BaseDao<License, Long> {

    @Query("MATCH (l:License) - [r] - (p:Parcel) WHERE p.parcelNumber = {0} RETURN l,r,p")
    List<License> findByParcelNumber(String parcelNumber);

    @Query("MATCH (l:License) - [r*1..] - (t:Town) MATCH (l) - [:BELONGS_TO] - (p:Parcel) WHERE t.name = {0} RETURN l,r,p")
    List<License> findByTown(String townName);

    @Query("MATCH (l:License) - [r*1..] - (c:City) MATCH (l) - [:BELONGS_TO] - (p:Parcel) WHERE c.name = {0} RETURN l,r,p")
    List<License> findByCity(String cityName);

    @Query("MATCH (l:License) - [r*1..] - (m:Municipality) MATCH (l) - [:BELONGS_TO] - (p:Parcel) WHERE m.name = {0} RETURN l,r,p")
    List<License> findByMunicipality(String municipalityName);

    @Query("MATCH (l:License) - [r*1..] - (c:County) MATCH (l) - [:BELONGS_TO] - (p:Parcel) WHERE c.name = {0} RETURN l,r,p")
    List<License> findByCounty(String countyName);

    @Query("MATCH (l:License) - [r*1..] - (reg:Region) MATCH (l) - [:BELONGS_TO] - (p:Parcel) WHERE reg.name = {0} RETURN l,r,p")
    List<License> findByRegion(String regionName);

}
