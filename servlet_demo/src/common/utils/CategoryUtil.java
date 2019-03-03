package common.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class CategoryUtil
{
    public static List<Map<String, Object>> outCategories = new ArrayList<>();

    public static void recursionCategory(List<Map<String, Object>> inCategories, int parentId, int level)
    {
        for (int i = 0; i < inCategories.size(); i++) {
            Map<String, Object> tempMap = inCategories.get(i);
            if ((int) tempMap.get("parent_id") == parentId) {
                level = level + 1;
                tempMap.put("level",level);
                outCategories.add(tempMap);
                recursionCategory(inCategories, (int)tempMap.get("id"), level);
            }
        }
    }

    public static List<Map<String, Object>> getOutCategories()
    {
        return outCategories;
    }
}
