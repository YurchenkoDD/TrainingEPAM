package yurchenko.structural.adapter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoaderAdapter implements Loader {
    Loader loader;
    private static final Logger log = LoggerFactory.getLogger(LoaderAdapter.class);

    @Override
    public void loader(String os) {
        if (os.equalsIgnoreCase("windows") || os.equalsIgnoreCase("linux")) {
            loader = new LoadAdapter(os);
            loader.loader(os);
        } else {
            log.info("No OS to load");
        }
    }
}
