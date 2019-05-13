package rs.edu.raf.si.lsd.dao;

import rs.edu.raf.si.lsd.domain.entities.Resident;

public interface ResidentDao extends BaseDao<Resident, Long>{

    Resident findByJmbg(String jmbg);
}
