package rs.edu.raf.si.lsd.domain.dto.city;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CityRequestDTO {

    private String name;

    private String countyName;

    private String from;

    private String to;
}
