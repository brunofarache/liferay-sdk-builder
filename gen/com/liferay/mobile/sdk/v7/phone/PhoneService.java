package com.liferay.mobile.sdk.v7.phone;

import com.liferay.mobile.sdk.Call;
import com.liferay.mobile.sdk.annotation.Param;
import com.liferay.mobile.sdk.annotation.Path;
import com.liferay.mobile.sdk.http.Response;
import java.lang.String;
import org.json.JSONArray;
import org.json.JSONObject;

@Path("/phone")
public interface PhoneService {
  @Path("/get-phones")
  Call<JSONArray> getPhones(@Param(name = "className") String className, @Param(name = "classPK") long classPK);

  @Path("/update-phone")
  Call<JSONObject> updatePhone(@Param(name = "phoneId") long phoneId, @Param(name = "number") String number, @Param(name = "extension") String extension, @Param(name = "typeId") long typeId, @Param(name = "primary") boolean primary);

  @Path("/add-phone")
  Call<JSONObject> addPhone(@Param(name = "className") String className, @Param(name = "classPK") long classPK, @Param(name = "number") String number, @Param(name = "extension") String extension, @Param(name = "typeId") long typeId, @Param(name = "primary") boolean primary, @Param(name = "serviceContext", className = "") JSONObject serviceContext);

  @Path("/delete-phone")
  Call<Response> deletePhone(@Param(name = "phoneId") long phoneId);

  @Path("/get-phone")
  Call<JSONObject> getPhone(@Param(name = "phoneId") long phoneId);
}
