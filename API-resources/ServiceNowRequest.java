package org.example;


// POJO - plain old java object

// model, DTO, structs

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;



@Builder(toBuilder = true)
@Data
public class ServiceNowRequest {

    @JsonProperty("short_description")
    public String shortDescription;
    @Builder.Default
    public String category="software";
    @Builder.Default
    public String priority="2";
    public String impact;
    @JsonProperty("assigned_to")
    public String assigned_to;
    public String approval;


}
