/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package bf.gov.formation.client.data.repository;

import bf.gov.formation.client.data.EStatus;
import bf.gov.formation.client.data.VilleEntity;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author Lenovo
 */
public interface VilleRepository extends JpaRepository<VilleEntity, Integer>{
    public List<VilleEntity> findByStatus(EStatus eStatus);
}
