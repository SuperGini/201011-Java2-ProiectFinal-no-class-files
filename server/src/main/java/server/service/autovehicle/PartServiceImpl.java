package server.service.autovehicle;

import lib.dto.autovehicle.PartDto;
import lib.service.PartService;
import server.convert.autovehicle.PartConvertor;
import server.dao.PartDao;
import server.dao.impl.autovehicle.PartDaoImpl;
import server.model.autovehicle.Part;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Collection;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.stream.Collectors;

public class PartServiceImpl extends UnicastRemoteObject implements PartService {

    private PartDao partDao;

    public PartServiceImpl() throws RemoteException {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("serviceAuto");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        partDao = new PartDaoImpl(entityManager);
    }

    @Override
    public boolean createPart(PartDto partDto){
        Part part = PartConvertor.convert(partDto);

        Optional<Part> findPart = partDao.findPartByName(part.getPartName());

        if(findPart.isEmpty()){
        return partDao.createPart(part);

        }
        throw new IllegalArgumentException();
    }

    @Override
    public PartDto findPartById(int id){
       Part part = partDao.findPartById(id);
       return PartConvertor.convert(part);
    }

    @Override
    public PartDto findPartByName(String name){

       return partDao.findPartByName(name)
               .map(PartConvertor::convert)
               .orElseThrow(NoSuchElementException::new);
    }

    @Override
    public Collection<PartDto> findAllParts(){
        return partDao.findAllParts().stream()
                                .map(PartConvertor::convert)
                                .collect(Collectors.toSet());

    }



}