package rs.edu.raf.si.lsd.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

import java.util.ArrayList;
import java.util.List;


@NodeEntity
@Data @Builder @NoArgsConstructor @AllArgsConstructor
@EqualsAndHashCode(exclude = "counties")
public class Region implements TerritorialUnit {

    @Id
    private String name;

    @Relationship(type = "BELONGS_TO", direction = Relationship.INCOMING)
    private List<Belongment> counties = new ArrayList<>();
}
