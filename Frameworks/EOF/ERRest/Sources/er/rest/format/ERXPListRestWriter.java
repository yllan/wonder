package er.rest.format;

import com.webobjects.foundation.NSPropertyListSerialization;

import er.rest.ERXRestRequestNode;

public class ERXPListRestWriter implements IERXRestWriter {
	public void appendHeadersToResponse(ERXRestRequestNode node, IERXRestResponse response) {
		response.setHeader("text/plain", "Content-Type");
	}

	public void appendToResponse(ERXRestRequestNode node, IERXRestResponse response, ERXRestFormat.Delegate delegate) {
		appendHeadersToResponse(node, response);
		Object object = node.toNSCollection(delegate);
		response.appendContentString(NSPropertyListSerialization.stringFromPropertyList(object));
		response.appendContentString("\n");
	}
}
