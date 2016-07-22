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

#import "LRMBBanService_v7.h"

/**
 * @author Bruno Farache
 */
@implementation LRMBBanService_v7

- (void)deleteBanWithBanUserId:(long long)banUserId serviceContext:(NSDictionary *)serviceContext error:(NSError **)error {
	NSMutableDictionary *_params = [NSMutableDictionary dictionaryWithDictionary:@{
		@"banUserId": @(banUserId),
		@"serviceContext": [self checkNull: serviceContext]
	}];

	NSDictionary *_command = @{@"/mbban/delete-ban": _params};

	[self.session invoke:_command error:error];
}

- (NSDictionary *)addBanWithBanUserId:(long long)banUserId serviceContext:(NSDictionary *)serviceContext error:(NSError **)error {
	NSMutableDictionary *_params = [NSMutableDictionary dictionaryWithDictionary:@{
		@"banUserId": @(banUserId),
		@"serviceContext": [self checkNull: serviceContext]
	}];

	NSDictionary *_command = @{@"/mbban/add-ban": _params};

	return (NSDictionary *)[self.session invoke:_command error:error];
}

@end