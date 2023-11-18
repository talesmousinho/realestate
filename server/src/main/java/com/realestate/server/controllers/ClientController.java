package com.realestate.server.controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.realestate.server.entities.Client;
import com.realestate.server.repositories.ClientRepository;

@RestController
@RequestMapping("/api/clients")
public class ClientController {

  private ClientRepository clientRepository;

  public ClientController(ClientRepository clientRepository) {
    this.clientRepository = clientRepository;
  }

  @GetMapping
  public ResponseEntity<List<Client>> getClients() {
    try {
      List<Client> clients = clientRepository.findAll();
      if (clients.isEmpty()) {
        return ResponseEntity.noContent().build();
      }
      return ResponseEntity.ok().body(clients);
    } catch (Exception e) {
      return ResponseEntity.badRequest().build();
    }
  }

  @GetMapping("/{id}")
  public ResponseEntity<Client> getClient(@PathVariable Long id) {
    return clientRepository.findById(id).map(client -> ResponseEntity.ok().body(client))
        .orElse(ResponseEntity.notFound().build());
  }

  @PostMapping
  public ResponseEntity<Client> createClient(@RequestBody Client client) {
    try {
      Client newClient = clientRepository.save(client);
      return ResponseEntity.ok().body(newClient);
    } catch (Exception e) {
      return ResponseEntity.badRequest().build();
    }
  }

  @PutMapping("/{id}")
  public ResponseEntity<Client> updateClient(@PathVariable Long id, Client client) {
    return clientRepository.findById(id).map(c -> {
      c.setName(client.getName());
      c.setEmail(client.getEmail());
      c.setPhone(client.getPhone());
      Client updatedClient = clientRepository.save(c);
      return ResponseEntity.ok().body(updatedClient);
    }).orElse(ResponseEntity.notFound().build());
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Client> deleteClient(@PathVariable Long id) {
    return clientRepository.findById(id).map(client -> {
      clientRepository.delete(client);
      return ResponseEntity.ok().body(client);
    }).orElse(ResponseEntity.notFound().build());
  }

}
