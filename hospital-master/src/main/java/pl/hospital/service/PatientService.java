package pl.hospital.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.hospital.entity.User;
import pl.hospital.entity.Patient;
import pl.hospital.repository.PatientRepository;

import java.util.Optional;

@Service
public class PatientService {

    @Autowired
    private PatientRepository patientRepository;

    public Optional<Patient> findPatientById(long id){
        return patientRepository.findById(id);
    }


    public Patient addPatient(Patient patient){
       return patientRepository.save(patient);
    }


}
