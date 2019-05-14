package rs.edu.raf.si.lsd.domain.entities;

import lombok.*;
import org.apache.commons.lang3.builder.EqualsExclude;
import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;
import org.springframework.hateoas.core.Relation;
import rs.edu.raf.si.lsd.util.validation.LicenseType;

import java.util.ArrayList;
import java.util.List;

@NodeEntity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(exclude = "ownershipRelationship")
public class License implements TerritorialUnit {

    @Id
    @GeneratedValue
    private Long id;

    private String ownerId;

    private LicenseType licenseType;


    @Relationship(type = "BELONGS_TO")
    private Belongment ownershipRelationship;

}
