package com.sonechok.algorithm;

import com.sonechok.entity.Case;
import com.sonechok.entity.Orderline;
import com.sonechok.entity.Product;
import com.sonechok.service.CaseService;
import com.sonechok.service.OrderlineService;
import com.sonechok.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Service
public class ProductsPackagingAlgorithm implements  ProductPackagingAlgorithmInterface {
    private Map<Long, Double> volumesOfCases = new HashMap<>();
    private final CaseService caseService;
    private final ProductService productService;
    private final OrderlineService orderlineService;

    @Autowired
    public ProductsPackagingAlgorithm(CaseService caseService, ProductService productService, OrderlineService orderlineService) {
        this.caseService = caseService;
        this.productService = productService;
        this.orderlineService = orderlineService;
    }

    @Override
    @Transactional
    public Case findOptimalCase(Orderline orderline){
        List<Product> products = orderline.getProduct();
        double volumeOfProducts = 0;
        if(setVolumesOfCases()) {
            for (Product product : products) {
                volumeOfProducts += product.getSizeX() * product.getSizeY() * product.getSizeZ();
            }

            for (Map.Entry<Long, Double> entry : volumesOfCases.entrySet()) {
                if (entry.getValue() < volumeOfProducts) {
                    volumesOfCases.remove(entry.getKey(), entry.getValue());
                }
            }
            if (volumesOfCases.size() == 0) {
                System.out.println("No such case for this order");
                return null;
            }

            Case optimalCase = findMinFromCases(volumeOfProducts);
            while (volumesOfCases.size() != 0) {
                List<Double> sizesOfCase = new ArrayList<>(Arrays.asList(optimalCase.getSizeX(), optimalCase.getSizeY(), optimalCase.getSizeZ()));
                Collections.sort(sizesOfCase);
                for (Product product : products) {
                    List<Double> sizesOfProduct = new ArrayList<>(Arrays.asList(product.getSizeX(), product.getSizeY(), product.getSizeZ()));
                    Collections.sort(sizesOfProduct);
                    if (sizesOfCase.get(0) < sizesOfProduct.get(0) || sizesOfCase.get(0) < sizesOfProduct.get(1) || sizesOfCase.get(0) < sizesOfProduct.get(2)) {
                        volumesOfCases.remove(optimalCase.getId());
                        optimalCase = findMinFromCases(volumeOfProducts);
                    } else {
                        return optimalCase;
                    }
                }
            }
        }
        return null;
    }

    @Transactional
    public Case findMinFromCases(double volumeOfProducts){
        double minCase = 0;
        int i = 0;
        Long optimalId = 0L;
        for (Map.Entry<Long, Double> entry:volumesOfCases.entrySet()){
            if(i==0){
                minCase = entry.getValue()-volumeOfProducts;
                optimalId = entry.getKey();
                i++;
            }
            if(minCase>(entry.getValue()-volumeOfProducts)){
                minCase = entry.getValue()-volumeOfProducts;
                optimalId = entry.getKey();
            }
        }
        return caseService.findById(optimalId);
    }

    @Transactional
    public boolean setVolumesOfCases(){
        List<Case> cases = caseService.findAll();
        if (cases != null) {
            double volume;
            for (Case c : cases) {
                volume = c.getSizeX() * c.getSizeY() * c.getSizeZ();
                volumesOfCases.put(c.getId(), volume);
            }

            return volumesOfCases.size() == cases.size();
        }
        return false;
    }
}
