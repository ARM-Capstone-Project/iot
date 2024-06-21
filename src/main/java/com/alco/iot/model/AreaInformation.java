package com.alco.iot.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

@Data
@Document(indexName = "area_information")
public class AreaInformation {
    @Id
    private String areaId;

    private String areaName;
    @Field(type = FieldType.Text)
    private String description;
    @Field(type = FieldType.Nested)
    private LocationData topEast;

    private LocationData topWest;
    private LocationData bottomEast;
    private LocationData bottomWest;
    private LocationData center;

}
