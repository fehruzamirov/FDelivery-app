package com.deliverybusiness.service;
import com.deliverybusiness.Dao.ICustomerDao;
import com.deliverybusiness.Dao.IOrderDao;
import com.deliverybusiness.exception.WrongIdException;
import com.deliverybusiness.model.Customer;
import com.deliverybusiness.model.Orders;
import com.deliverybusiness.model.dto.CustomerDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;


@Service
public class CustomerServiceImpl implements ICustomerService {
    @Autowired
    private ICustomerDao iCustomerDao;
    @Autowired
    private IOrderDao iOrderDao;

    public CustomerServiceImpl() {
    }
    public CustomerServiceImpl(ICustomerDao iCustomerDao) {
    }
    public CustomerServiceImpl(IOrderDao iOrderDao) {
        this.iOrderDao = iOrderDao;
    }

    public CustomerServiceImpl(ICustomerDao iCustomerDao, IOrderDao iOrderDao) {
        this.iCustomerDao = iCustomerDao;
        this.iOrderDao= iOrderDao;
    }

    @Override
    public Page<Customer> findAll(Pageable page) {
        return this.iCustomerDao.findAll(page);
    }

    @Override
    public Customer findById(int id) {
        Optional<Customer> optional = this.iCustomerDao.findById(id);

        if (optional.isPresent()) {
            return optional.get();
        } else {
            throw new WrongIdException("Id doesnt exist");
        }
    }

    @Override
    public Customer addCustomer(Customer customer) {
        return this.iCustomerDao.save(customer);
    }

    @Override
    public Customer updateCustomer(Customer customer, int id) {
        Customer customerDb = findById(id);
        customerDb.setFullName(customer.getFullName());
        customerDb.setAddress(customer.getAddress());
        customerDb.setCity(customer.getCity());
        return this.iCustomerDao.save(customerDb);

    }

    @Override
    public List<Customer> findByFullName(String name) {
        return this.iCustomerDao.findByFullName(name);
    }

    @Override
    public Page<Customer> findByCityAndAddress(String address, String cityName, Pageable pageable) {
        return this.iCustomerDao.findByCityAndAddress(address,cityName, pageable);
    }

    @Override
    public Customer updateCustomerName(String address, String name, CustomerDTO customerDTO) {
        Page<Customer> customerList = findByCityAndAddress(address,name, Pageable.unpaged());
        if(customerList.getContent().size() > 0){
            String fullName = customerDTO.getFirstName() + " " + customerDTO.getLastName();
            customerList.getContent().get(0).setFullName(fullName);
           return this.iCustomerDao.save(customerList.getContent().get(0));
        }
        return null;
    }

    @Override
    public List<Customer> findCustomerByOrder(double price) {
        return this.iOrderDao.findCustomerByOrder(price);
    }

    @Override
    public List<Orders> findByCustomer(int customerId) {
        Customer customer = this.findById(customerId);
        return this.iOrderDao.findByCustomer(customer);
    }

    @Override
    public Integer findNumberOfCustomersPerCity(String name) {
        if(name.isBlank()){
            return 0;
        }
        return this.iCustomerDao.findNumberOfCustomersPerCity(name);
    }

    @Override
    public Integer findNumberOfCustomersWhoLiveAtTheSameAddress(String address) {
        return this.iCustomerDao.findNumberOfCustomersWhoLiveAtTheSameAddress(address);
    }

}
