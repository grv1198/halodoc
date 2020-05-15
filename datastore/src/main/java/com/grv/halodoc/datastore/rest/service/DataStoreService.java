package com.grv.halodoc.datastore.rest.service;

import com.grv.halodoc.datastore.rest.entity.HaloDocData;
import com.grv.halodoc.datastore.rest.entity.Value;

import java.util.List;

public interface DataStoreService {


    public boolean saveData(String key, List<Value> values);

    public HaloDocData getData(String key);

    public boolean deleteData(String key);

    public boolean updateDataValues(String key, List<Value> values);
}
