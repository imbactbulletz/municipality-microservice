package rs.edu.raf.si.lsd.domain.dto.resident;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class ResidentRequestDTO {

    @NotNull
    private String jmbg;

    private String residenceUnitType;

    private String residenceUnitName;
}
