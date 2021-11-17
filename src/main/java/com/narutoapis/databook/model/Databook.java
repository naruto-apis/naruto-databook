package com.narutoapis.databook.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class Databook {

    private int version;
    private List<Stats> statsList;

}
