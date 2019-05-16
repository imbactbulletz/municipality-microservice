package rs.edu.raf.si.lsd.domain.dto.parcel;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ParcelRequestDTO {

    private String parcelNumber;

    private Long surface;

    private Long estimatedValue;

    private String territorialUnitType;

    private String territorialUnitName;
}
