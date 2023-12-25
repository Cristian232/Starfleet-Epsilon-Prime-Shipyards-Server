package org.starfleet.epsilonprimeshipyards.service;

import jakarta.persistence.EntityNotFoundException;
import org.starfleet.epsilonprimeshipyards.dto.ProductDTO;
import org.starfleet.epsilonprimeshipyards.mapper.ProductMapper;
import org.starfleet.epsilonprimeshipyards.model.Product;
import org.starfleet.epsilonprimeshipyards.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductService {

    private final ProductRepository productRepository;
    private final ProductMapper productMapper;

    @Autowired
    public ProductService(ProductRepository productRepository, ProductMapper productMapper) {
        this.productRepository = productRepository;
        this.productMapper = productMapper;
    }

    public List<ProductDTO> getAllProducts() {
        List<Product> products = productRepository.findAll();
        return products.stream()
                .map(productMapper::productToProductDTO)
                .collect(Collectors.toList());
    }

    public ProductDTO getProductById(Long productId) {
        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new EntityNotFoundException("Product not found"));

        return productMapper.productToProductDTO(product);
    }

    public void createProduct(ProductDTO productDTO) {
        Product product = productMapper.productDTOToProduct(productDTO);
        productRepository.save(product);
    }

    public void updateProduct(Long productId, ProductDTO productDTO) {
        Product existingProduct = productRepository.findById(productId)
                .orElseThrow(() -> new EntityNotFoundException("Product not found"));

        // Update the existingProduct based on productDTO
        existingProduct.setName(productDTO.getName());
        existingProduct.setDescription(productDTO.getDescription());
        existingProduct.setPrice(productDTO.getPrice());

        productRepository.save(existingProduct);
    }

    public void deleteProduct(Long productId) {
        productRepository.deleteById(productId);
    }
}
