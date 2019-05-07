package rs.edu.raf.si.lsd.domain;

import lombok.*;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;
import org.neo4j.ogm.annotation.RelationshipEntity;

import java.util.ArrayList;
import java.util.List;

@NodeEntity
@Data
@Builder
@AllArgsConstructor @NoArgsConstructor
@EqualsAndHashCode(exclude = {"regionRelationship", "municipalityRelationships"})
public class County implements TerritorialUnit {

    @Id
    private String name;

    @Relationship(type = "BELONGS_TO")
    private Belongment regionRelationship;

    @Relationship(type = "BELONGS_TO", direction = "INCOMING")
    private List<Belongment> municipalityRelationships = new ArrayList<>();

    public County(String name, Belongment regionRelationship) {
        this.name = name;
        this.regionRelationship = regionRelationship;
    }
}
