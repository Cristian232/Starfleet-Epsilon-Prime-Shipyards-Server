package org.starfleet.epsilonprimeshipyards.service;

import org.springframework.stereotype.Service;
import org.starfleet.epsilonprimeshipyards.dto.SupplyChainDTO;
import org.starfleet.epsilonprimeshipyards.mapper.SupplyChainMapper;
import org.starfleet.epsilonprimeshipyards.model.SupplyChain;
import org.starfleet.epsilonprimeshipyards.repository.SupplyChainRepository;

import java.util.List;

@Service
public class SupplyChainService {
    private final SupplyChainRepository supplyChainRepository;
    private final SupplyChainMapper supplyChainMapper;

    public SupplyChainService(SupplyChainRepository supplyChainRepository, SupplyChainMapper supplyChainMapper) {
        this.supplyChainRepository = supplyChainRepository;
        this.supplyChainMapper = supplyChainMapper;
    }

    public List<SupplyChainDTO> getAllSupplyChains() {
        List<SupplyChain> supplyChains = supplyChainRepository.findAll();
        return supplyChainMapper.supplyChainsToSupplyChainDTOs(supplyChains);
    }

}
