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
@interface LRUserThreadService_v7 : LRBaseService

- (NSDictionary *)getLastThreadMessageWithMbThreadId:(long long)mbThreadId error:(NSError **)error;
- (NSArray *)getThreadMessagesWithMbThreadId:(long long)mbThreadId start:(int)start end:(int)end ascending:(BOOL)ascending error:(NSError **)error;
- (NSNumber *)getThreadMessagesCountWithMbThreadId:(long long)mbThreadId error:(NSError **)error;
- (NSArray *)getUserUserThreadsWithDeleted:(BOOL)deleted error:(NSError **)error;

@end