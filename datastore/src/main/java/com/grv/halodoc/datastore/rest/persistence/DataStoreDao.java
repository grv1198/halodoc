package com.grv.halodoc.datastore.rest.persistence;

import com.grv.halodoc.datastore.rest.entity.Value;

import java.util.List;

public interface DataStoreDao {

    public boolean saveData(String key, List<Value> value);

    public List<Value> getData(String key);

    public List<Value> deleteData(String key);


    public boolean updateDataValues(String key, List<Value> value);

}
