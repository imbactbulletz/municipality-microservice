package rs.edu.raf.si.lsd.domain.dto.parcel;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import rs.edu.raf.si.lsd.domain.dto.license.LicenseResponseDTO;
import rs.edu.raf.si.lsd.domain.entities.Belongment;
import rs.edu.raf.si.lsd.domain.entities.License;
import rs.edu.raf.si.lsd.domain.entities.Parcel;

import java.util.ArrayList;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ParcelResponseDTO {

    private String parcelNumber;

    private Long estimatedValue;

    private Long surface;

    private List<LicenseResponseDTO> licenses = new ArrayList<>();

    public ParcelResponseDTO(Parcel parcel) {
        this.parcelNumber = parcel.getParcelNumber();
        this.surface = parcel.getSurface();
        this.estimatedValue = parcel.getEstimatedValue();

        List<Belongment> belongments = parcel.getBelongmentRelationships();

        for(Belongment belongment : belongments) {
            if(belongment.getOrigin() instanceof License) {
                licenses.add(new LicenseResponseDTO(((License)belongment.getOrigin())));
            }
        }
    }
}
