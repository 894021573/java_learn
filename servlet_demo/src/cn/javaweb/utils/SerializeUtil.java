package cn.javaweb.utils;

import java.io.*;

public class SerializeUtil
{

    // 序列化
    public static byte[] serialize(Object object)
    {

        ObjectOutputStream oos = null;
        ByteArrayOutputStream baos = null;
        byte[] bytes = null;
        try {
            baos = new ByteArrayOutputStream();
            oos = new ObjectOutputStream(baos);
            oos.writeObject(object);
            bytes = baos.toByteArray();
        } catch (Exception e) {
            System.err.println("序列化失败" + e.getMessage());
        }
        return bytes;
    }

    // 反序列化
    public static Object deserialize(byte[] bytes)
    {
        ByteArrayInputStream bais = null;
        ObjectInputStream ois = null;
        try {
            bais = new ByteArrayInputStream(bytes);
            ois = new ObjectInputStream(bais);
        } catch (Exception e) {
            System.err.println("反序列化失败" + e.getMessage());
        }

        Object object = null;
        try {
            object = ois.readObject();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        return object;
    }
}