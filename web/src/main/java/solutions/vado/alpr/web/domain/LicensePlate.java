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
@Table(name = "licenseplate")
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value = {"createdAt", "updatedAt"},
        allowGetters = true)
@Getter
@Setter
public class LicensePlate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private Long locationId;

    @NotBlank
    private String plate;

    private String description;

    @Temporal(TemporalType.TIMESTAMP)
    private Date validFrom;

    @Temporal(TemporalType.TIMESTAMP)
    private Date validTo;

    @Column(nullable = false, updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @CreatedDate
    private Date createdAt;

    @Column(nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @LastModifiedDate
    private Date updatedAt;

    public void update(LicensePlate licensePlate) {
        this.locationId = licensePlate.locationId;
        this.description = licensePlate.description;
        this.plate = licensePlate.plate;
        this.validFrom = licensePlate.validFrom;
        this.validTo = licensePlate.validTo;
    }

}
