package rs.edu.raf.si.lsd.domain.dto.town;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TownRequestDTO {

    @NotNull
    private String name;

    private String cityName;

    private String municipalityName;

    private String from;

    private String to;
}
