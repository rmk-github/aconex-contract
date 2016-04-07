package org.aconex.contract.repository;

import org.aconex.contract.model.Contract;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by muthukumar on 3/31/16.
 */

@Repository
public interface ContractRepository extends JpaRepository<Contract, Long> {

}
