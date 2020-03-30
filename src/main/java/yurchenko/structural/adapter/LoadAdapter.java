package yurchenko.structural.adapter;

public class LoadAdapter implements Loader {

    Load loader;

    public LoadAdapter(String os) {
        if (os.equalsIgnoreCase("windows")) {
            loader = new WindowsLoader();
        } else if (os.equalsIgnoreCase("linux")) {
            loader = new LinuxLoader();
        }
    }

    @Override
    public void loader(String os) {
        if (os.equalsIgnoreCase("windows")) {
            loader.WindowsLoader(os);
        } else if (os.equalsIgnoreCase("linux")) {
            loader.LinuxLoader(os);
        }

    }
}
