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

#import "LRDDLRecordVersionService_v7.h"

/**
 * @author Bruno Farache
 */
@implementation LRDDLRecordVersionService_v7

- (NSDictionary *)getRecordVersionWithRecordVersionId:(long long)recordVersionId error:(NSError **)error {
	NSMutableDictionary *_params = [NSMutableDictionary dictionaryWithDictionary:@{
		@"recordVersionId": @(recordVersionId)
	}];

	NSDictionary *_command = @{@"/ddl.ddlrecordversion/get-record-version": _params};

	return (NSDictionary *)[self.session invoke:_command error:error];
}

- (NSDictionary *)getRecordVersionWithRecordId:(long long)recordId version:(NSString *)version error:(NSError **)error {
	NSMutableDictionary *_params = [NSMutableDictionary dictionaryWithDictionary:@{
		@"recordId": @(recordId),
		@"version": [self checkNull: version]
	}];

	NSDictionary *_command = @{@"/ddl.ddlrecordversion/get-record-version": _params};

	return (NSDictionary *)[self.session invoke:_command error:error];
}

- (NSArray *)getRecordVersionsWithRecordId:(long long)recordId error:(NSError **)error {
	NSMutableDictionary *_params = [NSMutableDictionary dictionaryWithDictionary:@{
		@"recordId": @(recordId)
	}];

	NSDictionary *_command = @{@"/ddl.ddlrecordversion/get-record-versions": _params};

	return (NSArray *)[self.session invoke:_command error:error];
}

- (NSArray *)getRecordVersionsWithRecordId:(long long)recordId start:(int)start end:(int)end orderByComparator:(NSDictionary *)orderByComparator error:(NSError **)error {
	NSMutableDictionary *_params = [NSMutableDictionary dictionaryWithDictionary:@{
		@"recordId": @(recordId),
		@"start": @(start),
		@"end": @(end),
		@"orderByComparator": [self checkNull: orderByComparator]
	}];

	NSDictionary *_command = @{@"/ddl.ddlrecordversion/get-record-versions": _params};

	return (NSArray *)[self.session invoke:_command error:error];
}

- (NSNumber *)getRecordVersionsCountWithRecordId:(long long)recordId error:(NSError **)error {
	NSMutableDictionary *_params = [NSMutableDictionary dictionaryWithDictionary:@{
		@"recordId": @(recordId)
	}];

	NSDictionary *_command = @{@"/ddl.ddlrecordversion/get-record-versions-count": _params};

	return (NSNumber *)[self.session invoke:_command error:error];
}

@end