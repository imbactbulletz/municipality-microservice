package rs.edu.raf.si.lsd.dao;

import rs.edu.raf.si.lsd.domain.entities.Town;

public interface TownDao extends BaseDao<Town, String> {

    Town findByName(String name);
}
