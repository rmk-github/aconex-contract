package org.aconex.contract.service;

import org.aconex.contract.model.Contract;
import org.aconex.contract.repository.ContractRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by muthukumar on 3/31/16.
 */

@Service
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class ContractServiceBean implements ContractService {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private ContractRepository contractRepository;


//    Fetch all Contracts
    @Override
    public List<Contract> findAll() {
        logger.info("> findAll");

        List<Contract> allContracts = contractRepository.findAll();

        logger.info("< findAll");

        return allContracts;
    }

    @Override
    @Cacheable(value = "contractCache", key = "#contractId")
    public Contract findContract(Long id) {
        logger.info("> findContract id:{}", id);

        Contract contract = contractRepository.findOne(id);

        logger.info("< findContract id:{}", id);

        return contract;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    @CachePut(value = "contractCache", key = "#contract.contractId")
    public Contract updateContract(Contract contract) {
        logger.info("> updateContract");

        Contract existingContract = this.findContract(contract.getContractId());

        if (existingContract == null) return null;

        Contract savedContract = contractRepository.save(contract);

        logger.info("< updateContract");

        return savedContract;
    }


    //    Clear the Cache
    @Override
    @CacheEvict(value = "contractCache", allEntries = true)
    public void evictCache() {

    }
}
