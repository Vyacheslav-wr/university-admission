package by.salei.admission.service;

import by.salei.admission.Comparator.EnrolleeScoreComparator;
import by.salei.admission.dao.api.FacultyDao;
import by.salei.admission.entity.Enrollee;
import by.salei.admission.entity.EnrolleeStatus;
import by.salei.admission.entity.Faculty;
import by.salei.admission.service.api.AdmissionService;
import by.salei.admission.service.api.EnrolleeSubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AdmissionServiceImpl implements AdmissionService {

    @Autowired
    private EnrolleeSubjectService enrolleeSubjectService;

    @Autowired
    private FacultyDao facultyDao;

    @Override
    public void startAdmission() {

        List<Faculty> faculties = facultyDao.getAll();
        for (Faculty faculty : faculties) {

            List<Enrollee> enrolleeList = faculty.getEnrollees()
                    .stream()
                    .filter(entity -> entity.getStatus().equals(EnrolleeStatus.APPROVED))
                    .collect(Collectors.toList());

            enrolleeList.forEach(entity -> entity
                    .setScore(enrolleeSubjectService.calculateGeneralEnrolleeScore(entity.getId())));

            enrolleeList.sort(new EnrolleeScoreComparator());

            finishAdmission(enrolleeList, faculty.getStudentsSpots());
        }

    }

    public void finishAdmission(List<Enrollee> enrolleeList, Integer spots) {

        String status = "ENROLLED";

        for (Enrollee enrollee : enrolleeList) {

            if(spots == 0){
                status = "NOT_ENROLLED";
            }

            enrollee.setStatus(EnrolleeStatus.valueOf(status));

            spots--;
        }
    }
}
