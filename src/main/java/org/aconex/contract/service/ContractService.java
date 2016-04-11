package org.aconex.contract.service;

import org.aconex.contract.model.Contract;

import java.util.List;

/**
 * Created by muthukumar on 3/31/16.
 */


public interface ContractService {

    List<Contract> findAll();

    Contract findContract(Long id);

    Contract updateContract(Contract contract);

    void evictCache();

}
