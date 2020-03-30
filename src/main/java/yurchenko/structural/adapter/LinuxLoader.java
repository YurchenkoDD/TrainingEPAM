package yurchenko.structural.adapter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LinuxLoader implements Load {

    private static final Logger log = LoggerFactory.getLogger(LinuxLoader.class);

    @Override
    public void WindowsLoader(String os) {
    }

    @Override
    public void LinuxLoader(String os) {
        log.info("Load... " + os);
    }
}

