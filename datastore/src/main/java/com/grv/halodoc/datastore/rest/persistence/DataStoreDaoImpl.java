package com.grv.halodoc.datastore.rest.persistence;

import com.grv.halodoc.datastore.rest.entity.HaloDocData;
import com.grv.halodoc.datastore.rest.entity.Value;
import com.grv.halodoc.datastore.util.ValueType;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class DataStoreDaoImpl implements DataStoreDao {


    // Map to store values as of now.

    Map<String, List<Value>> datastore = new HashMap<>();

    public DataStoreDaoImpl() {
        this.populateDataStore();
    }

    @Override
    public boolean saveData(final String key, final List<Value> value) {
        datastore.put(key, value);
        return  true;
    }

    @Override
    public List<Value> getData(final String key) {
        populateDataStore();
       return datastore.getOrDefault(key, null);
    }

    @Override
    public List<Value> deleteData(final String key) {
        populateDataStore();
        return datastore.remove(key);
    }

    @Override
    public boolean updateDataValues(final String key, final List<Value> value) {
        List<Value> exisitingValues= this.getData(key);

        if (Objects.nonNull(exisitingValues)) {

            for (Value v : exisitingValues) {
                value.add(v);
            }
        }

        datastore.put(key, value);
        return  true;
    }

    // mock db
    private void populateDataStore() {

        List<Value> v1 = new ArrayList<>(0);
        v1.add(new Value("category", ValueType.STRING, "flu"));
        v1.add(new Value("manufacturer", ValueType.STRING, "cipla"));
        HaloDocData d1 = new HaloDocData("crocin", v1);

        this.datastore.put(d1.getKey(), d1.getValue());
    }
}
