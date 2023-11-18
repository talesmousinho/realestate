package com.realestate.server.service;

import java.util.List;

import com.realestate.server.entities.Client;

public interface ClientService {
  List<Client> getClients();

  Client createClient(Client client);

  Client getClient(Long id);

  Client updateClient(Long id, Client client);

  void deleteClient(Long id);
}
