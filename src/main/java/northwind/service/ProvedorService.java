package northwind.service;

import northwind.model.Provedor;
import northwind.respository.ProvedorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProvedorService {

    @Autowired
    private ProvedorRepository provedorRepository;


    public List<Provedor> getProvedores() throws Exception {
       return provedorRepository.getProvedores();
    }

    public Provedor insertProvedor(Provedor provedor) throws Exception {
        return provedorRepository.insertProvedor(provedor);
    }

    public Provedor getProvedor(Integer idProvedor) throws Exception {
        return provedorRepository.getProvedor(idProvedor);
    }

    public Provedor updateProvedor(Integer idProvedor, Provedor provedor) throws Exception {
        return provedorRepository.updateProvedor(idProvedor,provedor);
    }

    public boolean deleteProvedor(Integer idProvedor) throws Exception {
        return provedorRepository.deleteProvedor(idProvedor);
    }
}
