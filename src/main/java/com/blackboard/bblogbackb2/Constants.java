package com.blackboard.bblogbackb2;
/* Copyright (C) 2016, Blackboard Inc.
 * All rights reserved.
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *
 *  -- Redistributions of source code must retain the above copyright
 *     notice, this list of conditions and the following disclaimer.
 *
 *  -- Redistributions in binary form must reproduce the above copyright
 *     notice, this list of conditions and the following disclaimer in the
 *     documentation and/or other materials provided with the distribution.
 *
 *  -- Neither the name of Blackboard Inc. nor the names of its contributors 
 *     may be used to endorse or promote products derived from this 
 *     software without specific prior written permission.
 *  
 * THIS SOFTWARE IS PROVIDED BY BLACKBOARD INC ``AS IS'' AND ANY
 * EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED
 * WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 * DISCLAIMED. IN NO EVENT SHALL BLACKBOARD INC. BE LIABLE FOR ANY
 * DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES
 * (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES;
 * LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND
 * ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */

public abstract interface Constants
{
  public static final String VENDOR_ID = "bbdn";
  public static final String HANDLE_VALUE = "bblogbackb2";
  public static final String LOG_LEVEL_OFF = "OFF";
  public static final String LOG_LEVEL_FATAL = "FATAL";
  public static final String LOG_LEVEL_ERROR = "ERROR";
  public static final String LOG_LEVEL_WARN = "WARN";
  public static final String LOG_LEVEL_INFO = "INFO";
  public static final String LOG_LEVEL_DEBUG = "DEBUG";
  public static final String LOG_LEVEL_ALL = "ALL";
  public static final String BLACKBOARD_OPERATION_STATUS_SUCCESS = "success";
  public static final String BLACKBOARD_OPERATION_STATUS_FAILURE = "failure";
  public static final String BLACKBOARD_OPERATION_KEY_NOT_FOUND = "key not found";
  public static final String BLACKBOARD_OPERATION_UNKNOWN = "unknown exception";
  public static final String BLACKBOARD_OPERATION_ID_MISSING = "required field Id is missing";
  public static final String BLACKBOARD_OPERATION_PERSISTENCE_EXCEPTION = "persistence exception";
  public static final String BLACKBOARD_OPERATION_VALIDATION_EXCEPTION = "validation exception";
  public static final String NAUTILUS_VIEW_WHATSNEW = "nautilus.whatsnew.view.events";
  public static final String EMPTY_STRING = "";
  public static final String AUTHORIZATION = "authorization";
  public static final String USERNAME = "username";
  public static final String PASSWORD = "password";
  public static final String TODATE = "toDate";
  public static final String FROMDATE = "from Date";
  public static final String STATUS_ACTIVE = "Active";
  public static final String BB_USER_COURSE_ROLE_FACULTY = "faculty";
  public static final String BB_USER_COURSE_ROLE_STUDENT = "student";
  public static final String KEY_MAP_TYPE_COURSE_GROUP = "group";
  public static final String KEY_MAP_TYPE_MEMBERSHIP = "membership";
  public static final String TAB_TAB_GROUP_NAME_COURSES = "courses";
  public static final String INCORRECT_DATE_FORMAT = "Changes were not saved. Date format does not conform to the date format specified in ILP Integration configuration.";
  public static final String DATE_FORMAT_DEFAULT = "MM/dd/yyyy";
  public static final String INCORRECT_DATE_FORMAT_LDA = "The entered date is invalid. Valid format:";
  public static final String INCORRECT_DATE_FORMAT_ED = "The entered date is invalid. Valid format:";
  public static final String INCORRECT_LETTER_GRADE = "One or more grades are not valid for the grade scheme.";
  public static final String LDA_OR_NA = "Changes were not saved. You cannot enter last date of attendance and check never attended flag at the same time.";
  public static final String MSG_SUCCESS_MIDTERM_GRADES_SUBMITTED = "Grades submitted";
  public static final String MSG_SUCCESS_FINAL_GRADES_SUBMITTED = "Grades submitted";
  public static final String MSG_SUCCESS_LDA_SUBMITTED = "LDA or Never Attended flag has been submitted.";
  public static final String DISPLAY_CONFIG_IP_PAGE = "dcbbConfigIPDisplayList";
  public static final String CONFIG_IP_LIST = "dcbbConfigIPList";
  public static final String DCBB_CONFIG_IP_COMMAND_NAME = "dcbbConfigIP";
  public static final String DCBB_CONFIG_IP_FIELD_LIST = "fieldsList";
  public static final String DCBB_CONFIG_IP_TYPE_LIST = "typeList";
  public static final String DCBB_CONFIG_IP_USER_ID_TYPE_LIST = "userIdTypeList";
  public static final String DCBB_CONFIG_IP_DATEFORMAT_LIST = "dateFormatList";
  public static final String DCBB_CONFIG_IP_LOGLEVEL_LIST = "logLevelList";
  public static final String DCBB_CONFIG_IP_INTEGRATION_LIST = "integrationList";
  public static final String DCBB_CONFIG_IP_TERM_LIST = "termList";
  public static final String DCBB_CONFIG_IP_CATEGORY_GRADE_CUT_OFF_TERMS = "categoryGradeCutOffTerms";
  public static final String DCBB_CONFIG_IP_EXPIRE_LABEL_LIST = "expireLabelList";
  public static final String DCBB_CONFIG_MAIN_ACTION_URL = "ShowDcbbConfigIP.spring";
  public static final String DCBB_ACCESS_TOKEN = "34546f646179";
  public static final String INVALID_DATE_FORMAT = "Invalid Date Format";
  public static final String END_GREATER_THAN_BEGIN = "The Begin date comes after the end date";
  public static final String GRADEBOOK = "GB";
  public static final String TEST = "TE";
  public static final String ANNOUNCEMENT = "AN";
  public static final String COURSE = "CR";
  public static final String ASSIGNMENT = "AS";
  public static final String SURVEY = "SU";
  public static final String BLOG = "BL";
  public static final String DISCUSSION_FORUM = "DF";
  public static final String JOURNAL = "JN";
  public static final String DISCUSSION_FORUM_THREAD = "DT";
  public static final String PORTAL_LINK_NAME = "Back to Portal";
  public static final String GRADES_API_ENDPOINT = "api/coursesection/grades";
}
