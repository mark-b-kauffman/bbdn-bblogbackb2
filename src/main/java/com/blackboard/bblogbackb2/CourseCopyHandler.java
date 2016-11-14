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

import blackboard.data.content.Content;
import blackboard.data.course.Course;
import blackboard.persist.PersistenceException;
import blackboard.persist.course.CourseDbLoader;
import blackboard.persist.course.CourseDbLoader.Default;
import blackboard.platform.cx.component.CopyControl;
import blackboard.platform.cx.component.CxComponent;
import blackboard.platform.cx.component.CxComponent.Usage;
import blackboard.platform.cx.component.CxComponentLogger;
import blackboard.platform.cx.component.ExportControl;
import blackboard.platform.cx.component.GenericPackageEntry;
import blackboard.platform.cx.component.ImportControl;
import blackboard.platform.log.LogService.Verbosity;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


/**
 * Handles requests for the application home page.
 */
public class CourseCopyHandler implements CxComponent {
	
	private static final Logger logger = LoggerFactory.getLogger(CourseCopyHandler.class);
	
  private static final int CHECK_JOB_INTERVAL_MILLIS = 5000;
  
  public CxComponent.Usage getUsage()
  {
    logger.info("CourseCopyHandler.getUsage");
    return CxComponent.Usage.ALWAYS;
  }
  
  public void doCopy(CopyControl cc)
  {
    try
    {
      logger.info("CourseCopyHandler.doCopy");

    }
    catch (Exception ex)
    {
      logger.info( "CourseCopyHandler.doCopy", ex);
      logger.info("Course media copy failed. Course src (" + cc.getSourceCourseId() + ") dest (" + cc.getDestinationCourseId() + ")");
    }
  }
  
   
  public String getComponentHandle()
  {
    logger.info("CourseCopyHandler.getComponentHandle");
    
    return "1234";
  }
  
  public String getApplicationHandle()
  {
    logger.info("CourseCopyHandler.getApplicationHandle");
    
    return "2345";
  }
  
  public String getName()
  {
    logger.info("CourseCopyHandler.getName");
    return "bblogbackb2 - course copy";
  }
  
  public void doExport(ExportControl ec)
  {
    logger.info("CourseCopyHandler.doExport not implemented");
  }
  
  public void doImport(GenericPackageEntry gpe, ImportControl ic)
  {
    logger.info("CourseCopyHandler.doImport - " + gpe + ", " + ic + " not implemented");
  }
  
  public void afterImportContent(Content content, ImportControl ic)
  {
    logger.info("CourseCopyHandler.afterImportContent - " + content + " " + ic + " not implemented");
  }


}
