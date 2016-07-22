package com.liferay.mobile.sdk.v7.layoutset;

import com.liferay.mobile.sdk.Call;
import com.liferay.mobile.sdk.annotation.Param;
import com.liferay.mobile.sdk.annotation.Path;
import com.liferay.mobile.sdk.http.Response;
import java.lang.String;
import org.json.JSONObject;

@Path("/layoutset")
public interface LayoutSetService {
  @Path("/update-virtual-host")
  Call<JSONObject> updateVirtualHost(@Param(name = "groupId") long groupId, @Param(name = "privateLayout") boolean privateLayout, @Param(name = "virtualHost") String virtualHost);

  @Path("/update-settings")
  Call<JSONObject> updateSettings(@Param(name = "groupId") long groupId, @Param(name = "privateLayout") boolean privateLayout, @Param(name = "settings") String settings);

  @Path("/update-layout-set-prototype-link-enabled")
  Call<Response> updateLayoutSetPrototypeLinkEnabled(@Param(name = "groupId") long groupId, @Param(name = "privateLayout") boolean privateLayout, @Param(name = "layoutSetPrototypeLinkEnabled") boolean layoutSetPrototypeLinkEnabled, @Param(name = "layoutSetPrototypeUuid") String layoutSetPrototypeUuid);

  @Path("/update-logo")
  Call<Response> updateLogo(@Param(name = "groupId") long groupId, @Param(name = "privateLayout") boolean privateLayout, @Param(name = "logo") boolean logo, @Param(name = "file", className = "") JSONObject file);

  @Path("/update-logo")
  Call<Response> updateLogo(@Param(name = "groupId") long groupId, @Param(name = "privateLayout") boolean privateLayout, @Param(name = "logo") boolean logo, @Param(name = "bytes") byte[] bytes);

  @Path("/update-look-and-feel")
  Call<JSONObject> updateLookAndFeel(@Param(name = "groupId") long groupId, @Param(name = "privateLayout") boolean privateLayout, @Param(name = "themeId") String themeId, @Param(name = "colorSchemeId") String colorSchemeId, @Param(name = "css") String css);
}
