package rs.edu.raf.si.lsd.dao;

import rs.edu.raf.si.lsd.domain.entities.City;

public interface CityDao extends BaseDao<City, String> {
    City findByName(String name);
}
