package org.aconex.contract.web.api;

import org.aconex.contract.model.Contract;
import org.aconex.contract.service.ContractService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

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
                contracts = new ArrayList<Contract>();
            }
        } catch (Exception ex) {
            logger.error("Error fetching all contracts", ex);

            return new ResponseEntity<List<Contract>>(contracts, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        logger.info("< getAllContracts");

        return new ResponseEntity<List<Contract>>(contracts, HttpStatus.OK);
    }

}
