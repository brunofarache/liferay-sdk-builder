package com.liferay.mobile.sdk.v62.syncdlobject;

import com.liferay.mobile.sdk.Call;
import com.liferay.mobile.sdk.annotation.Param;
import com.liferay.mobile.sdk.annotation.Path;
import com.liferay.mobile.sdk.file.UploadData;
import com.liferay.mobile.sdk.http.ContentType;
import java.lang.Long;
import java.lang.String;
import org.json.JSONArray;
import org.json.JSONObject;

@Path("/sync-web.syncdlobject")
public interface SyncdlobjectService {
  @Path(
      value = "/add-file-entry",
      contentType = ContentType.MULTIPART
  )
  Call<JSONObject> addFileEntry(@Param(name = "repositoryId") long repositoryId, @Param(name = "folderId") long folderId, @Param(name = "sourceFileName") String sourceFileName, @Param(name = "mimeType") String mimeType, @Param(name = "title") String title, @Param(name = "description") String description, @Param(name = "changeLog") String changeLog, @Param(name = "file") UploadData file, @Param(name = "checksum") String checksum, @Param(name = "serviceContext", className = "com.liferay.portal.service.ServiceContext") JSONObject serviceContext);

  @Path("/add-folder")
  Call<JSONObject> addFolder(@Param(name = "repositoryId") long repositoryId, @Param(name = "parentFolderId") long parentFolderId, @Param(name = "name") String name, @Param(name = "description") String description, @Param(name = "serviceContext", className = "com.liferay.portal.service.ServiceContext") JSONObject serviceContext);

  @Path("/cancel-check-out")
  Call<JSONObject> cancelCheckOut(@Param(name = "fileEntryId") long fileEntryId);

  @Path("/check-in-file-entry")
  Call<JSONObject> checkInFileEntry(@Param(name = "fileEntryId") long fileEntryId, @Param(name = "majorVersion") boolean majorVersion, @Param(name = "changeLog") String changeLog, @Param(name = "serviceContext", className = "com.liferay.portal.service.ServiceContext") JSONObject serviceContext);

  @Path("/check-out-file-entry")
  Call<JSONObject> checkOutFileEntry(@Param(name = "fileEntryId") long fileEntryId, @Param(name = "serviceContext", className = "com.liferay.portal.service.ServiceContext") JSONObject serviceContext);

  @Path("/check-out-file-entry")
  Call<JSONObject> checkOutFileEntry(@Param(name = "fileEntryId") long fileEntryId, @Param(name = "owner") String owner, @Param(name = "expirationTime") long expirationTime, @Param(name = "serviceContext", className = "com.liferay.portal.service.ServiceContext") JSONObject serviceContext);

  @Path("/get-all-sync-dl-objects")
  Call<JSONObject> getAllSyncDlObjects(@Param(name = "repositoryId") long repositoryId, @Param(name = "folderId") long folderId);

  @Path("/get-file-entry-sync-dl-object")
  Call<JSONObject> getFileEntrySyncDlObject(@Param(name = "groupId") long groupId, @Param(name = "folderId") long folderId, @Param(name = "title") String title);

  @Path("/get-file-entry-sync-dl-objects")
  Call<JSONArray> getFileEntrySyncDlObjects(@Param(name = "repositoryId") long repositoryId, @Param(name = "folderId") long folderId);

  @Path("/get-folder-sync-dl-object")
  Call<JSONObject> getFolderSyncDlObject(@Param(name = "folderId") long folderId);

  @Path("/get-folder-sync-dl-objects")
  Call<JSONArray> getFolderSyncDlObjects(@Param(name = "repositoryId") long repositoryId, @Param(name = "parentFolderId") long parentFolderId);

  @Path("/get-group")
  Call<JSONObject> getGroup(@Param(name = "groupId") long groupId);

  @Path("/get-latest-modified-time")
  Call<Long> getLatestModifiedTime();

  @Path("/get-sync-context")
  Call<JSONObject> getSyncContext(@Param(name = "uuid") String uuid);

  @Path("/get-sync-dl-object-update")
  Call<JSONObject> getSyncDlObjectUpdate(@Param(name = "companyId") long companyId, @Param(name = "repositoryId") long repositoryId, @Param(name = "lastAccessTime") long lastAccessTime);

  @Path("/get-user-sites-groups")
  Call<JSONArray> getUserSitesGroups();

  @Path("/move-file-entry")
  Call<JSONObject> moveFileEntry(@Param(name = "fileEntryId") long fileEntryId, @Param(name = "newFolderId") long newFolderId, @Param(name = "serviceContext", className = "com.liferay.portal.service.ServiceContext") JSONObject serviceContext);

  @Path("/move-file-entry-to-trash")
  Call<JSONObject> moveFileEntryToTrash(@Param(name = "fileEntryId") long fileEntryId);

  @Path("/move-folder")
  Call<JSONObject> moveFolder(@Param(name = "folderId") long folderId, @Param(name = "parentFolderId") long parentFolderId, @Param(name = "serviceContext", className = "com.liferay.portal.service.ServiceContext") JSONObject serviceContext);

  @Path("/move-folder-to-trash")
  Call<JSONObject> moveFolderToTrash(@Param(name = "folderId") long folderId);

  @Path(
      value = "/patch-file-entry",
      contentType = ContentType.MULTIPART
  )
  Call<JSONObject> patchFileEntry(@Param(name = "fileEntryId") long fileEntryId, @Param(name = "sourceVersion") String sourceVersion, @Param(name = "sourceFileName") String sourceFileName, @Param(name = "mimeType") String mimeType, @Param(name = "title") String title, @Param(name = "description") String description, @Param(name = "changeLog") String changeLog, @Param(name = "majorVersion") boolean majorVersion, @Param(name = "deltaFile") UploadData deltaFile, @Param(name = "checksum") String checksum, @Param(name = "serviceContext", className = "com.liferay.portal.service.ServiceContext") JSONObject serviceContext);

  @Path("/restore-file-entry-from-trash")
  Call<JSONObject> restoreFileEntryFromTrash(@Param(name = "fileEntryId") long fileEntryId);

  @Path("/restore-folder-from-trash")
  Call<JSONObject> restoreFolderFromTrash(@Param(name = "folderId") long folderId);

  @Path(
      value = "/update-file-entry",
      contentType = ContentType.MULTIPART
  )
  Call<JSONObject> updateFileEntry(@Param(name = "fileEntryId") long fileEntryId, @Param(name = "sourceFileName") String sourceFileName, @Param(name = "mimeType") String mimeType, @Param(name = "title") String title, @Param(name = "description") String description, @Param(name = "changeLog") String changeLog, @Param(name = "majorVersion") boolean majorVersion, @Param(name = "file") UploadData file, @Param(name = "checksum") String checksum, @Param(name = "serviceContext", className = "com.liferay.portal.service.ServiceContext") JSONObject serviceContext);

  @Path("/update-folder")
  Call<JSONObject> updateFolder(@Param(name = "folderId") long folderId, @Param(name = "name") String name, @Param(name = "description") String description, @Param(name = "serviceContext", className = "com.liferay.portal.service.ServiceContext") JSONObject serviceContext);
}
