package com.example.Fitenssobacked.mapper;

import com.example.Fitenssobacked.dtos.FitnessClassDto;
import com.example.Fitenssobacked.model.FitnessClass;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface FitnessClassMapper {
    @Mapping(target = "fitenssTypeClass", source = "fitenssTypeClass.id")
    @Mapping(target = "user", source = "user.id")
    FitnessClassDto toDto(FitnessClass fitnessClass);

    @Mapping(target = "fitenssTypeClass.id", source = "fitenssTypeClass")
    @Mapping(target = "user.id", source = "user")
    FitnessClass toEntity(FitnessClassDto fitnessClassDto);
}
