/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bf.gov.formation.client.data;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Generated;
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
@Entity (name = "client")
@Table (name = "t_client")
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class ClientEntity implements Serializable{
    @Id
    @GeneratedValue(strategy =GenerationType.UUID)
    @EqualsAndHashCode.Include
    @Column(name = "id_client")
    private String idclient;
     @Column(name = "nom")
    private String nom;
      @Column(name = "prenom")
    private String prenom;
       @Column(name = "numero")
    private String numero;
        @Column(name = "age")
    private String age;
    private String adresse; 
    
    @JoinColumn(name = "ville", referencedColumnName = "id")
    @ManyToOne()
    private VilleEntity ville;
    
}
