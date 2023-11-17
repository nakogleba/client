/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bf.gov.formation.client.controller;

import bf.gov.formation.client.data.Client;
import bf.gov.formation.client.data.ClientDto;
import bf.gov.formation.client.data.EStatus;
import bf.gov.formation.client.data.VilleDto;
import bf.gov.formation.client.service.ClientService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author User
 */
@RestController
@RequestMapping(value = "/formation")
@RequiredArgsConstructor
public class ClientController {

    private final ClientService clientService;

    @GetMapping(value = "/hello")
    public ResponseEntity<String> helloWorld() {

        return new ResponseEntity<>("Hello World", HttpStatus.OK);
    }

    //envoie de données
    @GetMapping(value = "/client")
    public ResponseEntity<List<Client>> getClient() {
        return new ResponseEntity<>(clientService.getClient(), HttpStatus.OK);

    }

    //gerer la recuperation des données
    @PostMapping(value = "/client")
    public ResponseEntity<ClientDto> saveClient(
            @RequestBody final ClientDto clientDto
    ) {
        return new ResponseEntity<>(clientService.saveClient(clientDto), HttpStatus.CREATED);
    }

    @DeleteMapping(value = "/client/{code}")
    public ResponseEntity<String> deleteClient(
            @PathVariable(name = "code") final String idClient
    ) {
        return new ResponseEntity<>(clientService.deleteClient(idClient), HttpStatus.OK);
    }

    /**
     *
     * Controlleur de Sauvegarde de la ville
     *
     * @param villeDto
     * @return villeDto
     */
    @PostMapping(value = "/ville")
    public ResponseEntity<VilleDto> saveVille(
            @RequestBody final VilleDto villeDto
    ) {
        return new ResponseEntity<>(clientService.saveVille(villeDto), HttpStatus.CREATED);
    }

    //envoie de données
    @GetMapping(value = "/ville")
    public ResponseEntity<List<VilleDto>> getVille(
    @RequestParam(name="statut", required = false) final EStatus status
    ) {
        return new ResponseEntity<>(clientService.getVille(status), HttpStatus.OK);
    }

    @PutMapping(value = "/ville/{code}")
    public ResponseEntity<VilleDto> putVille(
            @PathVariable(name = "code") final Integer identifiant,
            @RequestBody final VilleDto ville
    ) {
        return new ResponseEntity<>(clientService.majVille(identifiant, ville), HttpStatus.OK);
    }

    @PatchMapping(value = "/ville/{code}")
    public ResponseEntity<VilleDto> softdeleteVille(
            @PathVariable(name = "code") final Integer identifiant
    ) {
        return new ResponseEntity<>(clientService.deleteVille(identifiant), HttpStatus.OK);
    }
}
