package rs.edu.raf.si.lsd.domain;

import lombok.*;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;


@NodeEntity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(exclude = "countyRelationship")
public class Municipality implements TerritorialUnit {

    @Id
    private String name;

    @Relationship(type = "BELONGS_TO")
    private Belongment countyRelationship;
}
