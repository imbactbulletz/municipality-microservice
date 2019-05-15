package rs.edu.raf.si.lsd.domain.dto.demography;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AverageAgeRequestDTO {

    @NotNull
    private int generation;
}
