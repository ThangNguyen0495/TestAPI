package Variable;

public class Variable {
    //Uri
    public static String Uri ="https://sit-thk-app-server.azurewebsites.net";

    //body API 1-1: signIn
    public static String user_id = "CMC@cmc.co.jp";
    public static String password = "0123456789";

    //body API 3-2: updateCustomerlist
    public static String company_name = "株式会社ダ事業部";
    public static String factory_name = "滋賀事業所　J棟";
    public static String line_name = "ApiTestChangeLine";
    public static String machine_name = "RM D-10000";
    public static int service_id = 1;
    public static String service_name = "OMNIedge_Multi";
    public static String serial_no = "GSD7224954";
    public static int serial_id = 1;
    public static String thk_sale = null;
    public static String thk_team = null;
    public static String thk_office = null;
    public static String start_month = null;
    public static String contract_period = null;
    public static String ship_date = null;
    public static String mail = null;
    public static String tel = null;
    public static String comment_cus = null;
    public static String cnc_plc = null;
    public static String batch_trigger = null;
    public static String threshold = null;
    public static String diag_mode = null;
    public static String user_representative = null;
    public static String threshold_setting = null;
    //data_acquisition
    public static int scheduled_number_of_times = 123;
    public static String final_acquisition_date = "2020/12/17";
    public static int last_stop_days = 308;
    public static int number_of_times_in_last_month = 0;
    public static int total_number_of_times = 60;
    public static int last_last_stop_day = 0;
    public static int unacquired_alert = 1;
    public static String comment_data = "tessst";
    //alert
    public static int previous = 0;
    public static int standard = 0;
    public static int average = 0;
    public static int median = 0;
    //next_time_follow
    public static String date = null;
    public static String note = "";

    //query param API 4-1: getTrendygarph
    public static int company_id = 3;
    public static int factory_id = 1;
    public static int line_id = 1;
    public static int machine_id = 1;
    public static String from ="2020-01-01";
    public static String to = "2021-11-01";


}
