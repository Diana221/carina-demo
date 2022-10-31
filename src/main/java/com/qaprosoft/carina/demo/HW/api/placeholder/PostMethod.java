
package com.qaprosoft.carina.demo.HW.api.placeholder;

import com.qaprosoft.carina.core.foundation.api.AbstractApiMethodV2;
import com.qaprosoft.carina.core.foundation.api.annotation.Endpoint;
import com.qaprosoft.carina.core.foundation.api.annotation.RequestTemplatePath;
import com.qaprosoft.carina.core.foundation.api.annotation.ResponseTemplatePath;
import com.qaprosoft.carina.core.foundation.api.annotation.SuccessfulHttpStatus;
import com.qaprosoft.carina.core.foundation.api.http.HttpMethodType;
import com.qaprosoft.carina.core.foundation.api.http.HttpResponseStatusType;
import com.qaprosoft.carina.core.foundation.utils.Configuration;


@Endpoint(url = "${base_url}/posts", methodType = HttpMethodType.POST)
@RequestTemplatePath(path = "api/HW/placeholder/_post/rq.json")
@ResponseTemplatePath(path = "api/HW/placeholder/_post/rs.json")
@SuccessfulHttpStatus(status = HttpResponseStatusType.CREATED_201)
public class PostMethod extends AbstractApiMethodV2 {

    public PostMethod() {
        super("api/HW/placeholder/_post/rq.json", "api/HW/placeholder/_post/rs.json");
        replaceUrlPlaceholder("base_url", Configuration.getEnvArg("api_url2"));
    }
}
