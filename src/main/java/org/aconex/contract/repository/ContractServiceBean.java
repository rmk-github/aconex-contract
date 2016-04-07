package org.aconex.contract.repository;

import org.aconex.contract.model.Contract;
import org.aconex.contract.service.ContractService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by muthukumar on 3/31/16.
 */

@Service
public class ContractServiceBean implements ContractService {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private ContractRepository contractRepository;


    @Override
    public List<Contract> findAll() {
        logger.info("> findAll");

        List<Contract> allContracts = contractRepository.findAll();

        logger.info("< findAll");

        return allContracts;
    }
}
