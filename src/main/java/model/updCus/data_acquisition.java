package model.updCus;

import lombok.Data;

@Data
public class data_acquisition {

    private Integer number_of_times_in_last_month;
    private Integer last_stop_days;
    private Integer scheduled_number_of_times;
    private Integer total_number_of_times;
    private String comment;
    private String final_acquisition_date;
    private Integer last_last_stop_day;
    private Integer unacquired_alert;

}
