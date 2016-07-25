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

#import "LRUserThreadService_v7.h"

/**
 * @author Bruno Farache
 */
@implementation LRUserThreadService_v7

- (NSDictionary *)getLastThreadMessageWithMbThreadId:(long long)mbThreadId error:(NSError **)error {
	NSMutableDictionary *_params = [NSMutableDictionary dictionaryWithDictionary:@{
		@"mbThreadId": @(mbThreadId)
	}];

	NSDictionary *_command = @{@"/pm.userthread/get-last-thread-message": _params};

	return (NSDictionary *)[self.session invoke:_command error:error];
}

- (NSArray *)getThreadMessagesWithMbThreadId:(long long)mbThreadId start:(int)start end:(int)end ascending:(BOOL)ascending error:(NSError **)error {
	NSMutableDictionary *_params = [NSMutableDictionary dictionaryWithDictionary:@{
		@"mbThreadId": @(mbThreadId),
		@"start": @(start),
		@"end": @(end),
		@"ascending": @(ascending)
	}];

	NSDictionary *_command = @{@"/pm.userthread/get-thread-messages": _params};

	return (NSArray *)[self.session invoke:_command error:error];
}

- (NSNumber *)getThreadMessagesCountWithMbThreadId:(long long)mbThreadId error:(NSError **)error {
	NSMutableDictionary *_params = [NSMutableDictionary dictionaryWithDictionary:@{
		@"mbThreadId": @(mbThreadId)
	}];

	NSDictionary *_command = @{@"/pm.userthread/get-thread-messages-count": _params};

	return (NSNumber *)[self.session invoke:_command error:error];
}

- (NSArray *)getUserUserThreadsWithDeleted:(BOOL)deleted error:(NSError **)error {
	NSMutableDictionary *_params = [NSMutableDictionary dictionaryWithDictionary:@{
		@"deleted": @(deleted)
	}];

	NSDictionary *_command = @{@"/pm.userthread/get-user-user-threads": _params};

	return (NSArray *)[self.session invoke:_command error:error];
}

@end