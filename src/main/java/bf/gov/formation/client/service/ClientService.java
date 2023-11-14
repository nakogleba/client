/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bf.gov.formation.client.service;

import bf.gov.formation.client.data.Client;
import bf.gov.formation.client.data.ClientEntity;
import bf.gov.formation.client.data.repository.ClientRepository;
import java.util.Arrays;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;


import org.springframework.stereotype.Service;

/**
 *
 * @author User
 */
@Component
@RequiredArgsConstructor
public class ClientService {
    private final ClientRepository clientRepository;
    
    public List<Client> getClient () {
        return clientRepository.findAll().stream()
                .map(clt-> {
                Client client = new Client();
                client.setNom(clt.getNom());
                client.setPrenom(clt.getPrenom());
               return client;
              
                }).toList();
   //        
//        return Arrays.asList(
//        new Client ("A00","COULIBALY","Sy","40404040","50"),
//        new Client ("A01","KIRAKOYA","Boukary","500000","60")
//                );
        
//    return null;
//        
//        return Arrays.asList(
//        new Client ("A00","COULIBALY","Sy","40404040","50"),
//        new Client ("A01","KIRAKOYA","Boukary","500000","60")
//                );
    }
}
