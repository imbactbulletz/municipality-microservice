package rs.edu.raf.si.lsd.domain.dto.registry;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class InhabitantResponseDTO {

    private String jmbg;

    private int age;

    private int yearOfBirth;

    private int yearOfDeath;

    private boolean isAlive;
}
