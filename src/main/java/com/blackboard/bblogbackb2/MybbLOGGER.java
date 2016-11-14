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

// READ CAREFULLY! There are two loggers used in this class. The first is using the Blackboard Java APIs, Log and LogService.
// The second is using slf4j and Logback. The second logs to the blackboard/logs/custom directory and is used to keep track of everything 
// the code does with the first. The reason for this is that is so that we can follow the logic this class uses to create and log to 
// a file using the Learn Log and LogService classes.

import blackboard.platform.log.Log;
import blackboard.platform.log.LogService;
import blackboard.platform.log.LogService.Verbosity;
import blackboard.platform.log.LogServiceFactory;
import blackboard.platform.plugin.PlugInUtil;

import java.io.File;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.slf4j.Logger; // We'll use customLogback to log what this logging class is doing for troubleshooting.
import org.slf4j.LoggerFactory;

public class MybbLOGGER
{
  
  /* The following loggers, custom and plugin, are defined in the logback.xml file. */
  private static final Logger customLogback = LoggerFactory.getLogger("custom");
  private static final Logger pluginLogback = LoggerFactory.getLogger("plugin");
  
  /* We no longer use Learn's Logging APIs so we delete all of this

  private static LogService LOGSERVICE = null; // Changed this from LOGGER to LOGSERVICE FOR CLARITY. MBK
  private static Log B2LOG = null;  // MBK - added so we can only create the log file when it doesn't exist.


  private String logName = "bblogback.log.txt";
  File logsDirectory = null;
  private String pluginLogPath;
  */
  
  private static MybbLOGGER ABBLOGGER = null; // The singelton
  private static String loglevel;
  
  public static String getLoglevel() // We won't use this for this test. Just return the DEBUG log level.
  {

    loglevel = "DEBUG"; 

    return loglevel;
  }
  
  public static void setLoglevel(String loglevel)
  {
    if (loglevel != null) {
      loglevel = loglevel;
    }
  }
  
  public MybbLOGGER()
  {
    // planning ahead. really shouldn't need so much here... Logback aleady has our path set for us.
    /* Let's get rid of all of this for now.
    if (PlugInUtil.getLogDirectory("bbdn", "bblogbackb2") != null) {
      this.pluginLogPath = PlugInUtil.getLogDirectory("bbdn", "bblogbackb2").getAbsolutePath();
    } else {
      this.pluginLogPath = ""; // Something really went wrong here if this didn't run on startup...
    }
    */
  }
  
  public static MybbLOGGER getBbLogger() // Define a singelton logging class.
  {
    if (ABBLOGGER == null)
    {
      ABBLOGGER = new MybbLOGGER();

    }
    return ABBLOGGER;
  }
  
  public void logError(String logMessage)
  {
      String logLevelString="";
      if (getLoglevel()==null)
          logLevelString="NULL";
      else
          logLevelString=getLoglevel();
          
      customLogback.info("Enter logError() - logLevelString:"+logLevelString);
      pluginLogback.error("EnterLogError()- logLevelString:"+logLevelString);
      
      if ((getLoglevel() == null) || ("ALL".equalsIgnoreCase(getLoglevel())) || ("ERROR".equalsIgnoreCase(getLoglevel())) || ("DEBUG".equalsIgnoreCase(getLoglevel())) || ("WARN".equalsIgnoreCase(getLoglevel())) || ("INFO".equalsIgnoreCase(getLoglevel()))) {

          pluginLogback.error(logMessage);
          // No longer needed! logMessage(logMessage, LogService.Verbosity.ERROR);
      }
      customLogback.info("Exit logError()");
      pluginLogback.info("Exit logError()");
  }
  
  public void logInfo(String logMessage)
  {
      customLogback.info("Enter logInfo()");
      if ((getLoglevel() == null) || ("ALL".equalsIgnoreCase(getLoglevel())) || ("DEBUG".equalsIgnoreCase(getLoglevel())) || ("INFO".equalsIgnoreCase(getLoglevel()))) {
        pluginLogback.info(logMessage);
        // No longer needed! logMessage(logMessage, LogService.Verbosity.INFORMATION);
      }
      customLogback.info("Exit logInfo()");
  }
  
