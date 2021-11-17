package com.narutoapis.databook.model;

import com.narutoapis.databook.enumerator.StatsEnum;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Stats {

    private StatsEnum name;
    private double value;

}
