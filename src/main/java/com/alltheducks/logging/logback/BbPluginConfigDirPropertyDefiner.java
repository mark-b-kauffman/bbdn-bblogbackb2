package com.alltheducks.logging.logback;

import blackboard.platform.plugin.PlugInException;
import blackboard.platform.plugin.PlugInUtil;
import ch.qos.logback.core.PropertyDefinerBase;
import ch.qos.logback.core.util.OptionHelper;

/**
 * Created by shane on 17/08/2016.
 */
public class BbPluginConfigDirPropertyDefiner extends PropertyDefinerBase {

    private String vendorId;
    private String handle;

    @Override
    public String getPropertyValue() {
        if (OptionHelper.isEmpty(vendorId)) {
            addError("The \"vendorId\" property must be set.");
            return null;
        }
        if (OptionHelper.isEmpty(vendorId)) {
            addError("The \"handle\" property must be set.");
            return null;
        }

        try {
            return PlugInUtil.getConfigDirectory(vendorId, handle).getAbsolutePath();
        } catch (PlugInException e) {
            addError(String.format("An exception was thrown when getting the plugin config directory for %s-%s",
                    vendorId, handle), e);
            return null;
        }
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
