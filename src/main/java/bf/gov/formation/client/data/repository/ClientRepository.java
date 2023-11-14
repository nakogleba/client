/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package bf.gov.formation.client.data.repository;

import bf.gov.formation.client.data.ClientEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author User
 */
public interface ClientRepository extends JpaRepository<ClientEntity, String> {
    
}
