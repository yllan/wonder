/*
 * Copyright (C) NetStruxr, Inc. All rights reserved.
 *
 * This software is published under the terms of the NetStruxr
 * Public Software License version 0.5, a copy of which has been
 * included with this distribution in the LICENSE.NPL file.  */
package er.directtoweb.components.relationships;

import com.webobjects.appserver.WOComponent;
import com.webobjects.appserver.WOContext;
import com.webobjects.directtoweb.D2W;
import com.webobjects.directtoweb.D2WContext;
import com.webobjects.directtoweb.D2WDisplayToManyTable;
import com.webobjects.directtoweb.InspectPageInterface;
import com.webobjects.eoaccess.EOEntity;
import com.webobjects.eoaccess.EOModelGroup;

/**
 * Cleaned up some of the formatting on the original toMany table.<br />
 * 
 */
public class ERD2WDisplayToManyTable extends D2WDisplayToManyTable {

    public ERD2WDisplayToManyTable(WOContext context) {
        super(context);
    }

    public WOComponent inspectAction() {
        if(item!=null){
            D2WContext newContext=new D2WContext(session());
            newContext.takeValueForKey(item, "object");
            EOEntity entity = EOModelGroup.defaultGroup().entityNamed(item.entityName());
            newContext.takeValueForKey(entity, "entity");
            String inspectConfigurationName = (String)newContext.valueForKey("inspectConfigurationName");
            if(inspectConfigurationName!=null && item!=null){
                InspectPageInterface inspectPage=(InspectPageInterface)D2W.factory().pageForConfigurationNamed(inspectConfigurationName,
                                                                                                               session());
                inspectPage.setObject(item);
                inspectPage.setNextPage(context().page());
                return (WOComponent)inspectPage;
            }
        }
        return super.inspectAction();
    }
    
}