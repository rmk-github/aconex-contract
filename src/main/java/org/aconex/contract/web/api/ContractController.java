package org.aconex.contract.web.api;

import org.aconex.contract.model.Contract;
import org.aconex.contract.service.ContractService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by muthukumar on 3/31/16.
 */

@RequestMapping(value = "/aconex")
@RestController
class ContractController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private ContractService contractService;


    @RequestMapping(
            value = "/api/contracts",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<List<Contract>> getAllContracts() {
        logger.info("> getAllContracts");

        List<Contract> contracts = null;

        try {
            contracts = contractService.findAll();

            if (contracts == null) {
                contracts = new ArrayList<>();
            }
        } catch (Exception ex) {
            logger.error("Error fetching all contracts", ex);

            return new ResponseEntity<>(contracts, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        logger.info("< getAllContracts");

        return new ResponseEntity<>(contracts, HttpStatus.OK);
    }


    @RequestMapping(
            value = "/api/contracts/{contractId}",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<Contract> findContract(@PathVariable("contractId") Long contractId) {
        logger.info("> getCompany");

        Contract contract = null;

        try {
            contract = contractService.findContract(contractId);

            if (contract == null) {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (Exception ex) {
            logger.error("Unexpected Exception " + ex);
            return new ResponseEntity<>(contract, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        logger.info("< getCompany");
        return new ResponseEntity<>(contract, HttpStatus.OK);
    }


    @RequestMapping(
            value = "/api/contracts/{contractId}",
            method = RequestMethod.PUT,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<Contract> updateContract(@PathVariable("contractId") Long contractId, @RequestBody Contract contract) {
        logger.info("> updateContract");

        Contract newContract = null;

        try {
            newContract = contractService.updateContract(contract);

            if (newContract == null) {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (Exception ex) {
            logger.error("Unexpected Exception " + ex);
            return new ResponseEntity<>(newContract, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        logger.info("< updateContract");
        return new ResponseEntity<>(newContract, HttpStatus.OK);
    }

}
