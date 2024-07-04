package edittemplate.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.Data;

@Data
public class IncreaseCommandCommand {

    private Long id;
    private Integer stock;
}
