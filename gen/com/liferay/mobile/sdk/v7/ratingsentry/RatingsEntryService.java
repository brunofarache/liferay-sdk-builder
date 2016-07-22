package com.liferay.mobile.sdk.v7.ratingsentry;

import com.liferay.mobile.sdk.Call;
import com.liferay.mobile.sdk.annotation.Param;
import com.liferay.mobile.sdk.annotation.Path;
import com.liferay.mobile.sdk.http.Response;
import java.lang.String;
import org.json.JSONObject;

@Path("/ratingsentry")
public interface RatingsEntryService {
  @Path("/update-entry")
  Call<JSONObject> updateEntry(@Param(name = "className") String className, @Param(name = "classPK") long classPK, @Param(name = "score") double score);

  @Path("/delete-entry")
  Call<Response> deleteEntry(@Param(name = "className") String className, @Param(name = "classPK") long classPK);
}
