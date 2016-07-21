package com.liferay.mobile.sdk.v62.portletpreferences;

import com.liferay.mobile.sdk.Call;
import com.liferay.mobile.sdk.annotation.Param;
import com.liferay.mobile.sdk.annotation.Path;
import com.liferay.mobile.sdk.http.Response;
import java.lang.String;
import org.json.JSONObject;

@Path("/portletpreferences")
public interface PortletPreferencesService {
  @Path("/delete-archived-preferences")
  Call<Response> deleteArchivedPreferences(@Param(name = "portletItemId") long portletItemId);

  @Path("/restore-archived-preferences")
  Call<Response> restoreArchivedPreferences(@Param(name = "groupId") long groupId, @Param(name = "layout", className = "com.liferay.portal.model.Layout") JSONObject layout, @Param(name = "portletId") String portletId, @Param(name = "portletItem", className = "com.liferay.portal.model.PortletItem") JSONObject portletItem, @Param(name = "preferences", className = "javax.portlet.PortletPreferences") JSONObject preferences);

  @Path("/restore-archived-preferences")
  Call<Response> restoreArchivedPreferences(@Param(name = "groupId") long groupId, @Param(name = "layout", className = "com.liferay.portal.model.Layout") JSONObject layout, @Param(name = "portletId") String portletId, @Param(name = "portletItemId") long portletItemId, @Param(name = "preferences", className = "javax.portlet.PortletPreferences") JSONObject preferences);

  @Path("/restore-archived-preferences")
  Call<Response> restoreArchivedPreferences(@Param(name = "groupId") long groupId, @Param(name = "name") String name, @Param(name = "layout", className = "com.liferay.portal.model.Layout") JSONObject layout, @Param(name = "portletId") String portletId, @Param(name = "preferences", className = "javax.portlet.PortletPreferences") JSONObject preferences);

  @Path("/update-archive-preferences")
  Call<Response> updateArchivePreferences(@Param(name = "userId") long userId, @Param(name = "groupId") long groupId, @Param(name = "name") String name, @Param(name = "portletId") String portletId, @Param(name = "preferences", className = "javax.portlet.PortletPreferences") JSONObject preferences);
}
