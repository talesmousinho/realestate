package com.realestate.server.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.realestate.server.entities.Client;
import com.realestate.server.repositories.ClientRepository;
import com.realestate.server.service.ClientService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ClientServiceImpl implements ClientService {

  private ClientRepository clientRepository;

  @Override
  public List<Client> getClients() {
    return clientRepository.findAll();
  }

  @Override
  public Client createClient(Client client) {
    return clientRepository.save(client);
  }

  @Override
  public Client getClient(Long id) {
    return clientRepository.findById(id).orElseThrow();
  }

  @Override
  public Client updateClient(Long id, Client client) {
    return clientRepository.findById(id).map(c -> {
      c.setName(client.getName());
      c.setEmail(client.getEmail());
      c.setPhone(client.getPhone());
      return clientRepository.save(c);
    }).orElseThrow();
  }

  @Override
  public void deleteClient(Long id) {
    clientRepository.deleteById(id);
  }

}
