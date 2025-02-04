package com.tdf.dao;

import com.tdf.entity.MetaDataList;
import com.tdf.repository.MetaDataListRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class MetaDtaListDao {

    @Autowired
    private MetaDataListRepository metaDataListRepository;

    public void save(MetaDataList metaDataList) {

        metaDataListRepository.save(metaDataList);
    }
}
