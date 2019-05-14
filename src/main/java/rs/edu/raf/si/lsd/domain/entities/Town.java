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
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(exclude = {"ownershipRelationship", "belongmentRelationships"})
public class Town implements TerritorialUnit {
    @Id
    private String name;

    // Municipality / City relationships
    @Relationship(type = "BELONGS_TO")
    private Belongment ownershipRelationship;


    // Town residents
    @Relationship(type = "BELONGS_TO", direction = "INCOMING")
    private List<Belongment> belongmentRelationships = new ArrayList<>();
}
