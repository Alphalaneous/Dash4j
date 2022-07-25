package com.alphalaneous;

import com.alphalaneous.Exceptions.GDNotInitializedException;
import com.alphalaneous.Exceptions.OSNotSupportedException;
import com.sun.jna.Native;
import com.sun.jna.Pointer;
import com.sun.jna.platform.win32.*;
import com.sun.jna.ptr.IntByReference;
import com.sun.jna.win32.W32APIOptions;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public class Memory {

    private static final Kernel32 kernel32 = Native.loadLibrary("kernel32", Kernel32.class, W32APIOptions.DEFAULT_OPTIONS);
    private static final User32 user32 = Native.loadLibrary("user32", User32.class, W32APIOptions.DEFAULT_OPTIONS);
    private static final long base = 0x3222d0;
    private static long gameBase;
    private static WinNT.HANDLE hProcess;

    private static boolean initialized = false;

    public static void init(){

        if(!System.getProperty("os.name").toLowerCase().startsWith("windows")){
            throw new OSNotSupportedException(System.getProperty("os.name") + " is not supported by Dash4j");
        }


        initialized = true;
        checkPID(false);

        hProcess = openProcess(PID);

        new Thread(() -> checkPID(true)).start();
        new Thread(() -> {
            while(true) {
                hProcess = openProcess(PID);
                Utilities.sleep(100);
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

    public static void writeBytes(int[] offsets, byte[] value){
        writeMemory(hProcess, offsets, value);
    }

    public static void writeInt(int[] offsets, int value){
        writeMemory(hProcess, offsets, ByteBuffer.allocate(4).order(ByteOrder.nativeOrder()).putInt(value).array());
    }

    public static void writeFloat(int[] offsets, float value){
        writeMemory(hProcess, offsets, ByteBuffer.allocate(4).order(ByteOrder.nativeOrder()).putFloat(value).array());
    }

    public static void writeString(int[] offsets, String value){
        writeMemory(hProcess, offsets, value.getBytes());
    }

    private static void writeMemory(WinNT.HANDLE process, int[] offsets, byte[] data) {

        if(!initialized){
            throw new GDNotInitializedException("Memory not initialized, use Memory.init() to initialize.");
        }
        long addr = findDynAddress(hProcess, offsets, gameBase);

        int size = data.length;
        com.sun.jna.Memory toWrite = new  com.sun.jna.Memory(size);

        for(int i = 0; i < size; i++) {
            toWrite.setByte(i, data[i]);
        }
        kernel32.WriteProcessMemory(process, Pointer.createConstant(addr), toWrite, size, null);
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

            gameBase = GetModuleBaseAddress(PID) + base;

            isGDOpen = PID != 0;
            Utilities.sleep(1000);
        }
        while (doLoop);
    }
    private static WinNT.HANDLE openProcess(int pid) {
        return kernel32.OpenProcess(56, true, pid);
    }

    private static boolean isGDOpen = false;

    public static boolean isGDOpen(){
        return isGDOpen;
    }

    private static long GetModuleBaseAddress(int procID){
        WinDef.DWORD pid = new WinDef.DWORD(procID);
        WinNT.HANDLE hSnap = kernel32.CreateToolhelp32Snapshot(Tlhelp32.TH32CS_SNAPMODULE, pid);
        Tlhelp32.MODULEENTRY32W module = new Tlhelp32.MODULEENTRY32W();

        while(Kernel32.INSTANCE.Module32NextW(hSnap, module)) {

            String s = Native.toString(module.szModule);

            if(s.equals("GeometryDash.exe")){
                Pointer x = module.modBaseAddr;
                return Pointer.nativeValue(x);
            }
        }
        kernel32.CloseHandle(hSnap);

        return -1;
    }

    static {
        Memory.init();
    }
}
