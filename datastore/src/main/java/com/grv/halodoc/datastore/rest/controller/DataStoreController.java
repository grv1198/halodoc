package com.grv.halodoc.datastore.rest.controller;

import com.grv.halodoc.datastore.rest.entity.HaloDocData;
import com.grv.halodoc.datastore.rest.service.DataStoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;



/**
 * CRUD apis for data store
 */
@Controller
@RequestMapping("/halodoc")
public class DataStoreController {


    @Autowired
    private DataStoreService dataStoreService;


    // Create/Update.

    @RequestMapping(method = RequestMethod.PUT, path = "/")
    public ResponseEntity<Object> saveData(@RequestBody HaloDocData haloDocData) {

        boolean ok = this.dataStoreService.saveData(haloDocData.getKey(), haloDocData.getValue());
        return ok ? ResponseEntity.status(HttpStatus.CREATED).body(haloDocData.getKey()) : ResponseEntity.badRequest().body(haloDocData);

    }


    @RequestMapping(method = RequestMethod.GET, path = "/{key}")
    public ResponseEntity<HaloDocData> getData(@PathVariable String key) {

        final  HaloDocData data = this.dataStoreService.getData(key);

        return ResponseEntity.status(HttpStatus.FOUND).body(data);

    }


    @RequestMapping(method = RequestMethod.DELETE, path = "/{key}")
    public ResponseEntity<String> deleteData(@PathVariable String key) {

        boolean   deleted = this.dataStoreService.deleteData(key);

        return ResponseEntity.status(HttpStatus.OK).body(key);

    }

    // Update few Values

    @RequestMapping(method = RequestMethod.PUT, path = "/{key}")
    public ResponseEntity<Object> updateDataValues(@PathVariable String key, @RequestBody HaloDocData haloDocData) {

        this.dataStoreService.updateDataValues(haloDocData.getKey(), haloDocData.getValue());
        return ResponseEntity.status(HttpStatus.OK).body(haloDocData.getKey());

    }

}
