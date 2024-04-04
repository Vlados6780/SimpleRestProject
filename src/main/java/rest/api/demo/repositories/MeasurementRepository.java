package rest.api.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import rest.api.demo.models.Measurement;

@Repository
public interface MeasurementRepository extends JpaRepository<Measurement, String> {

}
