package rs.edu.raf.si.lsd.domain;

import lombok.*;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;
import org.neo4j.ogm.annotation.RelationshipEntity;

@NodeEntity
@Data
@Builder
@AllArgsConstructor @NoArgsConstructor
@EqualsAndHashCode(exclude = "region")
public class County implements TerritorialUnit {

    @Id
    private String name;

    @Relationship(type = "BELONGS_TO")
    private Belongment region;
}
