
package com.qaprosoft.carina.demo.HW.api.placeholder;

import com.qaprosoft.carina.core.foundation.api.AbstractApiMethodV2;
import com.qaprosoft.carina.core.foundation.api.annotation.Endpoint;
import com.qaprosoft.carina.core.foundation.api.annotation.RequestTemplatePath;
import com.qaprosoft.carina.core.foundation.api.annotation.ResponseTemplatePath;
import com.qaprosoft.carina.core.foundation.api.annotation.SuccessfulHttpStatus;
import com.qaprosoft.carina.core.foundation.api.http.HttpMethodType;
import com.qaprosoft.carina.core.foundation.api.http.HttpResponseStatusType;
import com.qaprosoft.carina.core.foundation.utils.Configuration;


@Endpoint(url = "${base_url}/posts/1", methodType = HttpMethodType.PUT)
@RequestTemplatePath(path = "api/HW/placeholder//_put/rq.json")
@ResponseTemplatePath(path = "api/HW/placeholder//_put/rs.json")
@SuccessfulHttpStatus(status = HttpResponseStatusType.OK_200)
public class PutPostMethod extends AbstractApiMethodV2 {

    public PutPostMethod() {
        super("api/HW/placeholder/_put/rq.json", "api/HW/placeholder//_put/rs.json");
        replaceUrlPlaceholder("base_url", Configuration.getEnvArg("api_url2"));
    }
}