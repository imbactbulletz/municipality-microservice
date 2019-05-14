package rs.edu.raf.si.lsd.domain.dto.license;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import rs.edu.raf.si.lsd.domain.entities.License;
import rs.edu.raf.si.lsd.domain.entities.Parcel;
import rs.edu.raf.si.lsd.util.validation.LicenseType;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class LicenseResponseDTO {

    private Long id;

    private LicenseType licenseType;

    private String parcelNumber;

    private String licenseOwner;

    public LicenseResponseDTO(License license) {
        this.id = license.getId();

        this.licenseType = license.getLicenseType();

        this.licenseOwner = license.getOwnerId();

        if (license.getOwnershipRelationship() != null) {
            this.parcelNumber = ((Parcel) license.getOwnershipRelationship().getEnd()).getParcelNumber();
        }
    }
}
