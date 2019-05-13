package rs.edu.raf.si.lsd.dao;

import rs.edu.raf.si.lsd.domain.entities.Parcel;

public interface ParcelDao extends BaseDao<Parcel, String> {

    Parcel findByParcelNumber(String name);
}
