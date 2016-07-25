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

#import "LRDDMDataProviderInstanceService_v7.h"

/**
 * @author Bruno Farache
 */
@implementation LRDDMDataProviderInstanceService_v7

- (NSDictionary *)addDataProviderInstanceWithGroupId:(long long)groupId nameMap:(NSDictionary *)nameMap descriptionMap:(NSDictionary *)descriptionMap ddmFormValues:(NSDictionary *)ddmFormValues type:(NSString *)type serviceContext:(NSDictionary *)serviceContext error:(NSError **)error {
	NSMutableDictionary *_params = [NSMutableDictionary dictionaryWithDictionary:@{
		@"groupId": @(groupId),
		@"nameMap": [self checkNull: nameMap],
		@"descriptionMap": [self checkNull: descriptionMap],
		@"ddmFormValues": [self checkNull: ddmFormValues],
		@"type": [self checkNull: type],
		@"serviceContext": [self checkNull: serviceContext]
	}];

	NSDictionary *_command = @{@"/ddm.ddmdataproviderinstance/add-data-provider-instance": _params};

	return (NSDictionary *)[self.session invoke:_command error:error];
}

- (void)deleteDataProviderInstanceWithDataProviderInstanceId:(long long)dataProviderInstanceId error:(NSError **)error {
	NSMutableDictionary *_params = [NSMutableDictionary dictionaryWithDictionary:@{
		@"dataProviderInstanceId": @(dataProviderInstanceId)
	}];

	NSDictionary *_command = @{@"/ddm.ddmdataproviderinstance/delete-data-provider-instance": _params};

	[self.session invoke:_command error:error];
}

- (NSDictionary *)fetchDataProviderInstanceWithDataProviderInstanceId:(long long)dataProviderInstanceId error:(NSError **)error {
	NSMutableDictionary *_params = [NSMutableDictionary dictionaryWithDictionary:@{
		@"dataProviderInstanceId": @(dataProviderInstanceId)
	}];

	NSDictionary *_command = @{@"/ddm.ddmdataproviderinstance/fetch-data-provider-instance": _params};

	return (NSDictionary *)[self.session invoke:_command error:error];
}

- (NSDictionary *)getDataProviderInstanceWithDataProviderInstanceId:(long long)dataProviderInstanceId error:(NSError **)error {
	NSMutableDictionary *_params = [NSMutableDictionary dictionaryWithDictionary:@{
		@"dataProviderInstanceId": @(dataProviderInstanceId)
	}];

	NSDictionary *_command = @{@"/ddm.ddmdataproviderinstance/get-data-provider-instance": _params};

	return (NSDictionary *)[self.session invoke:_command error:error];
}

- (NSArray *)searchWithCompanyId:(long long)companyId groupIds:(NSArray *)groupIds keywords:(NSString *)keywords start:(int)start end:(int)end orderByComparator:(NSDictionary *)orderByComparator error:(NSError **)error {
	NSMutableDictionary *_params = [NSMutableDictionary dictionaryWithDictionary:@{
		@"companyId": @(companyId),
		@"groupIds": [self checkNull: groupIds],
		@"keywords": [self checkNull: keywords],
		@"start": @(start),
		@"end": @(end),
		@"orderByComparator": [self checkNull: orderByComparator]
	}];

	NSDictionary *_command = @{@"/ddm.ddmdataproviderinstance/search": _params};

	return (NSArray *)[self.session invoke:_command error:error];
}

- (NSArray *)searchWithCompanyId:(long long)companyId groupIds:(NSArray *)groupIds name:(NSString *)name description:(NSString *)description andOperator:(BOOL)andOperator start:(int)start end:(int)end orderByComparator:(NSDictionary *)orderByComparator error:(NSError **)error {
	NSMutableDictionary *_params = [NSMutableDictionary dictionaryWithDictionary:@{
		@"companyId": @(companyId),
		@"groupIds": [self checkNull: groupIds],
		@"name": [self checkNull: name],
		@"description": [self checkNull: description],
		@"andOperator": @(andOperator),
		@"start": @(start),
		@"end": @(end),
		@"orderByComparator": [self checkNull: orderByComparator]
	}];

	NSDictionary *_command = @{@"/ddm.ddmdataproviderinstance/search": _params};

	return (NSArray *)[self.session invoke:_command error:error];
}

- (NSNumber *)searchCountWithCompanyId:(long long)companyId groupIds:(NSArray *)groupIds keywords:(NSString *)keywords error:(NSError **)error {
	NSMutableDictionary *_params = [NSMutableDictionary dictionaryWithDictionary:@{
		@"companyId": @(companyId),
		@"groupIds": [self checkNull: groupIds],
		@"keywords": [self checkNull: keywords]
	}];

	NSDictionary *_command = @{@"/ddm.ddmdataproviderinstance/search-count": _params};

	return (NSNumber *)[self.session invoke:_command error:error];
}

- (NSNumber *)searchCountWithCompanyId:(long long)companyId groupIds:(NSArray *)groupIds name:(NSString *)name description:(NSString *)description andOperator:(BOOL)andOperator error:(NSError **)error {
	NSMutableDictionary *_params = [NSMutableDictionary dictionaryWithDictionary:@{
		@"companyId": @(companyId),
		@"groupIds": [self checkNull: groupIds],
		@"name": [self checkNull: name],
		@"description": [self checkNull: description],
		@"andOperator": @(andOperator)
	}];

	NSDictionary *_command = @{@"/ddm.ddmdataproviderinstance/search-count": _params};

	return (NSNumber *)[self.session invoke:_command error:error];
}

- (NSDictionary *)updateDataProviderInstanceWithDataProviderInstanceId:(long long)dataProviderInstanceId nameMap:(NSDictionary *)nameMap descriptionMap:(NSDictionary *)descriptionMap ddmFormValues:(NSDictionary *)ddmFormValues serviceContext:(NSDictionary *)serviceContext error:(NSError **)error {
	NSMutableDictionary *_params = [NSMutableDictionary dictionaryWithDictionary:@{
		@"dataProviderInstanceId": @(dataProviderInstanceId),
		@"nameMap": [self checkNull: nameMap],
		@"descriptionMap": [self checkNull: descriptionMap],
		@"ddmFormValues": [self checkNull: ddmFormValues],
		@"serviceContext": [self checkNull: serviceContext]
	}];

	NSDictionary *_command = @{@"/ddm.ddmdataproviderinstance/update-data-provider-instance": _params};

	return (NSDictionary *)[self.session invoke:_command error:error];
}

@end