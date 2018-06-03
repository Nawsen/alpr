package solutions.vado.alpr.web.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Date;

@Entity
@Table(name = "module")
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value = {"createdAt", "updatedAt"},
        allowGetters = true)
@Getter
@Setter
public class Module {

    @Id
    private Long id;

    @NotBlank
    private String name;

    @NotBlank
    private String ip;

    private String description;

    @Temporal(TemporalType.TIMESTAMP)
    private Date lastCheckIn;

    @Column(nullable = false, updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @CreatedDate
    private Date createdAt;

    @Column(nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @LastModifiedDate
    private Date updatedAt;

    public void update(Module module) {
        this.name = module.name;
        this.ip = module.ip;
        this.description = module.description;
    }

    public void checkIn() {
        this.lastCheckIn = new Date();
    }

}
