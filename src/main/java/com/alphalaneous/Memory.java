package com.alphalaneous;

import com.alphalaneous.Exceptions.GDNotInitializedException;
import com.alphalaneous.Exceptions.OSNotSupportedException;
import com.sun.jna.Native;
import com.sun.jna.Pointer;
import com.sun.jna.platform.win32.*;
import com.sun.jna.ptr.IntByReference;
import com.sun.jna.win32.W32APIOptions;

public class Memory {

    private final static Kernel32 kernel32 = Native.loadLibrary("kernel32", Kernel32.class, W32APIOptions.DEFAULT_OPTIONS);
    private final static User32 user32 = Native.loadLibrary("user32", User32.class, W32APIOptions.DEFAULT_OPTIONS);
    private static final long gameBase = 5579472;
    private static WinNT.HANDLE hProcess;
    private static final int PROCESS_VM_READ= 0x0010;
    private static final int PROCESS_VM_WRITE = 0x0020;
    private static final int PROCESS_VM_OPERATION = 0x0008;

    private static boolean initialized = false;

    public static void init(){

        if(!System.getProperty("os.name").toLowerCase().startsWith("windows")){
            throw new OSNotSupportedException(System.getProperty("os.name") + " is not supported by Dash4j");
        }

        initialized = true;
        checkPID(false);
        hProcess = openProcess(PROCESS_VM_READ|PROCESS_VM_WRITE|PROCESS_VM_OPERATION, PID);

        new Thread(() -> checkPID(true)).start();
        new Thread(() -> {
            while(true) {
                hProcess = openProcess(PROCESS_VM_READ|PROCESS_VM_WRITE|PROCESS_VM_OPERATION, PID);
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
    public static com.sun.jna.Memory read(int[] offsets, int bytesToRead) {
        if(!initialized){
            throw new GDNotInitializedException("Memory not initialized, use Memory.init() to initialize.");
        }
        long addr = findDynAddress(hProcess, offsets, gameBase);
        return readMemory(hProcess, addr, bytesToRead);
    }
    public static String readString(int[] offsets, int bytesToRead){

        if(!initialized){
            throw new GDNotInitializedException("Memory not initialized, use Memory.init() to initialize.");
        }
        long addr = findDynAddress(hProcess, offsets, gameBase);

        int length = readMemory(hProcess, addr + 0x10, bytesToRead).getInt(0);

        String string;

        try {
            if (length >= 16) {
                string = readMemory(hProcess, readMemory(hProcess, addr, bytesToRead).getInt(0), length).getString(0);
            } else {
                string = readMemory(hProcess, addr, bytesToRead).getString(0).substring(0, length);
            }
        }
        catch (StringIndexOutOfBoundsException e){
            return null;
        }
        if(string.length() < length) return null;
        else string = string.substring(0, length);

        if(string.equalsIgnoreCase("")) return null;

        return string;
    }


    private static com.sun.jna.Memory readMemory(WinNT.HANDLE process, long address, int bytesToRead) {
        IntByReference read = new IntByReference(0);
        com.sun.jna.Memory output = new com.sun.jna.Memory(bytesToRead);
        kernel32.ReadProcessMemory(process, Pointer.createConstant(address), output, bytesToRead, read);
        return output;
    }

    private static long findDynAddress(WinNT.HANDLE process, int[] offsets, long baseAddress) {
        Pointer pointer = new Pointer(baseAddress);
        int size = 4;
        com.sun.jna.Memory pTemp = new com.sun.jna.Memory(size);
        long pointerAddress = 0;

        for(int i = 0; i < offsets.length; i++) {
            if(i == 0) {
                kernel32.ReadProcessMemory(process, pointer, pTemp, size, null);
            }
            pointerAddress = pTemp.getInt(0)+offsets[i];
            if(i != offsets.length-1) kernel32.ReadProcessMemory(process, new Pointer(pointerAddress), pTemp, size, null);
        }
        return pointerAddress;
    }

    private static int PID;

    private static void checkPID(boolean doLoop){
        do {
            IntByReference pid = new IntByReference(0);

            user32.GetWindowThreadProcessId(user32.FindWindow(null, "Geometry Dash"), pid);

            PID = pid.getValue();

            isGDOpen = PID != 0;

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        while (doLoop);
    }
    private static WinNT.HANDLE openProcess(int permissions, int pid) {
        return kernel32.OpenProcess(permissions, true, pid);
    }

    private static boolean isGDOpen = false;

    public static boolean isGDOpen(){
        return isGDOpen;
    }

    static {
        Memory.init();
    }
}
