package Service;

import java.io.*;

public class FolderMonitorImpl implements FolderMonitor {
    private DataInputStream inputStream;

    @Override
    public boolean isEOF() {
        try {
            if (inputStream.available() > 0)

                return false;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return true;
    }

    @Override
    public String[] getNames() {
        String index = "";
        while (!isEOF()) {
            openFile("song.txr");
            char c = (char) getB();
            index+=c;

            System.out.println(index);


        }


        return new String[0];
    }

    @Override
    public boolean openFile(String name) {
        try {
            inputStream = new DataInputStream(new FileInputStream(new File(name)));
            return true;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public byte getB() {
        try {
            return inputStream.readByte();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return -100;
    }

    @Override
    public boolean closeFile(String name) {
        try {
            inputStream.close();
            return true;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean isChange() {
        return false;
    }
}
