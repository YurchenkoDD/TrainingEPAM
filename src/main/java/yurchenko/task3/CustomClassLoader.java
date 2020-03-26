package yurchenko.task3;

import lombok.extern.slf4j.Slf4j;

import java.io.*;

@Slf4j
public class CustomClassLoader extends ClassLoader {

    private String pathToBin;

    public CustomClassLoader(String path) {
        super();
        pathToBin = path;
    }

    /**
     * Get bytecode from file and load class
     *
     * @param className - name of class
     * @return loaded class or error
     * @throws ClassNotFoundException when class missing
     */
    @Override
    public Class<?> findClass(String className) throws ClassNotFoundException {
        try {
            byte[] bytes = fetchClassFromFS(pathToBin + className + ".class");
            return defineClass(className, bytes, 0, bytes.length);
        } catch (IOException e) {
            log.error(e.getMessage());
            return super.findClass(className);
        }
    }

    private byte[] fetchClassFromFS(String path) throws IOException {
        InputStream inputStream = new FileInputStream(new File(path));
        long length = new File(path).length();
        if (length > Integer.MAX_VALUE) {
            throw new IOException("File is too large");
        }
        byte[] bytes = new byte[(int) length];
        int offset = 0;
        int numRead;
        while (offset < bytes.length
                && (numRead = inputStream.read(bytes, offset, bytes.length - offset)) >= 0) {
            offset += numRead;
        }
        if (offset < bytes.length) {
            throw new IOException("Could not completely read file " + path);
        }
        inputStream.close();
        return bytes;
    }
}