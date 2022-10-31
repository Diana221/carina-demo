package com.qaprosoft.carina.demo.HW.api;

import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.qaprosoft.carina.core.foundation.utils.ownership.MethodOwner;
import com.qaprosoft.carina.demo.HW.api.bored.GetActivityMethod;
import com.qaprosoft.carina.demo.HW.api.bored.GetFreeActivityMethod;
import org.testng.annotations.Test;

public class BoredTest implements IAbstractTest {

    @Test()
    @MethodOwner(owner = "diana")
    public void getActivity() {
        GetActivityMethod getActivityMethod = new GetActivityMethod();
        getActivityMethod.callAPIExpectSuccess();
        getActivityMethod.validateResponseAgainstSchema("api/HW/bored/_get/rs.schema");
    }

    @Test()
    @MethodOwner(owner = "diana")
    public void getFreeActivity() {
        GetFreeActivityMethod getFreeActivityMethod = new GetFreeActivityMethod();
        getFreeActivityMethod.callAPIExpectSuccess();
        getFreeActivityMethod.validateResponseAgainstSchema("api/HW/bored/_getFree/rs.schema");
    }

}
