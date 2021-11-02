package model.getTrend;

import lombok.Data;

@Data
public class queryParam {
    private int company_id;
    private int factory_id;
    private int line_id;
    private int machine_id;
    private String from;
    private String to;
}
