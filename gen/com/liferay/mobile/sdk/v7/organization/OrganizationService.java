package com.liferay.mobile.sdk.v7.organization;

import com.liferay.mobile.sdk.Call;
import com.liferay.mobile.sdk.annotation.Param;
import com.liferay.mobile.sdk.annotation.Path;
import com.liferay.mobile.sdk.http.Response;
import java.lang.Integer;
import java.lang.Long;
import java.lang.String;
import org.json.JSONArray;
import org.json.JSONObject;

@Path("/organization")
public interface OrganizationService {
  @Path("/add-group-organizations")
  Call<Response> addGroupOrganizations(@Param(name = "groupId") long groupId, @Param(name = "organizationIds") JSONArray organizationIds);

  @Path("/add-organization")
  Call<JSONObject> addOrganization(@Param(name = "parentOrganizationId") long parentOrganizationId, @Param(name = "name") String name, @Param(name = "type") String type, @Param(name = "regionId") long regionId, @Param(name = "countryId") long countryId, @Param(name = "statusId") long statusId, @Param(name = "comments") String comments, @Param(name = "site") boolean site, @Param(name = "addresses") JSONArray addresses, @Param(name = "emailAddresses") JSONArray emailAddresses, @Param(name = "orgLabors") JSONArray orgLabors, @Param(name = "phones") JSONArray phones, @Param(name = "websites") JSONArray websites, @Param(name = "serviceContext", className = "") JSONObject serviceContext);

  @Path("/add-organization")
  Call<JSONObject> addOrganization(@Param(name = "parentOrganizationId") long parentOrganizationId, @Param(name = "name") String name, @Param(name = "type") String type, @Param(name = "regionId") long regionId, @Param(name = "countryId") long countryId, @Param(name = "statusId") long statusId, @Param(name = "comments") String comments, @Param(name = "site") boolean site, @Param(name = "serviceContext", className = "") JSONObject serviceContext);

  @Path("/add-password-policy-organizations")
  Call<Response> addPasswordPolicyOrganizations(@Param(name = "passwordPolicyId") long passwordPolicyId, @Param(name = "organizationIds") JSONArray organizationIds);

  @Path("/delete-logo")
  Call<Response> deleteLogo(@Param(name = "organizationId") long organizationId);

  @Path("/delete-organization")
  Call<Response> deleteOrganization(@Param(name = "organizationId") long organizationId);

  @Path("/fetch-organization")
  Call<JSONObject> fetchOrganization(@Param(name = "organizationId") long organizationId);

  @Path("/get-organization")
  Call<JSONObject> getOrganization(@Param(name = "organizationId") long organizationId);

  @Path("/get-organization-id")
  Call<Long> getOrganizationId(@Param(name = "companyId") long companyId, @Param(name = "name") String name);

  @Path("/get-organizations")
  Call<JSONArray> getOrganizations(@Param(name = "companyId") long companyId, @Param(name = "parentOrganizationId") long parentOrganizationId, @Param(name = "start") int start, @Param(name = "end") int end);

  @Path("/get-organizations")
  Call<JSONArray> getOrganizations(@Param(name = "companyId") long companyId, @Param(name = "parentOrganizationId") long parentOrganizationId);

  @Path("/get-organizations-count")
  Call<Integer> getOrganizationsCount(@Param(name = "companyId") long companyId, @Param(name = "parentOrganizationId") long parentOrganizationId);

  @Path("/get-user-organizations")
  Call<JSONArray> getUserOrganizations(@Param(name = "userId") long userId);

  @Path("/set-group-organizations")
  Call<Response> setGroupOrganizations(@Param(name = "groupId") long groupId, @Param(name = "organizationIds") JSONArray organizationIds);

  @Path("/unset-group-organizations")
  Call<Response> unsetGroupOrganizations(@Param(name = "groupId") long groupId, @Param(name = "organizationIds") JSONArray organizationIds);

  @Path("/unset-password-policy-organizations")
  Call<Response> unsetPasswordPolicyOrganizations(@Param(name = "passwordPolicyId") long passwordPolicyId, @Param(name = "organizationIds") JSONArray organizationIds);

  @Path("/update-organization")
  Call<JSONObject> updateOrganization(@Param(name = "organizationId") long organizationId, @Param(name = "parentOrganizationId") long parentOrganizationId, @Param(name = "name") String name, @Param(name = "type") String type, @Param(name = "regionId") long regionId, @Param(name = "countryId") long countryId, @Param(name = "statusId") long statusId, @Param(name = "comments") String comments, @Param(name = "logo") boolean logo, @Param(name = "logoBytes") byte[] logoBytes, @Param(name = "site") boolean site, @Param(name = "addresses") JSONArray addresses, @Param(name = "emailAddresses") JSONArray emailAddresses, @Param(name = "orgLabors") JSONArray orgLabors, @Param(name = "phones") JSONArray phones, @Param(name = "websites") JSONArray websites, @Param(name = "serviceContext", className = "") JSONObject serviceContext);

  @Path("/update-organization")
  Call<JSONObject> updateOrganization(@Param(name = "organizationId") long organizationId, @Param(name = "parentOrganizationId") long parentOrganizationId, @Param(name = "name") String name, @Param(name = "type") String type, @Param(name = "regionId") long regionId, @Param(name = "countryId") long countryId, @Param(name = "statusId") long statusId, @Param(name = "comments") String comments, @Param(name = "site") boolean site, @Param(name = "addresses") JSONArray addresses, @Param(name = "emailAddresses") JSONArray emailAddresses, @Param(name = "orgLabors") JSONArray orgLabors, @Param(name = "phones") JSONArray phones, @Param(name = "websites") JSONArray websites, @Param(name = "serviceContext", className = "") JSONObject serviceContext);

  @Path("/update-organization")
  Call<JSONObject> updateOrganization(@Param(name = "organizationId") long organizationId, @Param(name = "parentOrganizationId") long parentOrganizationId, @Param(name = "name") String name, @Param(name = "type") String type, @Param(name = "regionId") long regionId, @Param(name = "countryId") long countryId, @Param(name = "statusId") long statusId, @Param(name = "comments") String comments, @Param(name = "site") boolean site, @Param(name = "serviceContext", className = "") JSONObject serviceContext);
}
