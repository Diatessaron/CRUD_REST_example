package crud.restexample.service;

import crud.restexample.model.Client;
import crud.restexample.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

@Service
public class ClientServiceImpl implements ClientService{
    private ClientRepository clientRepository;

    @Autowired
    public ClientServiceImpl(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public void create(Client client) {
        clientRepository.save(client);
    }

    public List<Client> readAll() {
        return clientRepository.findAll();
    }

    public Client read(int id) {
        return clientRepository.getOne(id);
    }

    public boolean update(Client client, int id) {
        if(clientRepository.existsById(id)){
            client.setId(id);
            clientRepository.save(client);
            return true;
        }

        return false;
    }

    public boolean delete(int id) {
        if(clientRepository.existsById(id)){
            clientRepository.deleteById(id);
            return true;
        }

        return false;
    }
}
