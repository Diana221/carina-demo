package com.qaprosoft.carina.demo.HW.api.placeholder;


import com.qaprosoft.carina.core.foundation.api.AbstractApiMethodV2;
import com.qaprosoft.carina.core.foundation.api.annotation.Endpoint;
import com.qaprosoft.carina.core.foundation.api.annotation.ResponseTemplatePath;
import com.qaprosoft.carina.core.foundation.api.annotation.SuccessfulHttpStatus;
import com.qaprosoft.carina.core.foundation.api.http.HttpMethodType;
import com.qaprosoft.carina.core.foundation.api.http.HttpResponseStatusType;
import com.qaprosoft.carina.core.foundation.utils.Configuration;

@Endpoint(url = "${base_url}/posts/1", methodType = HttpMethodType.GET)
@ResponseTemplatePath(path = "api/HW/placeholder/_get/rs.json")
@SuccessfulHttpStatus(status = HttpResponseStatusType.OK_200)
public class GetPostsMethod extends AbstractApiMethodV2 {

    public GetPostsMethod() {
        replaceUrlPlaceholder("base_url", Configuration.getEnvArg("api_url2"));
    }
}
