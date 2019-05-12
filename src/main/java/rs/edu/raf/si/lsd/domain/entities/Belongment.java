package rs.edu.raf.si.lsd.domain.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.neo4j.ogm.annotation.*;

@RelationshipEntity(type = "BELONGS_TO")
@Data @AllArgsConstructor @NoArgsConstructor
public class Belongment {

    @Id
    @GeneratedValue
    private Long id;

    @StartNode
    private TerritorialUnit origin;

    @EndNode
    private TerritorialUnit end;

    private String from;

    private String to;

    public Belongment(TerritorialUnit origin, TerritorialUnit end, String from, String to) {
        this.origin = origin;
        this.end = end;
        this.from = from;
        this.to = to;
    }
}
