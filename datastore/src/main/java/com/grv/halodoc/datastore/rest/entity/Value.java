package com.grv.halodoc.datastore.rest.entity;

import com.grv.halodoc.datastore.util.ValueType;

public class Value {

    private String name;

    private ValueType type;

    private Object value;

    public Value(String name, ValueType type, Object value) {
        this.name = name;
        this.type = type;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ValueType getType() {
        return type;
    }

    public void setType(ValueType type) {
        this.type = type;
    }

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }


}
