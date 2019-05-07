package rs.edu.raf.si.lsd.domain.dto.county;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import rs.edu.raf.si.lsd.domain.County;
import rs.edu.raf.si.lsd.domain.Region;

@Data @Builder @AllArgsConstructor @NoArgsConstructor
public class CountyResponseDTO {

    private String name;

    private String regionName;

    private String from;

    private String to;

    public CountyResponseDTO(County county) {
        this.name = county.getName();
        this.regionName = ((Region)county.getRegionRelationship().getEnd()).getName();
        this.from = county.getRegionRelationship().getFrom();
        this.to = county.getRegionRelationship().getTo();
    }
}
