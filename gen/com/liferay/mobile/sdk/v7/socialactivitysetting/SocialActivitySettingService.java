package com.liferay.mobile.sdk.v7.socialactivitysetting;

import com.liferay.mobile.sdk.Call;
import com.liferay.mobile.sdk.annotation.Param;
import com.liferay.mobile.sdk.annotation.Path;
import com.liferay.mobile.sdk.http.Response;
import java.lang.String;
import org.json.JSONArray;
import org.json.JSONObject;

@Path("/socialactivitysetting")
public interface SocialActivitySettingService {
  @Path("/get-activity-definition")
  Call<JSONObject> getActivityDefinition(@Param(name = "groupId") long groupId, @Param(name = "className") String className, @Param(name = "activityType") int activityType);

  @Path("/get-activity-definitions")
  Call<JSONArray> getActivityDefinitions(@Param(name = "groupId") long groupId, @Param(name = "className") String className);

  @Path("/get-json-activity-definitions")
  Call<JSONObject> getJSONActivityDefinitions(@Param(name = "groupId") long groupId, @Param(name = "className") String className);

  @Path("/get-activity-settings")
  Call<JSONArray> getActivitySettings(@Param(name = "groupId") long groupId);

  @Path("/update-activity-setting")
  Call<Response> updateActivitySetting(@Param(name = "groupId") long groupId, @Param(name = "className") String className, @Param(name = "activityType") int activityType, @Param(name = "activityCounterDefinition", className = "") JSONObject activityCounterDefinition);

  @Path("/update-activity-setting")
  Call<Response> updateActivitySetting(@Param(name = "groupId") long groupId, @Param(name = "className") String className, @Param(name = "enabled") boolean enabled);

  @Path("/update-activity-settings")
  Call<Response> updateActivitySettings(@Param(name = "groupId") long groupId, @Param(name = "className") String className, @Param(name = "activityType") int activityType, @Param(name = "activityCounterDefinitions") JSONArray activityCounterDefinitions);
}
