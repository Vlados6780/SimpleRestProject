package rest.api.demo.models;


import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDateTime;

@Entity
@Table(name = "measurement")
@Getter
@Setter
public class Measurement {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "value")
    @NotNull
    @Min(-100)
    @Max(100)
    private Double value;

    @Column(name = "raining")
    @NotNull
    private Boolean raining;

    @NotNull
    @ManyToOne
    @JoinColumn(name="sensor", referencedColumnName = "name")
    private Sensor sensor;

    @Column(name = "created_at")
    @NotNull
    private LocalDateTime measurementTime;

}
