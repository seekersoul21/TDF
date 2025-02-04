package com.tdf.repository;

import com.tdf.entity.MetaDataList;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface MetaDataListRepository extends MongoRepository<MetaDataList,String> {
}
