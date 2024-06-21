package com.alco.iot.model;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.GeoPointField;

@Data
@Document(indexName = "location_data")
public class LocationData {
    @Id
    private String id;
    @GeoPointField
    private String coordinates;

}
