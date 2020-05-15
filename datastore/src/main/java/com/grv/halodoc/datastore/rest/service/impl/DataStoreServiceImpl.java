package com.grv.halodoc.datastore.rest.service.impl;

import com.grv.halodoc.datastore.rest.entity.HaloDocData;
import com.grv.halodoc.datastore.rest.entity.Value;
import com.grv.halodoc.datastore.rest.persistence.DataStoreDaoImpl;
import com.grv.halodoc.datastore.rest.service.DataStoreService;
import com.grv.halodoc.datastore.util.ValueType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DataStoreServiceImpl implements DataStoreService {

    @Autowired
    private DataStoreDaoImpl dataStoreDaoImpl;

    @Autowired
    public DataStoreServiceImpl(DataStoreDaoImpl dataStoreDaoImpl) {
        this.dataStoreDaoImpl = dataStoreDaoImpl;
    }

    @Override
    public boolean saveData(String key, List<Value> values) {
        if (validateSaveRequst(values))
        return this.dataStoreDaoImpl.saveData(key, values);

        else return false;
    }

    @Override
    public HaloDocData getData(String key) {
       List<Value> values =  this.dataStoreDaoImpl.getData(key);

       final HaloDocData data = new HaloDocData(key, values);

       return data;
    }

    @Override
    public boolean deleteData(String key) {
        this.dataStoreDaoImpl.deleteData(key);
        return true;
    }

    @Override
    public boolean updateDataValues(String key, List<Value> values) {
        this.dataStoreDaoImpl.updateDataValues(key, values);

        return true;
    }

    private boolean validateSaveRequst(List<Value> values) {


    for (Value v : values) {

        ValueType vt = v.getType();

        Object vv = v.getValue();
        try {
            switch (vt) {

                case STRING:
                    if (vv.getClass()!= String.class) return false;
                    break;
                case FLOAT:
                    Float.parseFloat(vv.toString());
                    break;
                case BOOLEAN:
                    if (vv.toString().equalsIgnoreCase("true") || vv.toString().equalsIgnoreCase("false")) return true;
                    else return false;
                case INTEGER:
                    Integer.parseInt(vv.toString());
                    break;
            }
        } catch (NumberFormatException e) {
            return  false;
        }

    }

    return true;
    }


}
