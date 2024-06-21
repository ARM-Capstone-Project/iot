package com.alco.iot.model;

import lombok.Data;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;
@Data
@Document(indexName = "device")
public class Device {
    @Id
    private String deviceId;

    @Field(type = FieldType.Text)
    private String description;

    @Field(type = FieldType.Nested)
    private LocationData locationData;

    @Field(type = FieldType.Nested)
    private AreaInformation areaInformation;
}
