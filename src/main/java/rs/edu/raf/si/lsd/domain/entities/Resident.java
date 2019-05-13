package rs.edu.raf.si.lsd.domain.entities;

import lombok.*;
import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

@NodeEntity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(exclude = "belongmentRelationship")
public class Resident implements TerritorialUnit {

    @Id
    @GeneratedValue
    private Long id;


    private String jmbg;

    // city or town of residence
    @Relationship(type = "BELONGS_TO")
    private Belongment belongmentRelationship;
}
