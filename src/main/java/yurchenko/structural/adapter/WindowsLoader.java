package yurchenko.structural.adapter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class WindowsLoader implements Load {
    private static final Logger log = LoggerFactory.getLogger(WindowsLoader.class);

    @Override
    public void LinuxLoader(String os) {
    }

    @Override
    public void WindowsLoader(String os) {
        log.info("load... " + os);
    }

}
