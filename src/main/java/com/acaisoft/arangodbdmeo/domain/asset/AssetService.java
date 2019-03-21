package com.acaisoft.arangodbdmeo.domain.asset;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AssetService {
    private final AssetRepository assetRepository;

    public Iterable<Asset> saveAll(Iterable<Asset> assets) {
        return assetRepository.saveAll(assets);
    }

    public void deleteAll() {
        assetRepository.deleteAll();
    }
}
