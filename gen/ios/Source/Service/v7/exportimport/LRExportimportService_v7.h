/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

#import "LRBaseService.h"

/**
 * @author Bruno Farache
 */
@interface LRExportimportService_v7 : LRBaseService

- (NSDictionary *)exportLayoutsAsFileWithExportImportConfiguration:(NSDictionary *)exportImportConfiguration error:(NSError **)error;
- (NSNumber *)exportLayoutsAsFileInBackgroundWithExportImportConfigurationId:(long long)exportImportConfigurationId error:(NSError **)error;
- (NSNumber *)exportLayoutsAsFileInBackgroundWithExportImportConfiguration:(NSDictionary *)exportImportConfiguration error:(NSError **)error;
- (NSNumber *)exportPortletInfoAsFileInBackgroundWithExportImportConfiguration:(NSDictionary *)exportImportConfiguration error:(NSError **)error;
- (NSNumber *)importLayoutsInBackgroundWithExportImportConfiguration:(NSDictionary *)exportImportConfiguration file:(NSDictionary *)file error:(NSError **)error;
- (void)importPortletInfoWithExportImportConfiguration:(NSDictionary *)exportImportConfiguration file:(NSDictionary *)file error:(NSError **)error;
- (NSNumber *)importPortletInfoInBackgroundWithExportImportConfiguration:(NSDictionary *)exportImportConfiguration file:(NSDictionary *)file error:(NSError **)error;
- (NSDictionary *)validateImportLayoutsFileWithExportImportConfiguration:(NSDictionary *)exportImportConfiguration file:(NSDictionary *)file error:(NSError **)error;
- (NSDictionary *)validateImportPortletInfoWithExportImportConfiguration:(NSDictionary *)exportImportConfiguration file:(NSDictionary *)file error:(NSError **)error;
- (NSDictionary *)exportPortletInfoAsFileWithExportImportConfiguration:(NSDictionary *)exportImportConfiguration error:(NSError **)error;
- (void)importLayoutsWithExportImportConfiguration:(NSDictionary *)exportImportConfiguration file:(NSDictionary *)file error:(NSError **)error;

@end