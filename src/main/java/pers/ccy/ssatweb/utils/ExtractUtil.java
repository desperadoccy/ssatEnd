package pers.ccy.ssatweb.utils;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * @author desperado
 * @ClassName ExtractUtil
 * @Description
 * @date 2020/5/21 11:24
 * @Version 1.0
 */
public class ExtractUtil {
    public static <T, R> List<R> transferToList(List<T> list, Function<? super T, ? extends R> func) {
        return list.stream().map(func).collect(Collectors.toList());
    }

    public static <T, R> List<R> transferToDistinctList(List<T> list, Function<? super T, ? extends R> func) {
        return list.stream().map(func).collect(Collectors.toList()).stream().distinct().collect(Collectors.toList());
    }


    /**
     * 将list 转换为 唯一key: 对应的对象的形式，key必须唯一（如实体id）
     * <p>
     * T 列表元素类型
     * R key的类型
     */
    public static <T, R> Map<R, T> transferToMap(List<T> list, Function<? super T, ? extends R> func) {
        return list.stream().collect(Collectors.toMap(func, e -> e, (key1, key2) -> key2));
    }

    /**
     * 将list 转换为 某列为key：按照key进行分组的列表 的形式
     */
    public static <T, R> Map<R, List<T>> groupToMap(List<T> list, Function<? super T, ? extends R> func) {
        return list.stream().collect(Collectors.groupingBy(func));
    }

    public static <T> List<T> distinct(List<T> list) {
        return list.stream().distinct().collect(Collectors.toList());
    }

}
