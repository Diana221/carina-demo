package com.qaprosoft.carina.demo.HW.api;

import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.qaprosoft.carina.core.foundation.utils.ownership.MethodOwner;
import com.qaprosoft.carina.demo.HW.api.placeholder.GetPostsMethod;
import com.qaprosoft.carina.demo.HW.api.placeholder.PostMethod;
import com.qaprosoft.carina.demo.HW.api.placeholder.PutPostMethod;
import org.testng.annotations.Test;

public class PlaceholderTest implements IAbstractTest {

    @Test()
    @MethodOwner(owner = "diana")
    public void postTest(){
        PostMethod api = new PostMethod();
        api.callAPIExpectSuccess();
        api.validateResponse();
    }

    @Test()
    @MethodOwner(owner = "diana")
    public void putTest() {
        PutPostMethod api = new PutPostMethod();
        api.callAPIExpectSuccess();
        api.validateResponse();
    }

    @Test()
    @MethodOwner(owner = "diana")
    public void getPost() {
        GetPostsMethod getPostsMethod = new GetPostsMethod();
        getPostsMethod.callAPIExpectSuccess();
        getPostsMethod.validateResponseAgainstSchema("api/HW/placeholder/_get/rs.schema");
    }

}
