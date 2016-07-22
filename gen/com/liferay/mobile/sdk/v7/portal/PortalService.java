package com.liferay.mobile.sdk.v7.portal;

import com.liferay.mobile.sdk.Call;
import com.liferay.mobile.sdk.annotation.Param;
import com.liferay.mobile.sdk.annotation.Path;
import com.liferay.mobile.sdk.http.Response;
import java.lang.Boolean;
import java.lang.Integer;
import java.lang.String;

@Path("/portal")
public interface PortalService {
  @Path("/get-build-number")
  Call<Integer> getBuildNumber();

  @Path("/get-version")
  Call<String> getVersion();

  @Path("/test-add-class-name_-rollback")
  Call<Response> testAddClassName_Rollback(@Param(name = "classNameValue") String classNameValue);

  @Path("/test-add-class-name-and-test-transaction-portlet-bar_-portlet-rollback")
  Call<Response> testAddClassNameAndTestTransactionPortletBar_PortletRollback(@Param(name = "transactionPortletBarText") String transactionPortletBarText);

  @Path("/test-add-class-name-and-test-transaction-portlet-bar_-portal-rollback")
  Call<Response> testAddClassNameAndTestTransactionPortletBar_PortalRollback(@Param(name = "transactionPortletBarText") String transactionPortletBarText);

  @Path("/get-auto-deploy-directory")
  Call<String> getAutoDeployDirectory();

  @Path("/test-add-class-name-and-test-transaction-portlet-bar_-success")
  Call<Response> testAddClassNameAndTestTransactionPortletBar_Success(@Param(name = "transactionPortletBarText") String transactionPortletBarText);

  @Path("/test-auto-sync-hibernate-session-state-on-tx-creation")
  Call<Response> testAutoSyncHibernateSessionStateOnTxCreation();

  @Path("/test-delete-class-name")
  Call<Response> testDeleteClassName();

  @Path("/test-get-build-number")
  Call<Integer> testGetBuildNumber();

  @Path("/test-get-user-id")
  Call<Response> testGetUserId();

  @Path("/test-has-class-name")
  Call<Boolean> testHasClassName();

  @Path("/test-add-class-name_-success")
  Call<Response> testAddClassName_Success(@Param(name = "classNameValue") String classNameValue);
}
