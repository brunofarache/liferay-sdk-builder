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

#import "LRSAPEntryService_v7.h"

/**
 * @author Bruno Farache
 */
@implementation LRSAPEntryService_v7

- (NSDictionary *)addSAPEntryWithAllowedServiceSignatures:(NSString *)allowedServiceSignatures defaultSAPEntry:(BOOL)defaultSAPEntry enabled:(BOOL)enabled name:(NSString *)name titleMap:(NSDictionary *)titleMap serviceContext:(NSDictionary *)serviceContext error:(NSError **)error {
	NSMutableDictionary *_params = [NSMutableDictionary dictionaryWithDictionary:@{
		@"allowedServiceSignatures": [self checkNull: allowedServiceSignatures],
		@"defaultSAPEntry": @(defaultSAPEntry),
		@"enabled": @(enabled),
		@"name": [self checkNull: name],
		@"titleMap": [self checkNull: titleMap],
		@"serviceContext": [self checkNull: serviceContext]
	}];

	NSDictionary *_command = @{@"/sap.sapentry/add-sap-entry": _params};

	return (NSDictionary *)[self.session invoke:_command error:error];
}

- (NSDictionary *)deleteSAPEntryWithSapEntry:(NSDictionary *)sapEntry error:(NSError **)error {
	NSMutableDictionary *_params = [NSMutableDictionary dictionaryWithDictionary:@{
		@"sapEntry": [self checkNull: sapEntry]
	}];

	NSDictionary *_command = @{@"/sap.sapentry/delete-sap-entry": _params};

	return (NSDictionary *)[self.session invoke:_command error:error];
}

- (NSDictionary *)deleteSAPEntryWithSapEntryId:(long long)sapEntryId error:(NSError **)error {
	NSMutableDictionary *_params = [NSMutableDictionary dictionaryWithDictionary:@{
		@"sapEntryId": @(sapEntryId)
	}];

	NSDictionary *_command = @{@"/sap.sapentry/delete-sap-entry": _params};

	return (NSDictionary *)[self.session invoke:_command error:error];
}

- (NSDictionary *)fetchSAPEntryWithCompanyId:(long long)companyId name:(NSString *)name error:(NSError **)error {
	NSMutableDictionary *_params = [NSMutableDictionary dictionaryWithDictionary:@{
		@"companyId": @(companyId),
		@"name": [self checkNull: name]
	}];

	NSDictionary *_command = @{@"/sap.sapentry/fetch-sap-entry": _params};

	return (NSDictionary *)[self.session invoke:_command error:error];
}

- (NSArray *)getCompanySAPEntriesWithCompanyId:(long long)companyId start:(int)start end:(int)end error:(NSError **)error {
	NSMutableDictionary *_params = [NSMutableDictionary dictionaryWithDictionary:@{
		@"companyId": @(companyId),
		@"start": @(start),
		@"end": @(end)
	}];

	NSDictionary *_command = @{@"/sap.sapentry/get-company-sap-entries": _params};

	return (NSArray *)[self.session invoke:_command error:error];
}

- (NSArray *)getCompanySAPEntriesWithCompanyId:(long long)companyId start:(int)start end:(int)end obc:(NSDictionary *)obc error:(NSError **)error {
	NSMutableDictionary *_params = [NSMutableDictionary dictionaryWithDictionary:@{
		@"companyId": @(companyId),
		@"start": @(start),
		@"end": @(end),
		@"obc": [self checkNull: obc]
	}];

	NSDictionary *_command = @{@"/sap.sapentry/get-company-sap-entries": _params};

	return (NSArray *)[self.session invoke:_command error:error];
}

- (NSNumber *)getCompanySAPEntriesCountWithCompanyId:(long long)companyId error:(NSError **)error {
	NSMutableDictionary *_params = [NSMutableDictionary dictionaryWithDictionary:@{
		@"companyId": @(companyId)
	}];

	NSDictionary *_command = @{@"/sap.sapentry/get-company-sap-entries-count": _params};

	return (NSNumber *)[self.session invoke:_command error:error];
}

- (NSDictionary *)getSAPEntryWithSapEntryId:(long long)sapEntryId error:(NSError **)error {
	NSMutableDictionary *_params = [NSMutableDictionary dictionaryWithDictionary:@{
		@"sapEntryId": @(sapEntryId)
	}];

	NSDictionary *_command = @{@"/sap.sapentry/get-sap-entry": _params};

	return (NSDictionary *)[self.session invoke:_command error:error];
}

- (NSDictionary *)getSAPEntryWithCompanyId:(long long)companyId name:(NSString *)name error:(NSError **)error {
	NSMutableDictionary *_params = [NSMutableDictionary dictionaryWithDictionary:@{
		@"companyId": @(companyId),
		@"name": [self checkNull: name]
	}];

	NSDictionary *_command = @{@"/sap.sapentry/get-sap-entry": _params};

	return (NSDictionary *)[self.session invoke:_command error:error];
}

- (NSDictionary *)updateSAPEntryWithSapEntryId:(long long)sapEntryId allowedServiceSignatures:(NSString *)allowedServiceSignatures defaultSAPEntry:(BOOL)defaultSAPEntry enabled:(BOOL)enabled name:(NSString *)name titleMap:(NSDictionary *)titleMap serviceContext:(NSDictionary *)serviceContext error:(NSError **)error {
	NSMutableDictionary *_params = [NSMutableDictionary dictionaryWithDictionary:@{
		@"sapEntryId": @(sapEntryId),
		@"allowedServiceSignatures": [self checkNull: allowedServiceSignatures],
		@"defaultSAPEntry": @(defaultSAPEntry),
		@"enabled": @(enabled),
		@"name": [self checkNull: name],
		@"titleMap": [self checkNull: titleMap],
		@"serviceContext": [self checkNull: serviceContext]
	}];

	NSDictionary *_command = @{@"/sap.sapentry/update-sap-entry": _params};

	return (NSDictionary *)[self.session invoke:_command error:error];
}

@end