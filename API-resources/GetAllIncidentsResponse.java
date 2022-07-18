package org.example;

import lombok.Getter;

import java.util.List;

@Getter
public class GetAllIncidentsResponse {

    List<CreateIncidentResponse.Result> result;
}
