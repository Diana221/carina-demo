package com.qaprosoft.carina.demo.HW;

import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.qaprosoft.carina.core.foundation.api.http.HttpResponseStatusType;
import com.qaprosoft.carina.core.foundation.utils.ownership.MethodOwner;
import com.qaprosoft.carina.demo.HW.wazirx.DeleteOrder;
import com.qaprosoft.carina.demo.HW.wazirx.GetStatus;
import com.qaprosoft.carina.demo.HW.wazirx.GetTrades;
import com.qaprosoft.carina.demo.HW.wazirx.PostOrder;
import org.testng.annotations.Test;

public class WazirxTest implements IAbstractTest {

    @Test()
    @MethodOwner(owner = "diana")
    public void postOrder() {
        PostOrder api = new PostOrder();
        api.setHeaders(String.format("X-Api-Key=%s",
                "HnH6rzZMXodzH9FjAEdU68Egnqb6QLvwFbeRsoDLeJhNQ8fyBqtWcLQX75OLZl3A"));
        api.expectResponseStatus(HttpResponseStatusType.BAD_REQUEST_400);
        api.callAPI();
    }


    @Test()
    @MethodOwner(owner = "diana")
    public void getStatus() {
        GetStatus getStatus = new GetStatus();
        getStatus.callAPIExpectSuccess();
        getStatus.validateResponseAgainstSchema("api/HW/wazirx/_get/rs.schema");
    }


    @Test()
    @MethodOwner(owner = "diana")
    public void getTrades() {
        GetTrades getTrades = new GetTrades();
        getTrades.callAPIExpectSuccess();
        getTrades.validateResponseAgainstSchema("api/HW/wazirx/_getTrades/rs.schema");
    }


    @Test()
    @MethodOwner(owner = "diana")
    public void deleteOrder() {
        DeleteOrder deleteUserMethod = new DeleteOrder();
        deleteUserMethod.callAPIExpectSuccess();
        deleteUserMethod.validateResponseAgainstSchema("api/HW/wazirx/_delete/rs.json");
    }
}
