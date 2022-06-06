package ua.epam.elearn.selection.committee.model.services;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import ua.epam.elearn.selection.committee.model.entity.Recruitment;

import java.util.List;

public class JobService implements Runnable {

    private static final Logger logger = LogManager.getLogger(JobService.class);

    private final RecruitmentService recruitmentService = ServiceFactory.getInstance().createRecruitmentService();
    private final ApplicationService applicationService = ServiceFactory.getInstance().createApplicationService();

    @Override
    public void run() {

        List<Recruitment> recruitmentList = recruitmentService.getAllOpenedOverdueRecruitments();
        for (Recruitment recruitment : recruitmentList) {
            logger.info("JobService found an expired recruitment {} ", recruitment);

            recruitmentService.closeRecruitment(recruitment.getId());
            applicationService.finalizeApplication(recruitment.getId());
        }
    }
}
