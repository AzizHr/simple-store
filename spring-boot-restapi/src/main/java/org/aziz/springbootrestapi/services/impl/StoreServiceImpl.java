package org.aziz.springbootrestapi.services.impl;

import lombok.RequiredArgsConstructor;
import org.aziz.springbootrestapi.dtos.request.StoreRequest;
import org.aziz.springbootrestapi.exceptions.ItemNotFoundException;
import org.aziz.springbootrestapi.models.Store;
import org.aziz.springbootrestapi.repositories.StoreRepository;
import org.aziz.springbootrestapi.services.StoreService;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class StoreServiceImpl implements StoreService {

    private final StoreRepository storeRepository;
    private final SellerRepository sellerRepository;

    @Override
    public String update(StoreRequest storeRequest) throws ItemNotFoundException {
        if(storeRepository.findById(storeRequest.getId()).isPresent()) {
            Store store = storeRepository.findById(storeRequest.getId()).get();
            store.setSeller(sellerRepository.findById(storeRequest.getSellerId()).orElseThrow(
                    () -> new ItemNotFoundException("No Seller was found with ID: "+storeRequest.getSellerId())
            ));
            storeRepository.save(store);
            return "";
        }
        throw new ItemNotFoundException("No store was found with ID: "+storeRequest.getId());
    }
}
