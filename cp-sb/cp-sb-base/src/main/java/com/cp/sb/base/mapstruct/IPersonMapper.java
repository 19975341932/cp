package com.cp.sb.base.mapstruct;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface IPersonMapper {

    IPersonMapper INSTANCT = Mappers.getMapper(IPersonMapper.class);

    @Mapping(target = "personName", source = "name")
    @Mapping(target = "id", ignore = true) // 忽略id，不进行映射
    @Mapping(target = "describe",source="describ", defaultValue = "eason我的爱")
    @Mapping(target = "createTime" ,source = "createTime", dateFormat = "yyyy-MM-dd")
    PersonDTO conver(PersonVo person);




}
