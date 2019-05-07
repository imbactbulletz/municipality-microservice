package rs.edu.raf.si.lsd.domain.dto.municipality;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MunicipalityRequestDTO {

    @NotNull
    private String name;

    private String countyName;

    private String from;

    private String to;
}
