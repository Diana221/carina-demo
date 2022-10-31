package com.qaprosoft.carina.demo.HW.api.wazirx;

import com.qaprosoft.carina.core.foundation.api.AbstractApiMethodV2;
import com.qaprosoft.carina.core.foundation.api.annotation.Endpoint;
import com.qaprosoft.carina.core.foundation.api.annotation.RequestTemplatePath;
import com.qaprosoft.carina.core.foundation.api.annotation.ResponseTemplatePath;
import com.qaprosoft.carina.core.foundation.api.annotation.SuccessfulHttpStatus;
import com.qaprosoft.carina.core.foundation.api.http.HttpMethodType;
import com.qaprosoft.carina.core.foundation.api.http.HttpResponseStatusType;
import com.qaprosoft.carina.core.foundation.utils.Configuration;

@Endpoint(url = "${base_url}", methodType = HttpMethodType.DELETE)
@RequestTemplatePath(path = "api/HW/wazirx/_delete/rq.json")
@ResponseTemplatePath(path = "api/HW/wazirx/_delete/rs.json")
@SuccessfulHttpStatus(status = HttpResponseStatusType.BAD_REQUEST_400)
public class DeleteOrder extends AbstractApiMethodV2 {

    public DeleteOrder() {
        replaceUrlPlaceholder("base_url", Configuration.getEnvArg("api_url3"));
    }
}
