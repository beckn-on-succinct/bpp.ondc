package in.succinct.bpp.extensions;

import com.venky.core.util.ObjectHolder;
import com.venky.extension.Extension;
import com.venky.extension.Registry;
import in.succinct.onet.core.adaptor.NetworkAdaptor;
import in.succinct.onet.core.adaptor.NetworkApiAdaptor;
import in.succinct.onet.ondc.extensions.OndcRegistry;

@SuppressWarnings("unused")
public class OndcApiAdaptorCreator implements Extension {
    static {
        Registry.instance().registerExtension(NetworkApiAdaptor.class.getName(),new OndcApiAdaptorCreator());
    }
    @Override
    public void invoke(Object... objects) {
        NetworkAdaptor adaptor= (NetworkAdaptor) objects[0];
        @SuppressWarnings("unchecked")
        ObjectHolder<NetworkApiAdaptor> h = (ObjectHolder<NetworkApiAdaptor>) objects[1];
        if (adaptor instanceof OndcRegistry){
            NetworkApiAdaptor networkApiAdaptor = new OndcApiAdaptor(adaptor);
            h.set(networkApiAdaptor);
        }
    }
}
