package rs.edu.raf.si.lsd.domain.dto.license;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.neo4j.ogm.annotation.GeneratedValue;
import rs.edu.raf.si.lsd.util.validation.LicenseType;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class LicenseRequestDTO {

    private Long id;

    private String parcelNumber;

    private LicenseType licenseType;

    private String licenseOwnerId;

}
