package ua.epam.elearn.selection.committee.model.services;

import ua.epam.elearn.selection.committee.model.entity.Subject;

public abstract class ServiceFactory {

    private static volatile ServiceFactory serviceFactory;

    protected ServiceFactory() {
    }

    public abstract UserService createUserService();

    public abstract SubjectService createSubjectService();

    public abstract FacultyService createFacultyService();


    /* public abstract TourService createTourService();
     public abstract OrderService createOrderService();
     public abstract CountryService createCountryService();
 */
    public static ServiceFactory getInstance() {
        if (serviceFactory == null) {
            synchronized (ServiceFactory.class) {
                if (serviceFactory == null) {
                    serviceFactory = new ServiceFactoryImpl();
                }
            }
        }
        return serviceFactory;
    }
}
