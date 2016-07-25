package com.liferay.mobile.sdk.v62.mdrrule;

import com.liferay.mobile.sdk.Call;
import com.liferay.mobile.sdk.annotation.Param;
import com.liferay.mobile.sdk.annotation.Path;
import com.liferay.mobile.sdk.http.Response;
import java.lang.String;
import java.util.Map;
import org.json.JSONObject;

@Path("/mdrrule")
public interface MDRRuleService {
  @Path("/add-rule")
  Call<JSONObject> addRule(@Param(name = "ruleGroupId") long ruleGroupId, @Param(name = "nameMap") Map nameMap, @Param(name = "descriptionMap") Map descriptionMap, @Param(name = "type") String type, @Param(name = "typeSettings") String typeSettings, @Param(name = "serviceContext", className = "com.liferay.portal.service.ServiceContext") JSONObject serviceContext);

  @Path("/delete-rule")
  Call<Response> deleteRule(@Param(name = "ruleId") long ruleId);

  @Path("/fetch-rule")
  Call<JSONObject> fetchRule(@Param(name = "ruleId") long ruleId);

  @Path("/get-rule")
  Call<JSONObject> getRule(@Param(name = "ruleId") long ruleId);

  @Path("/update-rule")
  Call<JSONObject> updateRule(@Param(name = "ruleId") long ruleId, @Param(name = "nameMap") Map nameMap, @Param(name = "descriptionMap") Map descriptionMap, @Param(name = "type") String type, @Param(name = "typeSettings") String typeSettings, @Param(name = "serviceContext", className = "com.liferay.portal.service.ServiceContext") JSONObject serviceContext);

  @Path("/update-rule")
  Call<JSONObject> updateRule(@Param(name = "ruleId") long ruleId, @Param(name = "nameMap") Map nameMap, @Param(name = "descriptionMap") Map descriptionMap, @Param(name = "type") String type, @Param(name = "typeSettingsProperties", className = "com.liferay.portal.kernel.util.UnicodeProperties") JSONObject typeSettingsProperties, @Param(name = "serviceContext", className = "com.liferay.portal.service.ServiceContext") JSONObject serviceContext);
}
