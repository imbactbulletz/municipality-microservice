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
@EqualsAndHashCode(exclude = {"belongmentRelationship", "townsAndMunicipalities"})
public class City implements TerritorialUnit {

    @Id
    private String name;

    private String countyName;

    @Relationship(type = "BELONGS_TO")
    private Belongment belongmentRelationship;


    @Relationship(type = "BELONGS_TO", direction = "INCOMING")
    private List<Belongment> townsAndMunicipalities = new ArrayList<>();

}