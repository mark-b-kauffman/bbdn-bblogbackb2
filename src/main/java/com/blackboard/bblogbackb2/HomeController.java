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

import java.util.Properties;
import blackboard.data.course.Course;
import blackboard.persist.course.*;
import blackboard.data.user.User;
import blackboard.persist.*;
import blackboard.persist.Id;
import blackboard.platform.config.*;
import blackboard.platform.context.Context;
import blackboard.platform.context.ContextManagerFactory;


import blackboard.platform.plugin.PlugInUtil;

// WARNING: GeneralUtil is an unpublished Class.
// Blackboard in no way recommends or supports it's use for any purpose.
// Use at your own risk. It may change at any time.
// You are responsible for monitorin the package it ships with and
// making changes to your code as necessary. Blackboard is under no
// obligation to inform you if or when the class changes.
import blackboard.util.GeneralUtil;

 import ch.qos.logback.classic.LoggerContext;
 import ch.qos.logback.core.util.StatusPrinter;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Map;

// import java.security.Security;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {

	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome to /! The client locale is {}.", locale);
		logger.error("There was NOT an error. This is a test message.");
		System.out.println("springmvcb2 - Is this visible in Kibana? I didn't intentionally log it in the correct format.");

//		Security.addProvider(new com.sun.net.ssl.internal.ssl.Provider());

		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);

		String formattedDate = dateFormat.format(date);
		String uriStem = PlugInUtil.getUriStem("bbdn", "bblogbackb2");

    model.addAttribute("serverTime", formattedDate );
		model.addAttribute("uriStem", uriStem);

		return "home";
	}

	@RequestMapping(value = "/learnhello", method = RequestMethod.GET)
	public String learnhello(Locale locale, Model model) {
		logger.info("Welcome to /learnhello! The client locale is {}.", locale);
		// print internal Logback state
		LoggerContext lc = (LoggerContext) LoggerFactory.getILoggerFactory();
		StatusPrinter.print(lc);

		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);

		String formattedDate = dateFormat.format(date);
    Context ctx = ContextManagerFactory.getInstance().getContext();

    Id userId = ctx.getUserId();
    // User is an object.  The User has a userName which Chico calls the portal ID.
    User user = ctx.getUser();
    String userBatchUid = user.getBatchUid();
    String userName = user.getUserName();
    model.addAttribute("batchUid",userBatchUid);
    model.addAttribute("userName",userName);

    String uriStem = PlugInUtil.getUriStem("bbdn", "bblogbackb2");

		model.addAttribute("uriStem", uriStem);

    // WARNING: GeneralUtil is an unpublished Class.
    // Blackboard in no way recommends or supports it's use for any purpose.
    // Use at your own risk. It may change at any time.
    // You are responsible for monitorin the package it ships with and
    // making changes to your code as necessary. Blackboard is under no
    // obligation to inform you if or when the class changes.
    String instance_guid = GeneralUtil.getSystemInstallationId();

    model.addAttribute("INSTANCE_GUID", instance_guid);
		model.addAttribute("serverTime", formattedDate );

		return "learnhello";
	}


        @RequestMapping(value = "/logbacklog", method = RequestMethod.GET)
	public String logbacklog(Locale locale, Model model) {
		// MyLogger.info("Using Learn Logger! The client locale is {}.", locale);
		logger.info("Welcome to /logbacklog! The client locale is {}.", locale);
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);

		String formattedDate = dateFormat.format(date);

		model.addAttribute("serverTime", formattedDate );

                MybbLOGGER.getBbLogger().logInfo(formattedDate + "  Info from logbacklog" );
                MybbLOGGER.getBbLogger().logError(formattedDate + "  Error from logbacklog, not a real Error" );
                MybbLOGGER.getBbLogger().logDebug(formattedDate + "  Debug from logbacklog" );

		return "logbacklog";
	}

  @RequestMapping(value = "/coursetest", method = RequestMethod.GET)
  public String coursetest(Locale locale, Model model) {
    logger.info("Welcome to /coursetest! The client locale is {}.", locale);
    // print internal Logback state
    LoggerContext lc = (LoggerContext) LoggerFactory.getILoggerFactory();
    StatusPrinter.print(lc);

    Date date = new Date();
    DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);

    String formattedDate = dateFormat.format(date);

    String uriStem = PlugInUtil.getUriStem("bbdn", "bblogbackb2");

    model.addAttribute("uriStem", uriStem);

    Course course;
    CourseDbLoader crsLoader;
    String batch_uid = "";
    String is_closed = "";
    try
    {
      crsLoader = CourseDbLoader.Default.getInstance();
      course = crsLoader.loadByCourseId("mbk-test");
      batch_uid = course.getBatchUid();
        if (course.isClosed())
          is_closed = "course.isClosed is TRUE";
        else
          is_closed = "course.isClosed is FALSE";
    }
    catch ( Exception e )
    {
          batch_uid = "load-course-failed";
          is_closed = "We don't know the state of course.isClosed().";
          e.printStackTrace();
    }

    model.addAttribute("BATCH_UID", batch_uid);
    model.addAttribute("IS_CLOSED", is_closed);

    // WARNING: GeneralUtil is an unpublished Class.
    // Blackboard in no way recommends or supports it's use for any purpose.
    // Use at your own risk. It may change at any time.
    // You are responsible for monitorin the package it ships with and
    // making changes to your code as necessary. Blackboard is under no
    // obligation to inform you if or when the class changes.
    String instance_guid = GeneralUtil.getSystemInstallationId();

    model.addAttribute("INSTANCE_GUID", instance_guid);
    model.addAttribute("serverTime", formattedDate );

    return "coursetest";
  }

  @RequestMapping(value = "/bbproperties", method = RequestMethod.GET)
  public String b2properties(Locale locale, Model model) {
    logger.info("Welcome to /bbproperties! The client locale is {}.", locale);
    // print internal Logback state
    LoggerContext lc = (LoggerContext) LoggerFactory.getILoggerFactory();
    StatusPrinter.print(lc);

    Date date = new Date();
    DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);

    String formattedDate = dateFormat.format(date);

    String uriStem = PlugInUtil.getUriStem("bbdn", "bblogbackb2");

    model.addAttribute("uriStem", uriStem);

    Properties properties = blackboard.platform.config.ConfigurationServiceFactory.getInstance().getBbProperties();

    model.addAttribute("properties", properties);

    // WARNING: GeneralUtil is an unpublished Class.
    // Blackboard in no way recommends or supports it's use for any purpose.
    // Use at your own risk. It may change at any time.
    // You are responsible for monitorin the package it ships with and
    // making changes to your code as necessary. Blackboard is under no
    // obligation to inform you if or when the class changes.
    String instance_guid = GeneralUtil.getSystemInstallationId();

    model.addAttribute("INSTANCE_GUID", instance_guid);
    model.addAttribute("serverTime", formattedDate );

    return "bbproperties";
  } // END

} // END public class HomeController {
