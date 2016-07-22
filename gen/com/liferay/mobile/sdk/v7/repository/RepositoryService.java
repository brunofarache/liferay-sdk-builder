package com.liferay.mobile.sdk.v7.repository;

import com.liferay.mobile.sdk.Call;
import com.liferay.mobile.sdk.annotation.Param;
import com.liferay.mobile.sdk.annotation.Path;
import com.liferay.mobile.sdk.http.Response;
import java.lang.String;
import org.json.JSONArray;
import org.json.JSONObject;

@Path("/repository")
public interface RepositoryService {
  @Path("/get-type-settings-properties")
  Call<JSONObject> getTypeSettingsProperties(@Param(name = "repositoryId") long repositoryId);

  @Path("/get-repository")
  Call<JSONObject> getRepository(@Param(name = "repositoryId") long repositoryId);

  @Path("/add-repository")
  Call<JSONObject> addRepository(@Param(name = "groupId") long groupId, @Param(name = "classNameId") long classNameId, @Param(name = "parentFolderId") long parentFolderId, @Param(name = "name") String name, @Param(name = "description") String description, @Param(name = "portletId") String portletId, @Param(name = "typeSettingsProperties", className = "") JSONObject typeSettingsProperties, @Param(name = "serviceContext", className = "") JSONObject serviceContext);

  @Path("/update-repository")
  Call<Response> updateRepository(@Param(name = "repositoryId") long repositoryId, @Param(name = "name") String name, @Param(name = "description") String description);

  @Path("/delete-repository")
  Call<Response> deleteRepository(@Param(name = "repositoryId") long repositoryId);

  @Path("/check-repository")
  Call<Response> checkRepository(@Param(name = "repositoryId") long repositoryId);

  @Path("/get-supported-parameters")
  Call<JSONArray> getSupportedParameters(@Param(name = "classNameId") long classNameId, @Param(name = "configuration") String configuration);

  @Path("/get-supported-parameters")
  Call<JSONArray> getSupportedParameters(@Param(name = "className") String className, @Param(name = "configuration") String configuration);

  @Path("/get-supported-configurations")
  Call<JSONArray> getSupportedConfigurations(@Param(name = "classNameId") long classNameId);
}
