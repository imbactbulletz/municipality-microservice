package rs.edu.raf.si.lsd.domain.dto.region;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import rs.edu.raf.si.lsd.domain.County;
import rs.edu.raf.si.lsd.domain.Region;
import rs.edu.raf.si.lsd.domain.dto.county.CountyResponseDTO;

import java.util.List;
import java.util.stream.Collectors;

@Data
@Builder
@NoArgsConstructor @AllArgsConstructor
public class RegionResponseDTO {

    private String name;

    private List<CountyResponseDTO> counties;

    public RegionResponseDTO(Region region){

        this.name = region.getName();

        if(region.getCounties() != null) {
//            this.counties = region.getCounties().stream().map(CountyResponseDTO::new).collect(Collectors.toList());
        }
    }
}
