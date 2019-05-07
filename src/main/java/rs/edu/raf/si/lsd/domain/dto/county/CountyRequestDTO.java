package rs.edu.raf.si.lsd.domain.dto.county;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data @Builder @AllArgsConstructor @NoArgsConstructor
public class CountyRequestDTO {

    @NotNull
    private String name;

    private String regionName;

    private String from;

    private String to;
}
