package rs.edu.raf.si.lsd.domain.dto.county;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import rs.edu.raf.si.lsd.domain.County;

@Data @Builder @AllArgsConstructor @NoArgsConstructor
public class CountyResponseDTO {

    private String name;

    private String regionName;

    private String from;

    private String to;

    public CountyResponseDTO(County county) {
        this.name = county.getName();

    }

}
