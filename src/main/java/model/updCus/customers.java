package model.updCus;

import lombok.Data;

@Data
public class customers {
    private String contract_period;
    private String mail;
    private String factory_name;
    private String threshold;
    private String machine_name;
    private Integer line_id;
    private next_time_follow next_time_follow;
    private alert alert;
    private Integer service_id;
    private Integer serial_id;
    private String thk_sale;
    private String line_name;
    private String tel;
    private String batch_trigger;
    private String user_representative;
    private String thk_office;
    private String cnc_plc;
    private Integer company_id;
    private String service_name;
    private Integer machine_id;
    private Integer factory_id;
    private String thk_team;
    private String diag_mode;
    private String company_name;
    private String start_month;
    private String comment;
    private String threshold_setting;
    private String serial_no;
    private data_acquisition data_acquisition;
    private String ship_date;
}
