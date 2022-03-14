package com.dio_class.philips_dev_week.Repository;

import com.dio_class.philips_dev_week.Entity.IncidenciaExame;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IncidenciaRepo extends JpaRepository<IncidenciaExame, Long> {
}
