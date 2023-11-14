/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bf.gov.formation.client.data;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 *C'est une classe pour la gestion du client.
 * @author User
 */
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Client implements Serializable{
   
    private String nom;
    private String prenom;
    
    
}
