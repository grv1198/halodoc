package com.grv.halodoc.datastore.rest.entity;

import java.util.List;
import java.util.Objects;

public class HaloDocData {


    private String key;

    private List<Value> value;

    public HaloDocData(String key, List<Value> value) {
        this.key = key;
        this.value = value;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public List<Value> getValue() {
        return value;
    }

    public void setValue(List<Value> value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof HaloDocData)) return false;
        HaloDocData that = (HaloDocData) o;
        return getKey().equals(that.getKey()) &&
                getValue().equals(that.getValue());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getKey(), getValue());
    }
}
