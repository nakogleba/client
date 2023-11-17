/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bf.gov.formation.client.service;

import bf.gov.formation.client.data.Client;
import bf.gov.formation.client.data.ClientDto;
import bf.gov.formation.client.data.ClientEntity;
import bf.gov.formation.client.data.EStatus;
import bf.gov.formation.client.data.VilleDto;
import bf.gov.formation.client.data.VilleEntity;
import bf.gov.formation.client.data.repository.ClientRepository;
import bf.gov.formation.client.data.repository.VilleRepository;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Component;


import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

/**
 *
 * @author User
 */
@Component
@RequiredArgsConstructor
public class ClientService {
    private final ClientRepository clientRepository;
    private final VilleRepository villeRepository;
    //methode 
    public List<Client> getClient () {
        return clientRepository.findAll().stream()
                .map(clt-> {
                Client client = new Client();
                client.setNom(clt.getNom());
                client.setPrenom(clt.getPrenom());
                client.setIdclient(clt.getIdclient());
               return client;
              
                }).toList(); 
    }
    
    public ClientDto saveClient(final ClientDto clientDto){
        ClientEntity client = ClientEntity.builder()
                .nom(clientDto.getNom())
                .prenom(clientDto.getPrenom())
                .numero(clientDto.getNumero())
                .age(clientDto.getAge())
                .build();
        client = clientRepository.save(client);
        return ClientDto.builder()
                .idclient(client.getIdclient())
                .nom(client.getNom())
                .prenom(client.getPrenom())
                .age(client.getAge())
                .numero(client.getNumero())
                .build();
    }
   
        public List<VilleDto> getVille (final EStatus statut) {
            List<VilleEntity> villes = new ArrayList<>();
            if(statut==null){
                villes = villeRepository.findAll();
            } else  {
                villes = villeRepository.findByStatus(statut);
            }
            
                
        return villes.stream()
                .map(vl-> {
                VilleDto ville = new VilleDto();
                ville.setNom(vl.getNom());
                ville.setPopulation(vl.getPopulation());
                ville.setId(vl.getId());
                ville.setStatus(vl.getStatus());
               return ville;
              
                }).toList(); 
    }
        public VilleDto saveVille(final VilleDto villeDto){
        VilleEntity ville = VilleEntity.builder()
                .nom(villeDto.getNom())
                .population(villeDto.getPopulation())
                .status(EStatus.actif)
                .build();
        ville = villeRepository.save(ville);
        return VilleDto.builder()
                .id(ville.getId())
                .nom(ville.getNom())
                .population(ville.getPopulation())
                .status(ville.getStatus())
                .build();
    }
        
        public VilleDto majVille(final Integer identifiant, final VilleDto vil)
        {
            Optional<VilleEntity>  villee = this.villeRepository.findById(identifiant);
            villee.orElseThrow(()-> new ResponseStatusException(HttpStatus.BAD_REQUEST,
                    "impossible de supprimer cette reference"));
            
            VilleEntity ville = VilleEntity.builder().id(identifiant)
                .nom(vil.getNom())
                .population(vil.getPopulation())
                .status(EStatus.actif)
                .build();
        ville = villeRepository.save(ville);
        return VilleDto.builder()
                .id(ville.getId())
                .nom(ville.getNom())
                .population(ville.getPopulation())
                .status(ville.getStatus())
                .build();
        }
    
         public VilleDto deleteVille(final Integer identifiant)
        {
            Optional<VilleEntity>  villee = this.villeRepository.findById(identifiant);
            villee.orElseThrow(()-> new ResponseStatusException(HttpStatus.BAD_REQUEST,
                    "impossible de supprimer cette reference"));
            villee.get().setStatus(EStatus.inactif);
        VilleEntity ville = villeRepository.save(villee.get());
        return VilleDto.builder()
                .id(ville.getId())
                .nom(ville.getNom())
                .population(ville.getPopulation())
                .status(ville.getStatus())
                .build();
        }
        
        
    public String deleteClient(final String idClient){
        Optional<ClientEntity> client = clientRepository.findById(idClient);
        if(!client.isPresent()){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
                    "impossible de supprimer cette reference");
        }
        clientRepository.deleteById(idClient);
        return idClient + " supprimer";
    }
}
