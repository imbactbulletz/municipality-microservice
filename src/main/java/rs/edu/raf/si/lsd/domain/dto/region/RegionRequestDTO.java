package rs.edu.raf.si.lsd.domain.dto.region;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RegionRequestDTO {

    @NotEmpty(message = "Region mora imati naziv.")
    private String name;
}
