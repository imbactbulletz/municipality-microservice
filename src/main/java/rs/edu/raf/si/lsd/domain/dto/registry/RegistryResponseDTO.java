package rs.edu.raf.si.lsd.domain.dto.registry;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RegistryResponseDTO {

    List<InhabitantResponseDTO> inhabitants;
}
