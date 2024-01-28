package in.succinct.bpp.ondc.extensions;

import com.venky.swf.db.extensions.AfterModelSaveExtension;
import in.succinct.bpp.ondc.db.model.BecknOrderMeta;

public class AfterSaveBecknOrderMeta extends AfterModelSaveExtension<BecknOrderMeta> {
    static {
        registerExtension(new AfterSaveBecknOrderMeta());
    }
    @Override
    public void afterSave(BecknOrderMeta model) {
        model.mineTransactionLines();
    }
}
