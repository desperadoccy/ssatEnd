package pers.ccy.ssatweb.utils;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;

/**
 * @author desperado
 * @ClassName ModelMapperUtil
 * @Description
 * @date 2020/5/21 11:23
 * @Version 1.0
 */
public class ModelMapperUtil {

    private static ModelMapper modelMapper = new ModelMapper();

    static {
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
    }

    public static <D> D map(Object source, Class<D> destinationType) {
        return modelMapper.map(source, destinationType);
    }

}

