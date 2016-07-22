package com.liferay.mobile.sdk.v7.usergroup;

import com.liferay.mobile.sdk.Call;
import com.liferay.mobile.sdk.annotation.Param;
import com.liferay.mobile.sdk.annotation.Path;
import com.liferay.mobile.sdk.http.Response;
import java.lang.String;
import org.json.JSONArray;
import org.json.JSONObject;

@Path("/usergroup")
public interface UserGroupService {
  @Path("/get-user-groups")
  Call<JSONArray> getUserGroups(@Param(name = "companyId") long companyId);

  @Path("/update-user-group")
  Call<JSONObject> updateUserGroup(@Param(name = "userGroupId") long userGroupId, @Param(name = "name") String name, @Param(name = "description") String description);

  @Path("/update-user-group")
  Call<JSONObject> updateUserGroup(@Param(name = "userGroupId") long userGroupId, @Param(name = "name") String name, @Param(name = "description") String description, @Param(name = "serviceContext", className = "") JSONObject serviceContext);

  @Path("/add-user-group")
  Call<JSONObject> addUserGroup(@Param(name = "name") String name, @Param(name = "description") String description, @Param(name = "serviceContext", className = "") JSONObject serviceContext);

  @Path("/add-user-group")
  Call<JSONObject> addUserGroup(@Param(name = "name") String name, @Param(name = "description") String description);

  @Path("/fetch-user-group")
  Call<JSONObject> fetchUserGroup(@Param(name = "userGroupId") long userGroupId);

  @Path("/get-user-user-groups")
  Call<JSONArray> getUserUserGroups(@Param(name = "userId") long userId);

  @Path("/get-user-group")
  Call<JSONObject> getUserGroup(@Param(name = "name") String name);

  @Path("/get-user-group")
  Call<JSONObject> getUserGroup(@Param(name = "userGroupId") long userGroupId);

  @Path("/delete-user-group")
  Call<Response> deleteUserGroup(@Param(name = "userGroupId") long userGroupId);

  @Path("/add-team-user-groups")
  Call<Response> addTeamUserGroups(@Param(name = "teamId") long teamId, @Param(name = "userGroupIds") JSONArray userGroupIds);

  @Path("/add-group-user-groups")
  Call<Response> addGroupUserGroups(@Param(name = "groupId") long groupId, @Param(name = "userGroupIds") JSONArray userGroupIds);

  @Path("/unset-group-user-groups")
  Call<Response> unsetGroupUserGroups(@Param(name = "groupId") long groupId, @Param(name = "userGroupIds") JSONArray userGroupIds);

  @Path("/unset-team-user-groups")
  Call<Response> unsetTeamUserGroups(@Param(name = "teamId") long teamId, @Param(name = "userGroupIds") JSONArray userGroupIds);
}
