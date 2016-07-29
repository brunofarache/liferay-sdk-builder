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

#import "LRCalendarNotificationTemplateService_v7.h"

/**
 * @author Bruno Farache
 */
@implementation LRCalendarNotificationTemplateService_v7

- (NSDictionary *)addCalendarNotificationTemplateWithCalendarId:(long long)calendarId notificationType:(NSDictionary *)notificationType notificationTypeSettings:(NSString *)notificationTypeSettings notificationTemplateType:(NSDictionary *)notificationTemplateType subject:(NSString *)subject body:(NSString *)body serviceContext:(NSDictionary *)serviceContext error:(NSError **)error {
	NSMutableDictionary *_params = [NSMutableDictionary dictionaryWithDictionary:@{
		@"calendarId": @(calendarId),
		@"notificationType": [self checkNull: notificationType],
		@"notificationTypeSettings": [self checkNull: notificationTypeSettings],
		@"notificationTemplateType": [self checkNull: notificationTemplateType],
		@"subject": [self checkNull: subject],
		@"body": [self checkNull: body],
		@"serviceContext": [self checkNull: serviceContext]
	}];

	NSDictionary *_command = @{@"/calendar.calendarnotificationtemplate/add-calendar-notification-template": _params};

	return (NSDictionary *)[self.session invoke:_command error:error];
}

- (NSDictionary *)updateCalendarNotificationTemplateWithCalendarNotificationTemplateId:(long long)calendarNotificationTemplateId notificationTypeSettings:(NSString *)notificationTypeSettings subject:(NSString *)subject body:(NSString *)body serviceContext:(NSDictionary *)serviceContext error:(NSError **)error {
	NSMutableDictionary *_params = [NSMutableDictionary dictionaryWithDictionary:@{
		@"calendarNotificationTemplateId": @(calendarNotificationTemplateId),
		@"notificationTypeSettings": [self checkNull: notificationTypeSettings],
		@"subject": [self checkNull: subject],
		@"body": [self checkNull: body],
		@"serviceContext": [self checkNull: serviceContext]
	}];

	NSDictionary *_command = @{@"/calendar.calendarnotificationtemplate/update-calendar-notification-template": _params};

	return (NSDictionary *)[self.session invoke:_command error:error];
}

@end