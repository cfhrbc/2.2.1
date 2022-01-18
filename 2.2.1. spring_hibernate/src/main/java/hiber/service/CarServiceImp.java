package hiber.service;


import hiber.dao.CarDao;
import hiber.model.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
@Service
public class CarServiceImp implements CarService {
    @Autowired
    private CarDao carDao;

    @Override
    @Transactional
    public Car addCar(Car car) {
        carDao.addCar(car);
        return car;
    }
}
