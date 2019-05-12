package rs.edu.raf.si.lsd.domain.entities;

import lombok.*;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

import java.util.ArrayList;
import java.util.List;


@NodeEntity
@Data @Builder @NoArgsConstructor @AllArgsConstructor
@EqualsAndHashCode(exclude = "belongmentRelationships")
public class Region implements TerritorialUnit {

    @Id
    private String name;

    // County relationships
    @Relationship(type = "BELONGS_TO", direction = Relationship.INCOMING)
    private List<Belongment> belongmentRelationships = new ArrayList<>();
}
