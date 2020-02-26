package logs;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "log")
public class LogHIB{
    @Id
    @Column(name = "log_id")
    private int log_id;
    @Column(name = "log_type")
    private Enum log_type;
    @Column(name = "log_description")
    private String log_description;
    @Column(name = "log_date")
    private Date log_date;
}