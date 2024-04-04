package com.example.Fitenssobacked.service;

import com.example.Fitenssobacked.dtos.FitnessClassDto;
import com.example.Fitenssobacked.mapper.FitnessClassMapper;
import com.example.Fitenssobacked.model.FitenssTypeClass;
import com.example.Fitenssobacked.model.FitnessClass;
import com.example.Fitenssobacked.model.User;
import com.example.Fitenssobacked.repository.FitnessClassRepository;
import com.example.Fitenssobacked.repository.ReservationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class FitnessClassService {
    private final FitnessClassRepository fitnessClassRepository;
    private final FitnessClassMapper fitnessClassMapper;
    private final ReservationRepository reservationRepository;


    @Transactional
    //wys. zajec w terminie i z wolnymi miejscami
    public List<FitnessClass> getAllActiveClassesWithVacanciesAndInTime() {
        LocalDateTime now = LocalDateTime.now();
        List<FitnessClass> allClasses = fitnessClassRepository.findAll();

        return allClasses.stream()
                .filter(fitnessClass ->
                        fitnessClass.getEndDate().isAfter(now) &&
                                fitnessClass.getActivePlace() < fitnessClass.getMaxPlace())
                .collect(Collectors.toList());
    }
    @Transactional
    //WYS zajęc w terminie ale z pełnymi miejscami
    public List<FitnessClass> getAllMaxClass() {
        LocalDateTime now = LocalDateTime.now();
        List<FitnessClass> allClasses = fitnessClassRepository.findAll();

        return allClasses.stream()
                .filter(fitnessClass ->
                        fitnessClass.getEndDate().isAfter(now) &&
                                fitnessClass.getActivePlace() == fitnessClass.getMaxPlace())
                .collect(Collectors.toList());
    }
    @Transactional
    //wys. zajec po terminie
    public List<FitnessClass> getEndDate(){
        LocalDateTime now = LocalDateTime.now();
        List<FitnessClass> allClasses = fitnessClassRepository.findAll();

        return allClasses.stream()
                .filter(fitnessClass -> fitnessClass.getEndDate().isBefore(now))
                .collect(Collectors.toList());
    }
    @Transactional
    public FitnessClassDto addFitnessClass(FitnessClassDto fitnessClassDto) {
        FitnessClass fitnessClass = FitnessClass.builder()
                .numberClass(fitnessClassDto.getNumberClass())
                .fitenssTypeClass(FitenssTypeClass.builder().id(fitnessClassDto.getFitenssTypeClass()).build())
                .startDate(fitnessClassDto.getStartDate())
                .endDate(fitnessClassDto.getEndDate())
                .activePlace(fitnessClassDto.getActivePlace())
                .maxPlace(fitnessClassDto.getMaxPlace())
                .user(User.builder().id(fitnessClassDto.getUser()).build())
                .build();

        FitnessClass savedFitnessClass = fitnessClassRepository.save(fitnessClass);

        return FitnessClassDto.builder()
                .id(savedFitnessClass.getId())
                .numberClass(savedFitnessClass.getNumberClass())
                .fitenssTypeClass(savedFitnessClass.getFitenssTypeClass().getId())
                .startDate(savedFitnessClass.getStartDate())
                .endDate(savedFitnessClass.getEndDate())
                .activePlace(savedFitnessClass.getActivePlace())
                .maxPlace(savedFitnessClass.getMaxPlace())
                .user(savedFitnessClass.getUser().getId())
                .build();
    }
    //update class
    @Transactional
    public FitnessClassDto updateFitnessClass(Long id, FitnessClassDto fitnessClassDto) {
        Optional<FitnessClass> optionalFitnessClass = fitnessClassRepository.findById(id);
        if (optionalFitnessClass.isPresent()) {
            FitnessClass existingFitnessClass = optionalFitnessClass.get();
            FitnessClass updatedFitnessClass = fitnessClassMapper.toEntity(fitnessClassDto);
            BeanUtils.copyProperties(updatedFitnessClass, existingFitnessClass, "id");
            FitnessClass savedFitnessClass = fitnessClassRepository.save(existingFitnessClass);
            return fitnessClassMapper.toDto(savedFitnessClass);
        } else {
            return null;
        }
    }
    //usuwanie zajce
    @Transactional
    public void deleteFitnessClass(Long fitnessClassId) {
        // Sprawdź, czy istnieją rezerwacje związane z danymi zajęciami
        boolean reservationsExist = reservationRepository.existsByFitnessClassId(fitnessClassId);
        if (reservationsExist) {
            // Jeśli tak, usuń rezerwacje
            reservationRepository.deleteByFitnessClassId(fitnessClassId);
        }
        // Następnie usuń zajęcia
        fitnessClassRepository.deleteById(fitnessClassId);
    }
}
