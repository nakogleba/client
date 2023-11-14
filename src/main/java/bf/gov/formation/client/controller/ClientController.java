/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bf.gov.formation.client.controller;

import bf.gov.formation.client.data.Client;
import bf.gov.formation.client.data.ClientEntity;
import bf.gov.formation.client.service.ClientService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author User
 */
@RestController
@RequestMapping(value="/formation")
@RequiredArgsConstructor
public class ClientController {
    
    private final  ClientService clientService; 
    
    @GetMapping(value="/hello")
    public ResponseEntity<String> helloWorld ()
    {
       
        return new ResponseEntity<>("Hello World", HttpStatus.OK);
    }
    @GetMapping(value="/client")
    public ResponseEntity <List<Client>> getClient (){
        return new ResponseEntity<> (clientService.getClient(), HttpStatus.OK);
                
    }
}
