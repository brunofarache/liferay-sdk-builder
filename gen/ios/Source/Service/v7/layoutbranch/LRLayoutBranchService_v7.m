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

#import "LRLayoutBranchService_v7.h"

/**
 * @author Bruno Farache
 */
@implementation LRLayoutBranchService_v7

- (NSDictionary *)addLayoutBranchWithLayoutRevisionId:(long long)layoutRevisionId name:(NSString *)name description:(NSString *)description master:(BOOL)master serviceContext:(NSDictionary *)serviceContext error:(NSError **)error {
	NSMutableDictionary *_params = [NSMutableDictionary dictionaryWithDictionary:@{
		@"layoutRevisionId": @(layoutRevisionId),
		@"name": [self checkNull: name],
		@"description": [self checkNull: description],
		@"master": @(master),
		@"serviceContext": [self checkNull: serviceContext]
	}];

	NSDictionary *_command = @{@"/layoutbranch/add-layout-branch": _params};

	return (NSDictionary *)[self.session invoke:_command error:error];
}

- (NSDictionary *)updateLayoutBranchWithLayoutBranchId:(long long)layoutBranchId name:(NSString *)name description:(NSString *)description serviceContext:(NSDictionary *)serviceContext error:(NSError **)error {
	NSMutableDictionary *_params = [NSMutableDictionary dictionaryWithDictionary:@{
		@"layoutBranchId": @(layoutBranchId),
		@"name": [self checkNull: name],
		@"description": [self checkNull: description],
		@"serviceContext": [self checkNull: serviceContext]
	}];

	NSDictionary *_command = @{@"/layoutbranch/update-layout-branch": _params};

	return (NSDictionary *)[self.session invoke:_command error:error];
}

- (void)deleteLayoutBranchWithLayoutBranchId:(long long)layoutBranchId error:(NSError **)error {
	NSMutableDictionary *_params = [NSMutableDictionary dictionaryWithDictionary:@{
		@"layoutBranchId": @(layoutBranchId)
	}];

	NSDictionary *_command = @{@"/layoutbranch/delete-layout-branch": _params};

	[self.session invoke:_command error:error];
}

@end