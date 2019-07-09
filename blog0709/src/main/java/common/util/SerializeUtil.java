package common.util;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class SerializeUtil
{
    //序列化
    public static String serialize(Object object)
    {
        ObjectOutputStream oos = null;
        ByteArrayOutputStream baos = null;
        try {
            baos = new ByteArrayOutputStream();
            oos = new ObjectOutputStream(baos);
            oos.writeObject(object);
            byte[] bytes = baos.toByteArray();
            return new String(bytes);
        } catch (Exception e) {
        }
        return null;
    }

    //反序列化
    public static Object unserialize(String string)
    {
        byte[] bytes = string.getBytes();
        ByteArrayInputStream bais = null;
        try {
            bais = new ByteArrayInputStream(bytes);
            ObjectInputStream ois = new ObjectInputStream(bais);
            System.out.println("+++:");
            return ois.readObject();
        } catch (Exception e) {
            System.out.println("excep:" + e.getMessage());
        }

        return null;
    }
}
