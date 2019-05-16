package rs.edu.raf.si.lsd.domain.entities;

import lombok.*;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

import java.util.ArrayList;
import java.util.List;

@NodeEntity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode( exclude = {"ownershipRelationship", "belongmentRelationships"})
public class Parcel implements TerritorialUnit {

    @Id
    private String parcelNumber;

    private Long surface;

    private Long estimatedValue;

    @Relationship(type = "BELONGS_TO")
    private Belongment ownershipRelationship;

    @Relationship(type = "BELONGS_TO", direction = "INCOMING")
    private List<Belongment> belongmentRelationships = new ArrayList<>();
}
