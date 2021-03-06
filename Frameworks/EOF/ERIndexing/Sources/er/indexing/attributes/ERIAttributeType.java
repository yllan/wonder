package er.indexing.attributes;

import java.text.Format;

import com.webobjects.eocontrol.*;

public class ERIAttributeType extends _ERIAttributeType {
    
    @SuppressWarnings("unused")
    private static final org.apache.log4j.Logger log = org.apache.log4j.Logger.getLogger(ERIAttributeType.class);

    public static final ERIAttributeTypeClazz clazz = new ERIAttributeTypeClazz();
    public static class ERIAttributeTypeClazz extends _ERIAttributeType._ERIAttributeTypeClazz {
        /* more clazz methods here */
    }

    public interface Key extends _ERIAttributeType.Key {}

    public void init(EOEditingContext ec) {
        super.init(ec);
    }

    public Format formatter() {
        return valueType().formatterForFormat(format());
    }
}
