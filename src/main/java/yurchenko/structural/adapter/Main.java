package yurchenko.structural.adapter;

public class Main {
    public static void main(String[] args) {
        LoaderAdapter load = new LoaderAdapter();
        load.loader("windows");
        load.loader("linux");
        load.loader("mac");
    }
}
