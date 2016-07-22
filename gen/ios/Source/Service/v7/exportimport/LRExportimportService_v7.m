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

#import "LRExportImportService_v7.h"

/**
 * @author Bruno Farache
 */
@implementation LRExportImportService_v7

- (NSDictionary *)exportLayoutsAsFileWithExportImportConfiguration:(NSDictionary *)exportImportConfiguration error:(NSError **)error {
	NSMutableDictionary *_params = [NSMutableDictionary dictionaryWithDictionary:@{
		@"exportImportConfiguration": [self checkNull: exportImportConfiguration]
	}];

	NSDictionary *_command = @{@"/exportimport/export-layouts-as-file": _params};

	return (NSDictionary *)[self.session invoke:_command error:error];
}

- (NSNumber *)exportLayoutsAsFileInBackgroundWithExportImportConfigurationId:(long long)exportImportConfigurationId error:(NSError **)error {
	NSMutableDictionary *_params = [NSMutableDictionary dictionaryWithDictionary:@{
		@"exportImportConfigurationId": @(exportImportConfigurationId)
	}];

	NSDictionary *_command = @{@"/exportimport/export-layouts-as-file-in-background": _params};

	return (NSNumber *)[self.session invoke:_command error:error];
}

- (NSNumber *)exportLayoutsAsFileInBackgroundWithExportImportConfiguration:(NSDictionary *)exportImportConfiguration error:(NSError **)error {
	NSMutableDictionary *_params = [NSMutableDictionary dictionaryWithDictionary:@{
		@"exportImportConfiguration": [self checkNull: exportImportConfiguration]
	}];

	NSDictionary *_command = @{@"/exportimport/export-layouts-as-file-in-background": _params};

	return (NSNumber *)[self.session invoke:_command error:error];
}

- (NSNumber *)exportPortletInfoAsFileInBackgroundWithExportImportConfiguration:(NSDictionary *)exportImportConfiguration error:(NSError **)error {
	NSMutableDictionary *_params = [NSMutableDictionary dictionaryWithDictionary:@{
		@"exportImportConfiguration": [self checkNull: exportImportConfiguration]
	}];

	NSDictionary *_command = @{@"/exportimport/export-portlet-info-as-file-in-background": _params};

	return (NSNumber *)[self.session invoke:_command error:error];
}

- (NSNumber *)importLayoutsInBackgroundWithExportImportConfiguration:(NSDictionary *)exportImportConfiguration file:(NSDictionary *)file error:(NSError **)error {
	NSMutableDictionary *_params = [NSMutableDictionary dictionaryWithDictionary:@{
		@"exportImportConfiguration": [self checkNull: exportImportConfiguration],
		@"file": [self checkNull: file]
	}];

	NSDictionary *_command = @{@"/exportimport/import-layouts-in-background": _params};

	return (NSNumber *)[self.session invoke:_command error:error];
}

- (void)importPortletInfoWithExportImportConfiguration:(NSDictionary *)exportImportConfiguration file:(NSDictionary *)file error:(NSError **)error {
	NSMutableDictionary *_params = [NSMutableDictionary dictionaryWithDictionary:@{
		@"exportImportConfiguration": [self checkNull: exportImportConfiguration],
		@"file": [self checkNull: file]
	}];

	NSDictionary *_command = @{@"/exportimport/import-portlet-info": _params};

	[self.session invoke:_command error:error];
}

- (NSNumber *)importPortletInfoInBackgroundWithExportImportConfiguration:(NSDictionary *)exportImportConfiguration file:(NSDictionary *)file error:(NSError **)error {
	NSMutableDictionary *_params = [NSMutableDictionary dictionaryWithDictionary:@{
		@"exportImportConfiguration": [self checkNull: exportImportConfiguration],
		@"file": [self checkNull: file]
	}];

	NSDictionary *_command = @{@"/exportimport/import-portlet-info-in-background": _params};

	return (NSNumber *)[self.session invoke:_command error:error];
}

- (NSDictionary *)validateImportLayoutsFileWithExportImportConfiguration:(NSDictionary *)exportImportConfiguration file:(NSDictionary *)file error:(NSError **)error {
	NSMutableDictionary *_params = [NSMutableDictionary dictionaryWithDictionary:@{
		@"exportImportConfiguration": [self checkNull: exportImportConfiguration],
		@"file": [self checkNull: file]
	}];

	NSDictionary *_command = @{@"/exportimport/validate-import-layouts-file": _params};

	return (NSDictionary *)[self.session invoke:_command error:error];
}

- (NSDictionary *)validateImportPortletInfoWithExportImportConfiguration:(NSDictionary *)exportImportConfiguration file:(NSDictionary *)file error:(NSError **)error {
	NSMutableDictionary *_params = [NSMutableDictionary dictionaryWithDictionary:@{
		@"exportImportConfiguration": [self checkNull: exportImportConfiguration],
		@"file": [self checkNull: file]
	}];

	NSDictionary *_command = @{@"/exportimport/validate-import-portlet-info": _params};

	return (NSDictionary *)[self.session invoke:_command error:error];
}

- (NSDictionary *)exportPortletInfoAsFileWithExportImportConfiguration:(NSDictionary *)exportImportConfiguration error:(NSError **)error {
	NSMutableDictionary *_params = [NSMutableDictionary dictionaryWithDictionary:@{
		@"exportImportConfiguration": [self checkNull: exportImportConfiguration]
	}];

	NSDictionary *_command = @{@"/exportimport/export-portlet-info-as-file": _params};

	return (NSDictionary *)[self.session invoke:_command error:error];
}

- (void)importLayoutsWithExportImportConfiguration:(NSDictionary *)exportImportConfiguration file:(NSDictionary *)file error:(NSError **)error {
	NSMutableDictionary *_params = [NSMutableDictionary dictionaryWithDictionary:@{
		@"exportImportConfiguration": [self checkNull: exportImportConfiguration],
		@"file": [self checkNull: file]
	}];

	NSDictionary *_command = @{@"/exportimport/import-layouts": _params};

	[self.session invoke:_command error:error];
}

@end