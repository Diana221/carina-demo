package com.qaprosoft.carina.demo;

import com.qaprosoft.apitools.validation.JsonCompareKeywords;
import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.qaprosoft.carina.core.foundation.utils.ownership.MethodOwner;
import com.qaprosoft.carina.demo.bored.GetActivity;
import com.qaprosoft.carina.demo.bored.GetFreeActivity;
import org.skyscreamer.jsonassert.JSONCompareMode;
import org.testng.annotations.Test;

public class BoredTest implements IAbstractTest {

    @Test()
    @MethodOwner(owner = "diana")
    public void GetActivity() {
        GetActivity getActivity = new GetActivity();
        getActivity.callAPIExpectSuccess();
       // getActivity.validateResponse(JSONCompareMode.STRICT, JsonCompareKeywords.ARRAY_CONTAINS.getKey());
        getActivity.validateResponseAgainstSchema("api/bored/_get/rs.schema");
    }

    @Test()
    @MethodOwner(owner = "diana")
    public void GetFreeActivity() {
        GetFreeActivity getFreeActivity = new GetFreeActivity();
        getFreeActivity.callAPIExpectSuccess();
        //getFreeActivity.validateResponse(JSONCompareMode.STRICT, JsonCompareKeywords.ARRAY_CONTAINS.getKey());
        getFreeActivity.validateResponseAgainstSchema("api/bored/_getFree/rs.schema");
    }
}
