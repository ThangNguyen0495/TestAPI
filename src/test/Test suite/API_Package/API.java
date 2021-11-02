package API_Package;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import model.getTrend.queryParam;
import model.signIn.signIn;
import model.updCus.*;
import java.util.ArrayList;
import java.util.List;

import java.io.File;

import static Variable.Variable.*;
import static io.restassured.RestAssured.given;

public class API {

    /**
     * API 1-1: signIn
     */
    public Response signIn() {

        // Set body
        signIn body = new signIn();
        body.setUser_id(user_id);
        body.setPassword(password);

        //response API 1-1
        return given()
                .contentType(ContentType.JSON)
                .when()
                .body(body)
                .post("/api/auth/signIn");
    }

    /**
     * API 3-1: getCustomerlist
     */
    public Response getCus(String token) {

        //response API 3-1
        return given()
                .auth()
                .oauth2(token)
                .when()
                .get("/api/customer-information");
    }

    /**
     * API 3-2: updateCustomerlist
     */
    public Response updCus(String token) {
        //data_acquisition
        data_acquisition data_acquisition = new data_acquisition();
        data_acquisition.setScheduled_number_of_times(scheduled_number_of_times);
        data_acquisition.setFinal_acquisition_date(final_acquisition_date);
        data_acquisition.setLast_stop_days(last_stop_days);
        data_acquisition.setNumber_of_times_in_last_month(number_of_times_in_last_month);
        data_acquisition.setTotal_number_of_times(total_number_of_times);
        data_acquisition.setLast_last_stop_day(last_last_stop_day);
        data_acquisition.setUnacquired_alert(unacquired_alert);
        data_acquisition.setComment(comment_data);

        //alert
        alert alert = new alert();
        alert.setPrevious(previous);
        alert.setStandard(standard);
        alert.setAverage(average);
        alert.setMedian(median);

        //next_time_follow
        next_time_follow next_time_follow = new next_time_follow();
        next_time_follow.setDate(date);
        next_time_follow.setNote(note);

        //customers
        customers customers = new customers();
        customers.setCompany_id(company_id);
        customers.setCompany_name(company_name);
        customers.setFactory_id(factory_id);
        customers.setFactory_name(factory_name);
        customers.setLine_id(line_id);
        customers.setLine_name(line_name);
        customers.setMachine_id(machine_id);
        customers.setMachine_name(machine_name);
        customers.setService_id(service_id);
        customers.setService_name(service_name);
        customers.setSerial_id(serial_id);
        customers.setSerial_no(serial_no);
        customers.setThk_sale(thk_sale);
        customers.setThk_office(thk_office);
        customers.setThk_team(thk_team);
        customers.setStart_month(start_month);
        customers.setContract_period(contract_period);
        customers.setShip_date(ship_date);
        customers.setMail(mail);
        customers.setTel(tel);
        customers.setComment(comment_cus);
        customers.setCnc_plc(cnc_plc);
        customers.setBatch_trigger(batch_trigger);
        customers.setThreshold(threshold);
        customers.setDiag_mode(diag_mode);
        customers.setUser_representative(user_representative);
        customers.setThreshold_setting(threshold_setting);
        customers.setData_acquisition(data_acquisition);
        customers.setAlert(alert);
        customers.setNext_time_follow(next_time_follow);

        //updCusbody
        List<customers> customers1 = new ArrayList<>();
        customers1.add(customers);
        updCus body = new updCus();

        //response API 3-2
        return given()
                .contentType(ContentType.JSON)
                .auth()
                .oauth2(token)
                .when()
                .body(customers1)
                .put("/api/customer-information");
    }

    /**
     * API 4-1: getTrendygraph
     */
    public Response getTrend(String token) {

        //set query param
        queryParam query = new queryParam();
        query.setCompany_id(company_id);
        query.setFactory_id(factory_id);
        query.setLine_id(line_id);
        query.setMachine_id(machine_id);
        query.setFrom(from);
        query.setTo(to);

        // response API 4-1
        return given()
                .auth()
                .oauth2(token)
                .queryParam("company_id", query.getCompany_id())
                .queryParam("factory_id", query.getFactory_id())
                .queryParam("line_id", query.getLine_id())
                .queryParam("machine_id", query.getMachine_id())
                .queryParam("from", query.getFrom())
                .queryParam("to", query.getTo())
                .when()
                .get("/api/data-confirmation/trendy");
    }
}