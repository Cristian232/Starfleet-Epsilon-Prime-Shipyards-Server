package org.starfleet.epsilonprimeshipyards.mapper;

import org.springframework.stereotype.Component;
import org.starfleet.epsilonprimeshipyards.dto.SupplyChainDTO;
import org.starfleet.epsilonprimeshipyards.model.SupplyChain;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class SupplyChainMapper {

    public SupplyChainDTO supplyChainToSupplyChainDTO(SupplyChain supplyChain) {
        if (supplyChain == null) {
            return null;
        }
        SupplyChainDTO supplyChainDTO = new SupplyChainDTO();
        // Here you perform your mapping from supplyChain to supplyChainDTO, e.g.:
        // supplyChainDTO.setName(supplyChain.getName());
        // This is just an example. Please update it according to your actual model attribute
        return supplyChainDTO;
    }

    public SupplyChain supplyChainDTOToSupplyChain(SupplyChainDTO supplyChainDTO) {
        if (supplyChainDTO == null) {
            return null;
        }
        SupplyChain supplyChain = new SupplyChain();
        // Here you perform your mapping from supplyChainDTO to supplyChain, e.g.:
        // supplyChain.setName(supplyChainDTO.getName());
        // This is just an example. Please update it according to your actual model attribute
        return supplyChain;
    }

    public List<SupplyChainDTO> supplyChainsToSupplyChainDTOs(List<SupplyChain> supplyChains) {
        return supplyChains.stream()
                .map(this::supplyChainToSupplyChainDTO)
                .collect(Collectors.toList());
    }
}