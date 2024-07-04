package edittemplate.external;

import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;

@Data
public class IncreaseCommandCommand {

    @Id
    private Long id;

    private Integer stock;
}