  public void logDebug(String logMessage)
  {
      customLogback.info("Enter logDebug()");
      if ((getLoglevel() == null) || ("ALL".equalsIgnoreCase(getLoglevel())) || ("DEBUG".equalsIgnoreCase(getLoglevel()))) {
        pluginLogback.debug(logMessage);
        // No longer needed! logMessage(logMessage, LogService.Verbosity.DEBUG);
      }
      customLogback.info("Exit logDebug()");
  }
 
  
  /* None of this is needed any more because we are using the Logback loggers.
  private void logMessage(String logMessage, LogService.Verbosity logLevel)
  {
    customLogback.info("Enter logMessage(). this.logName:" + this.logName);
    String B2LOGlogFileName = "";   
    String pluginLogFile = this.pluginLogPath + File.separator + this.logName; 
    
    
    customLogback.info("In logMessage. Set pluginLogFile="+pluginLogFile);
    
    if (B2LOG != null)
        B2LOGlogFileName = B2LOG.getLogFileName();
    else
        customLogback.info("B2LOG was NULL.");
    
    customLogback.info("In logMessage. B2LOG.getLogFileName():"+ B2LOGlogFileName +  " pluginLogFile:"+pluginLogFile);
   
    if ((B2LOG == null) || ((pluginLogPath != "") && (!B2LOGlogFileName.equalsIgnoreCase(pluginLogFile)))) // added || back for 1.6.0
    {
        customLogback.info("logMessage calling createLogFile()");
        createLogFile();
        customLogback.info("logMessage back from createLogFile()");
        B2LOG = LOGSERVICE.getConfiguredLog(this.logName);
    }
    customLogback.info("logMessage calling Log.log()");
    B2LOG.log(logMessage, logLevel);
    customLogback.info("Exit logMessage()");
  }
  
  private void createLogFile()
  {
    customLogback.info("Enter createLogFile()");
    try
    {
      customLogback.info("createLogFile calling PlugInUtil.getLogDirectory");
      this.logsDirectory = PlugInUtil.getLogDirectory("bbdn", "bblogbackb2");   // this.logsDirectory.toString() == this.pluginLogPath??
      customLogback.info("createLogFile this.logsDirectory String Value:" + this.logsDirectory.toString());
      if (!this.logsDirectory.isDirectory()) {
        customLogback.info("createLogFile this.logsDirectory.isDirectory was FALSE");
        customLogback.info("createLogFile calling this.logsDirectory.mkdir()"); 
        this.logsDirectory.mkdir();
      } else {
        // Nothing here... no more cleanUpLogFiles();
      }
      // 1.5.7 used defineNewFileLog only.  1.5.8+ will use both new File( and defineNewFileLog
      customLogback.info("createLogFile calling() new File("+ this.logsDirectory + File.separator + this.logName); // 1.6.0 will be using File.separator
      File logsFile = new File(this.logsDirectory + File.separator + this.logName);

      customLogback.info("createLogFile() calling LogService.defineNewFileLog with logName:" + this.logName + " and logFilePath:" +logsFile.toString());
      LOGSERVICE.defineNewFileLog(this.logName, logsFile.toString(), LogService.Verbosity.DEBUG, false);
      
      // The logFilePath parameter is the full path to the log file, not just the path. 1.5.7 code follows
      // String fullPathToLog = this.logsDirectory.getAbsolutePath()+ "/" +this.logName;
      // customLogback.info("createLogFile() calling LogService.defineNewFileLog with logName:" +this.logName + " and fullPathToLog:"+ fullPathToLog );
      // LOGSERVICE.defineNewFileLog(this.logName, fullPathToLog, LogService.Verbosity.DEBUG, false);
    }
    catch (Exception e)
    {
      customLogback.info("createLofFile() CAUGHT EXCEPTION");
      e.printStackTrace();
      if (e.getLocalizedMessage() != null)
        customLogback.info(e.getLocalizedMessage());
      else
        customLogback.info("createMessage() e.localizedMessage was null");
    }
  }
  
  */
  
  /* Ignore the following. It has nothing to do with the Log/LogService rolling log issue.
  The entire cleanUpLogfiles() usage was removed by Ellucian.
  private void cleanUpLogFiles()
  {
    int maxLogLimit = 5;
    DcbbUtil dcbbUtil = new DcbbUtil();
    String ml = dcbbUtil.getResourceString("application.log.limit");
    try
    {
      maxLogLimit = Integer.parseInt(ml);
    }
    catch (NumberFormatException e) {}
    Map<Long, File> logFileMap;
    int numFiles;
    if (this.logsDirectory != null)
    {
      File[] listOfFiles = this.logsDirectory.listFiles();
      logFileMap = new TreeMap();
      
      numFiles = listOfFiles.length;
      if (listOfFiles.length <= maxLogLimit + 1) {
        return;
      }
      for (int i = 0; i < listOfFiles.length; i++) {
        if (listOfFiles[i].isFile())
        {
          String filename = listOfFiles[i].getName();
          if (!filename.contains("ILPLog"))
          {
            listOfFiles[i].delete();
            numFiles--;
          }
          else
          {
            String dateStr = "";
            try
            {
              dateStr = filename.replace("ILPLog.", "").replace(".txt", "");
            }
            catch (Exception e) {}
            if (dateStr.equals(""))
            {
              numFiles--;
            }
            else
            {
              Long logDateTime = null;Date logDate = null;
              try
              {
                logDate = DcbbUtil.parseDate(dateStr, "yyyy-MM-dd", false);
              }
              catch (Exception e) {}
              if (logDate == null)
              {
                numFiles--;
              }
              else
              {
                logDateTime = Long.valueOf(logDate.getTime());
                
                logFileMap.put(logDateTime, listOfFiles[i]);
              }
            }
          }
        }
      }
      for (Long logTime : logFileMap.keySet())
      {
        ((File)logFileMap.get(logTime)).delete();
        numFiles--;
        if (numFiles <= maxLogLimit) {
          break;
        }
      }
    }
  } */
} //public class MybbLOGGER
