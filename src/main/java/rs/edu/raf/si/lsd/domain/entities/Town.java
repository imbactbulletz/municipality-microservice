package rs.edu.raf.si.lsd.domain.entities;

import lombok.*;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

@NodeEntity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(exclude = "ownershipRelationship")
public class Town implements TerritorialUnit {
    @Id
    private String name;

    // Municipality / City relationships
    @Relationship(type = "BELONGS_TO")
    private Belongment belongmentRelationship;
}
