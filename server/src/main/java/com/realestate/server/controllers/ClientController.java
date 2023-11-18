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
import com.realestate.server.service.ClientService;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("/api/clients")
public class ClientController {

  private ClientService clientService;

  @GetMapping
  public ResponseEntity<List<Client>> getClients() {
    try {
      List<Client> clients = clientService.getClients();
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
    try {
      Client client = clientService.getClient(id);
      return ResponseEntity.ok().body(client);
    } catch (Exception e) {
      return ResponseEntity.notFound().build();
    }
  }

  @PostMapping
  public ResponseEntity<Client> createClient(@RequestBody Client client) {
    try {
      client.setId(null);
      Client createdClient = clientService.createClient(client);
      return ResponseEntity.ok().body(createdClient);
    } catch (Exception e) {
      return ResponseEntity.badRequest().build();
    }
  }

  @PutMapping("/{id}")
  public ResponseEntity<Client> updateClient(@PathVariable Long id, Client client) {
    try {
      Client updatedClient = clientService.updateClient(id, client);
      return ResponseEntity.ok().body(updatedClient);
    } catch (Exception e) {
      return ResponseEntity.badRequest().build();
    }
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Client> deleteClient(@PathVariable Long id) {
    try {
      clientService.deleteClient(id);
      return ResponseEntity.ok().build();
    } catch (Exception e) {
      return ResponseEntity.badRequest().build();
    }
  }

}
