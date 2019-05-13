package rs.edu.raf.si.lsd.domain.dto.resident;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import rs.edu.raf.si.lsd.domain.entities.Resident;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ResidentResponseDTO {

    private String jmbg;

    public ResidentResponseDTO(Resident resident) {
        this.jmbg = resident.getJmbg();
    }
}
