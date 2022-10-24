package com.qaprosoft.carina.demo.HW;

import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.qaprosoft.carina.core.foundation.api.http.HttpResponseStatusType;
import com.qaprosoft.carina.core.foundation.utils.ownership.MethodOwner;
import com.qaprosoft.carina.demo.HW.bored.GetActivity;
import com.qaprosoft.carina.demo.HW.bored.GetFreeActivity;
import com.qaprosoft.carina.demo.HW.wazirx.PostOrder;
import org.testng.annotations.Test;

public class BoredTest implements IAbstractTest {

    @Test()
    @MethodOwner(owner = "diana")
    public void getActivity() {
        GetActivity getActivity = new GetActivity();
        getActivity.callAPIExpectSuccess();
        getActivity.validateResponseAgainstSchema("api/HW/bored/_get/rs.schema");
    }

    @Test()
    @MethodOwner(owner = "diana")
    public void getFreeActivity() {
        GetFreeActivity getFreeActivity = new GetFreeActivity();
        getFreeActivity.callAPIExpectSuccess();
        getFreeActivity.validateResponseAgainstSchema("api/HW/bored/_getFree/rs.schema");
    }

}
