package com.alltheducks.logging.logback;

import blackboard.platform.plugin.PlugInUtil;
import ch.qos.logback.core.PropertyDefinerBase;
import ch.qos.logback.core.util.OptionHelper;

/**
 * Created by shane on 17/08/2016.
 */
public class BbPluginLogDirPropertyDefiner extends PropertyDefinerBase {

    private String vendorId;
    private String handle;

    @Override
    public String getPropertyValue() {
        if (OptionHelper.isEmpty(vendorId)) {
            addError("The \"vendorId\" property must be set.");
            return null;
        }
        if (OptionHelper.isEmpty(handle)) {
            addError("The \"handle\" property must be set.");
            return null;
        }

        return PlugInUtil.getLogDirectory(vendorId, handle).getAbsolutePath();
    }

    public String getVendorId() {
        return vendorId;
    }

    public void setVendorId(String vendorId) {
        this.vendorId = vendorId;
    }

    public String getHandle() {
        return handle;
    }

    public void setHandle(String handle) {
        this.handle = handle;
    }
}
