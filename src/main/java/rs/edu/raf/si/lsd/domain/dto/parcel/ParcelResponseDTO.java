package rs.edu.raf.si.lsd.domain.dto.parcel;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import rs.edu.raf.si.lsd.domain.entities.Parcel;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ParcelResponseDTO {

    private String parcelNumber;

    private Long surface;

    public ParcelResponseDTO(Parcel parcel) {
        this.parcelNumber = parcel.getParcelNumber();
        this.surface = parcel.getSurface();
    }
}
