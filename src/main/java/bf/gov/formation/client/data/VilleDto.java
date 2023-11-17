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
 *
 * @author Lenovo
 */
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class VilleDto implements Serializable {

    private Integer id;
    private String nom;
    private Integer population;
    private  EStatus status;

}
