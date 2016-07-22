package com.liferay.mobile.sdk.v7.passwordpolicy;

import com.liferay.mobile.sdk.Call;
import com.liferay.mobile.sdk.annotation.Param;
import com.liferay.mobile.sdk.annotation.Path;
import com.liferay.mobile.sdk.http.Response;
import java.lang.String;
import org.json.JSONObject;

@Path("/passwordpolicy")
public interface PasswordPolicyService {
  @Path("/add-password-policy")
  Call<JSONObject> addPasswordPolicy(@Param(name = "name") String name, @Param(name = "description") String description, @Param(name = "changeable") boolean changeable, @Param(name = "changeRequired") boolean changeRequired, @Param(name = "minAge") long minAge, @Param(name = "checkSyntax") boolean checkSyntax, @Param(name = "allowDictionaryWords") boolean allowDictionaryWords, @Param(name = "minAlphanumeric") int minAlphanumeric, @Param(name = "minLength") int minLength, @Param(name = "minLowerCase") int minLowerCase, @Param(name = "minNumbers") int minNumbers, @Param(name = "minSymbols") int minSymbols, @Param(name = "minUpperCase") int minUpperCase, @Param(name = "regex") String regex, @Param(name = "history") boolean history, @Param(name = "historyCount") int historyCount, @Param(name = "expireable") boolean expireable, @Param(name = "maxAge") long maxAge, @Param(name = "warningTime") long warningTime, @Param(name = "graceLimit") int graceLimit, @Param(name = "lockout") boolean lockout, @Param(name = "maxFailure") int maxFailure, @Param(name = "lockoutDuration") long lockoutDuration, @Param(name = "resetFailureCount") long resetFailureCount, @Param(name = "resetTicketMaxAge") long resetTicketMaxAge, @Param(name = "serviceContext", className = "") JSONObject serviceContext);

  @Path("/delete-password-policy")
  Call<Response> deletePasswordPolicy(@Param(name = "passwordPolicyId") long passwordPolicyId);

  @Path("/fetch-password-policy")
  Call<JSONObject> fetchPasswordPolicy(@Param(name = "passwordPolicyId") long passwordPolicyId);

  @Path("/update-password-policy")
  Call<JSONObject> updatePasswordPolicy(@Param(name = "passwordPolicyId") long passwordPolicyId, @Param(name = "name") String name, @Param(name = "description") String description, @Param(name = "changeable") boolean changeable, @Param(name = "changeRequired") boolean changeRequired, @Param(name = "minAge") long minAge, @Param(name = "checkSyntax") boolean checkSyntax, @Param(name = "allowDictionaryWords") boolean allowDictionaryWords, @Param(name = "minAlphanumeric") int minAlphanumeric, @Param(name = "minLength") int minLength, @Param(name = "minLowerCase") int minLowerCase, @Param(name = "minNumbers") int minNumbers, @Param(name = "minSymbols") int minSymbols, @Param(name = "minUpperCase") int minUpperCase, @Param(name = "regex") String regex, @Param(name = "history") boolean history, @Param(name = "historyCount") int historyCount, @Param(name = "expireable") boolean expireable, @Param(name = "maxAge") long maxAge, @Param(name = "warningTime") long warningTime, @Param(name = "graceLimit") int graceLimit, @Param(name = "lockout") boolean lockout, @Param(name = "maxFailure") int maxFailure, @Param(name = "lockoutDuration") long lockoutDuration, @Param(name = "resetFailureCount") long resetFailureCount, @Param(name = "resetTicketMaxAge") long resetTicketMaxAge, @Param(name = "serviceContext", className = "") JSONObject serviceContext);
}
