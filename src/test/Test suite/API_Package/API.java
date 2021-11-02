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
        customers customer = new customers();
        customer.setCompany_id(company_id_upd);
        customer.setCompany_name(company_name);
        customer.setFactory_id(factory_id_upd);
        customer.setFactory_name(factory_name);
        customer.setLine_id(line_id_upd);
        customer.setLine_name(line_name);
        customer.setMachine_id(machine_id_upd);
        customer.setMachine_name(machine_name);
        customer.setService_id(service_id);
        customer.setService_name(service_name);
        customer.setSerial_id(serial_id);
        customer.setSerial_no(serial_no);
        customer.setThk_sale(thk_sale);
        customer.setThk_office(thk_office);
        customer.setThk_team(thk_team);
        customer.setStart_month(start_month);
        customer.setContract_period(contract_period);
        customer.setShip_date(ship_date);
        customer.setMail(mail);
        customer.setTel(tel);
        customer.setComment(comment_cus);
        customer.setCnc_plc(cnc_plc);
        customer.setBatch_trigger(batch_trigger);
        customer.setThreshold(threshold);
        customer.setDiag_mode(diag_mode);
        customer.setUser_representative(user_representative);
        customer.setThreshold_setting(threshold_setting);
        customer.setData_acquisition(data_acquisition);
        customer.setAlert(alert);
        customer.setNext_time_follow(next_time_follow);

        //updCusbody
        List<customers> customers = new ArrayList<customers>();
        customers.add(customer);
        updCus body = new updCus();
        body.setCustomers(customers);

        //response API 3-2
        return given()
                .contentType(ContentType.JSON)
                .auth()
                .oauth2(token)
                .when()
                .body(body)
                .put("/api/customer-information");
    }

    /**
     * API 4-1: getTrendygraph
     */
    public Response getTrend(String token) {

        //set query param
        queryParam query = new queryParam();
        query.setCompany_id(company_id_trend);
        query.setFactory_id(factory_id_trend);
        query.setLine_id(line_id_trend);
        query.setMachine_id(machine_id_trend);
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